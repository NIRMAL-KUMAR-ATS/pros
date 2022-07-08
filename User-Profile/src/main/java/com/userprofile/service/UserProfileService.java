package com.userprofile.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.userprofile.entity.UserProfile;
import com.userprofile.repository.UserProfileRepository;

@Service
public class UserProfileService {

	@Autowired
	private UserProfileRepository userProfileRepository;

	public void saveImage(UserProfile imageGallery) {

		userProfileRepository.save(imageGallery);
	}

	public List<UserProfile> getAllActiveImages() {

		return userProfileRepository.findAll();
	}

	public Optional<UserProfile> getImageById(Long id) {

		return userProfileRepository.findById(id);
	}

	public void deleteUser(Long id) {

		userProfileRepository.deleteById(id);
	}

	public void updateUser(Long id) {

		userProfileRepository.findAll();
	}
	
}
