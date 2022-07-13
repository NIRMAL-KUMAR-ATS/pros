package com.ypp.model;

import javax.persistence.*;

@Entity
@Table
public class Profile {
	
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @OneToOne(targetEntity = WebUser.class)
    @JoinColumn(nullable = false)
    private WebUser user;

    @Column(length=1000)
    private String about;

    String address;

    String avatarURL;

    String phone;

    String fullname;
    
    String age;
	String dob;
	String height;
	String education;
	String languages;
	String gendre;
   	String hobbies;
   	String drinker;
   	String smoker;
   	
   	String website;
	String github;
	String twitter;
	String instagram;
	String facebook;

    public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getGithub() {
		return github;
	}

	public void setGithub(String github) {
		this.github = github;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getInstagram() {
		return instagram;
	}

	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getLanguages() {
		return languages;
	}

	public void setLanguages(String languages) {
		this.languages = languages;
	}

	public String getGendre() {
		return gendre;
	}

	public void setGendre(String gendre) {
		this.gendre = gendre;
	}

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	public String getDrinker() {
		return drinker;
	}

	public void setDrinker(String drinker) {
		this.drinker = drinker;
	}

	public String getSmoker() {
		return smoker;
	}

	public void setSmoker(String smoker) {
		this.smoker = smoker;
	}

	@PrePersist
    protected void onCreate() {
        if (avatarURL == null) {
            avatarURL = "/avatar/default.png";
        }

    }

    public Profile(WebUser user) {
        this.user = user;
        this.fullname = user.getUsername();
    }

    public Profile() {

    }


    public Long getId() {
        return id;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvatarURL() {
        return avatarURL;
    }

    public void setAvatarURL(String avatarURL) {
        this.avatarURL = avatarURL;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public WebUser getUser() {
        return user;
    }

    public void setUser(WebUser user) {
        this.user = user;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
}
