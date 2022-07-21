package com.ypp.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ypp.entity.Post;
import com.ypp.entity.ResponseHandler;
import com.ypp.entity.User;
import com.ypp.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    
    @Autowired
//    private PostServices postServices;

    @PostConstruct
    public void initRoleAndUser() {
        userService.initRoleAndUser();
    }

    public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping({"/registerNewUser"})
    public User registerNewUser(@RequestBody User user) {
        return userService.registerNewUser(user);
    }

    @GetMapping({"/forAdmin"})
    @PreAuthorize("hasRole('Admin')")
    public String forAdmin(){
        return "This URL is only accessible to the admin";
    }

//    @GetMapping({"/forUser"})
//    //@PreAuthorize("hasRole('User')")
//    public List<User> forUser( User user){
//    	
//        return userService.getUser();
//        
//    }

	@GetMapping("/forUser")
    @PreAuthorize("hasRole('User')")
	public List<User> getUser() {
		//ResponseEntity<Object> result = userService.getUser();
		return userService.getUser();
		//return ResponseHandler.generateResponse(userService.getUser(), HttpStatus.OK);
        //return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, result);
	}
	
//	@PutMapping("/forUser/{id}")
//    @PreAuthorize("hasRole('User')")
//	public List<User> updateUser(@PathVariable String id, @RequestBody User user){
//		user.setUserName(id);
//		return (List<User>) this.userService.userUpdate(user);
//		
//	}
	
	/*
	@GetMapping("/forUser/{id}")
    @PreAuthorize("hasRole('User')")
	public List<User> getUserById() {
		//ResponseEntity<Object> result = userService.getUser();
		return userService.getUser();
		//return ResponseHandler.generateResponse(userService.getUser(), HttpStatus.OK);
        //return ResponseHandler.generateResponse("Successfully added data!", HttpStatus.OK, result);
	}*/
    
    @PostMapping({"/post"})
    @PreAuthorize("hasRole('User')")
    public Post createPost(@RequestBody Post post) {
        return userService.createPost(post);
    }
     
    
//    @GetMapping("/forUser")
//	public ResponseEntity<List<ProductResp>> getAllProduct() throws JsonProcessingException {
//		return ResponseEntity.ok().body(productService.getAllProduct());
//	}
    
}
