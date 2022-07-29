package com.ypp.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ypp.model.UserAccount;
import com.ypp.repository.UserAccountRepository;

@RestController
@RequestMapping("/api/account")
public class UserAccountController {
	
	@Autowired
	private UserAccountRepository userAccountRepository;
	
	@PostMapping("/add")
	public UserAccount createUserAccount(@RequestBody UserAccount userAccount) {
	
    return userAccountRepository.save(userAccount);
       
	}
	

	@PutMapping("/{id}")
	public UserAccount updateUserAccount(@PathVariable Long id, @RequestBody UserAccount userAccount) {
	 
	  return userAccountRepository.findById(id).map(userAccounts -> {
		  userAccounts.setTwitteraccount(userAccounts.getTwitteraccount());
		  userAccounts.setGoogleaccount(userAccounts.getGoogleaccount());
		  userAccounts.setFacebookaccount(userAccounts.getFacebookaccount());
		  userAccounts.setInstagramaccount(userAccounts.getInstagramaccount());
		  userAccounts.setOnlyfriends(userAccounts.getOnlyfriends());
	        return userAccountRepository.save(userAccount);
	    }).orElseThrow();
}
	

	@GetMapping("/all")
	public List<UserAccount> getUserAccount() {
	
    return userAccountRepository.findAll();
      
	}
	
	@GetMapping("/all/{id}")
	public Optional<UserAccount> getUserAccountById(@PathVariable Long id) {
	
    return userAccountRepository.findById(id);
      
	}

	

}
