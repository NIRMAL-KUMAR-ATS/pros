package com.ypp.service;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.ypp.dao.PostDao;
import com.ypp.dao.RoleDao;
import com.ypp.dao.UserDao;
import com.ypp.entity.Post;
import com.ypp.entity.Role;
import com.ypp.entity.User;

@Service
public class PostServices {

	  @Autowired
	  private PostDao postDao;
	  @Autowired
	  private UserDao userDao;
	  @Autowired
	  private RoleDao roleDao;
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

//	        User user = new User();
//	        user.setUserName("raj123");
//	        user.setUserPassword(getEncodedPassword("raj@123"));
//	        user.setUserFirstName("raj");
//	        user.setUserLastName("sharma");
//	        Set<Role> userRoles = new HashSet<>();
//	        userRoles.add(userRole);
//	        user.setRole(userRoles);
//	        userDao.save(user);
	    }

	    public Post createPost(Post post) {
	        Role role = roleDao.findById("Post").get();
	        Set<Role> userRoles = new HashSet<>();
	        userRoles.add(role);
	        return postDao.save(post);
	    }

	    public String getEncodedPassword(String password) {
	        return passwordEncoder.encode(password);
	    }
}
