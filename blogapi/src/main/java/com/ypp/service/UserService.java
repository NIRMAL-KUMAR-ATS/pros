package com.ypp.service;

import com.ypp.model.user.User;
import com.ypp.payload.ApiResponse;
import com.ypp.payload.InfoRequest;
import com.ypp.payload.UserIdentityAvailability;
import com.ypp.payload.UserProfile;
import com.ypp.payload.UserSummary;
import com.ypp.security.UserPrincipal;

public interface UserService {

	
	UserSummary getCurrentUser(UserPrincipal currentUser);

	UserIdentityAvailability checkUsernameAvailability(String username);

	UserIdentityAvailability checkEmailAvailability(String email);

	UserProfile getUserProfile(String username);

	User addUser(User user);

	User updateUser(User newUser, String username, UserPrincipal currentUser);

	ApiResponse deleteUser(String username, UserPrincipal currentUser);

	ApiResponse giveAdmin(String username);

	ApiResponse removeAdmin(String username);

	UserProfile setOrUpdateInfo(UserPrincipal currentUser, InfoRequest infoRequest);

}