package com.ypp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ypp.model.Profile;
import com.ypp.model.ProfileDao;
import com.ypp.model.WebUser;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class ProfileService {
	
    @Autowired
    private ProfileDao profileDao;

    public Profile findProfile(WebUser user) {
        return profileDao.findByUser(user);
    }

    public void save(Profile profile) {
        profileDao.save(profile);
    }

    public List<Profile> getAll() {
        List<Profile> profiles = new ArrayList<>();

        profileDao.findAll().forEach(profile -> profiles.add(profile));

        profiles.sort(Comparator.comparing(Profile::getId));

        return profiles;
    }
}
