package com.ypp.controllers;

import java.util.Collections;
import java.util.Date;
import javax.management.relation.Role;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.ypp.model.Profile;
import com.ypp.model.VerificationToken;
import com.ypp.model.WebUser;
import com.ypp.model.WebUserDao;
import com.ypp.service.EmailService;
import com.ypp.service.ProfileService;
import com.ypp.service.WebUserService;

@Controller
public class AuthController {
	
	@Autowired
    private WebUserService webUserService;

    @Autowired
    private EmailService emailService;
    
    @Autowired
    private ProfileService profileService;

    @Value("${message.registration.confirmed}")
    private String registrationConfirmedMessage;

    @Value("${message.invalid.user}")
    private String invalidUserMessage;

    @Value("${message.expired.token}")
    private String expiredTokenMessage;
    

    @RequestMapping("/login")
    String admin() {
    	
        return "app.login";
        
    }

    @RequestMapping("/register")
    ModelAndView register(ModelAndView modelAndView) {

        WebUser user = new WebUser();

        modelAndView.getModel().put("user", user);

       modelAndView.setViewName("app.register");

        return modelAndView;

    }

    @RequestMapping(value="/register", method= RequestMethod.POST, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
   // @PostMapping(value = "/register")
  // @ResponseBody
    public ModelAndView register (Object model ,ModelAndView modelAndView, @ModelAttribute(value="user") @Valid WebUser user, BindingResult result) {

	
    	
       modelAndView.setViewName("app.register");

        if(!result.hasErrors()) {

            webUserService.register(user);

            Profile profile = new Profile(user);
            profileService.save(profile);

            String token = webUserService.createEmailVerificationToken(user);

            emailService.sendVerificationEmail(user.getEmail(), user.getUsername(), token);

           modelAndView.setViewName("redirect:/verify");
        }
        
        return modelAndView;
        
      // return "User Registerred successfully :"+ user.getUsername()+ " " + user.getPassword() + " " + user.getConfirmPassword()+ " " + user.getEmail();
       // return new ModelAndView(new MappingJacksonJsonView(), model);

       //return new ModelAndView("{\"email\" : \"email\"}", HttpStatus.OK);
        //new ResponseEntity<>("{\"status\" : \"UP\"}", HttpStatus.OK);
    
    }
    
//    public ModelAndView userAccount(ModelAndView modelAndView ,@ModelAttribute(value="useraccount") @Valid WebUser user, BindingResult result) {
//    	
//    	modelAndView.setViewName("app.useraccount");
//    	
//    	Profile profile = new Profile(user);
//    	profileService.save(profile);
//    	
//    	modelAndView.setViewName(expiredTokenMessage);
//    	
//		return modelAndView;
//		
//    }
    
    @RequestMapping("/verify")
    String verify() {
    	
        return "app.verify";
        
    }

    @RequestMapping("/confirmregister" )
    ModelAndView registration(ModelAndView modelAndView, @RequestParam("t") String tokenString) {

        VerificationToken token = webUserService.getVerification(tokenString);
        System.out.println(tokenString);
        System.out.println("token is null?: " + token);

        if (token == null) {
            modelAndView.setViewName("redirect:/invaliduser");
          System.out.println("token still not deleted");
            return modelAndView;
            
        }

        Date expiryDate = token.getExpiry();
        if (expiryDate.before(new Date())) {
            modelAndView.setViewName("redirect:/expiredtoken");
            
            System.out.println("token deleted");
            
            webUserService.deleteToken(token);
            return modelAndView;
            
        }

        WebUser user = token.getUser();

        if (user == null) {
            modelAndView.setViewName("redirect:/invaliduser");
            webUserService.deleteToken(token);
            return modelAndView;
            
        }

        webUserService.deleteToken(token);
        user.setEnabled(true);
        webUserService.save(user);

        modelAndView.getModel().put("message", registrationConfirmedMessage);
        modelAndView.setViewName("app.message");

        return modelAndView;
        
    }

    @RequestMapping("/invaliduser" )
    ModelAndView invalidUser(ModelAndView modelAndView) {

        modelAndView.getModel().put("message", invalidUserMessage);
        modelAndView.setViewName("app.message");

        return modelAndView;
        
    }

    @RequestMapping("/expiredtoken" )
    ModelAndView expiredToken(ModelAndView modelAndView) {

        modelAndView.getModel().put("message", expiredTokenMessage);
        modelAndView.setViewName("app.message");

        return modelAndView;
        
    }
}
