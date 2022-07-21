package com.ypp.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.ypp.entity.Post;
import com.ypp.service.PostServices;
import com.ypp.service.UserService;

@Controller
public class PostController {

	 @Autowired
	 private PostServices postServices;
	 
	 @Autowired
	  private UserService userService;

	 
	 @PostConstruct
	    public void initRoleAndUser() {
		 
		 userService.initRoleAndUser();
	    
	 }
	 
//	    @PostMapping({"/post"})
//	    @PreAuthorize("hasRole('User')")
//	    public Post registerNewUser(@RequestBody Post post) {
//	        return postServices.createPost(post);
//	    }
}
