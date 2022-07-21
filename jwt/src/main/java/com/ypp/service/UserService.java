package com.ypp.service;

import com.ypp.dao.PostDao;
import com.ypp.dao.RoleDao;
import com.ypp.dao.UserDao;
import com.ypp.entity.Post;
import com.ypp.entity.Role;
import com.ypp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;
    
    @Autowired
    private PostDao postDao;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void initRoleAndUser() {

        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role");
        roleDao.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Default role for newly created record");
        roleDao.save(userRole);

        User adminUser = new User();
        adminUser.setUserName("admin123");
        adminUser.setUserPassword(getEncodedPassword("admin@pass"));
        adminUser.setUserFirstName("admin");
        adminUser.setUserLastName("admin");
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userDao.save(adminUser);

//        User user = new User();
//        user.setUserName("raj123");
//        user.setUserPassword(getEncodedPassword("raj@123"));
//        user.setUserFirstName("raj");
//        user.setUserLastName("sharma");
//        Set<Role> userRoles = new HashSet<>();
//        userRoles.add(userRole);
//        user.setRole(userRoles);
//        userDao.save(user);
    }

    public User registerNewUser(User user) {
        Role role = roleDao.findById("User").get();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        user.setRole(userRoles);
        user.setUserPassword(getEncodedPassword(user.getUserPassword()));
        return userDao.save(user);
        
    }
    
    public Post createPost(Post post) {
        Role role = roleDao.findById("Post").get();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        return postDao.save(post);
    }
    
    public List<User> getUser() {
    	
    	return (List<User>) this.userDao.findAll();
    	
    }
    
   /* public List<User> userUpdate(User user) {
    	Optional<User> users = this.userDao.findById(user.getUserName());
  //Optional<ProductResp> productDb = this.productRepository.findById(product.getId());
		
    	if(users.isPresent()) {
    		User userupadte = users.get();
    		userupadte.setAddress(user.getAddress());
    		userupadte.setAge(user.getAge());
    		userupadte.setAvatarURL(user.getAvatarURL());
    		userupadte.setCardnumber(user.getCardnumber());
    		userupadte.setCity(user.getCity());
    		userupadte.setCountry(user.getCountry());
    		userupadte.setDob(user.getDob());
    		userupadte.setDrinker(user.getDrinker());
    		userupadte.setEducation(user.getEducation());
    		userupadte.setEmail(user.getEmail());
    		userupadte.setExpirationdate(user.getExpirationdate());
    		userupadte.setFacebook(user.getFacebook());
    		userupadte.setGendre(user.getGendre());
    		userupadte.setGithub(user.getGithub());
    		userupadte.setHeight(user.getHeight());
    		userupadte.setHobbies(user.getHobbies());
    		userupadte.setInstagram(user.getInstagram());
    		userupadte.setLanguages(user.getLanguages());
    		userupadte.setNameoncard(user.getNameoncard());
    		userupadte.setPhone(user.getSmoker());
    		userupadte.setRole(user.getRole());
    		userupadte.setSmoker(user.getSmoker());
    		userupadte.setState(user.getState());
    		userupadte.setStreet(user.getStreet());
    		userupadte.setTwitter(user.getTwitter());
    		userupadte.setUserFirstName(user.getUserFirstName());
    		userupadte.setUserLastName(user.getUserLastName());
    		userupadte.setUserName(user.getUserName());
    		userupadte.setUserPassword(user.getUserPassword());
    		userupadte.setWebsite(user.getWebsite());
    		userupadte.setZipcode(user.getZipcode());
    		userDao.save(userupadte);
    		return (List<User>) userupadte;
    	}
		return (List<User>) user;	
    	
    }*/
   
    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }
}
