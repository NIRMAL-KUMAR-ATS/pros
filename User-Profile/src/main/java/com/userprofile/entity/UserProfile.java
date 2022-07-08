package com.userprofile.entity;

import java.util.Arrays;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "usersprofile")
@Data
public class UserProfile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private Long id;
	@Lob
	@Column(name = "Image", length = Integer.MAX_VALUE, nullable = true)
	private byte[] image;
	private String userProfileName;
	private String age;
	private String dob;
	private String height;
	private String city;
	private String education;
   	private String occupation;
   	private String languages;
   	private String performance;
   	private String gendre;
   	private String hobbies;
   	private String drinker;
   	private String smoker;
   	private String location;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public String getUserProfileName() {
		return userProfileName;
	}
	public void setUserProfileName(String userProfileName) {
		this.userProfileName = userProfileName;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getLanguages() {
		return languages;
	}
	public void setLanguages(String languages) {
		this.languages = languages;
	}
	public String getPerformance() {
		return performance;
	}
	public void setPerformance(String performance) {
		this.performance = performance;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public UserProfile() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserProfile(Long id, byte[] image, String userProfileName, String age, String dob, String height,
			String city, String education, String occupation, String languages, String performance, String gendre,
			String hobbies, String drinker, String smoker, String location) {
		super();
		this.id = id;
		this.image = image;
		this.userProfileName = userProfileName;
		this.age = age;
		this.dob = dob;
		this.height = height;
		this.city = city;
		this.education = education;
		this.occupation = occupation;
		this.languages = languages;
		this.performance = performance;
		this.gendre = gendre;
		this.hobbies = hobbies;
		this.drinker = drinker;
		this.smoker = smoker;
		this.location = location;
	}
	
	@Override
	public String toString() {
		return "UserProfile [id=" + id + ", image=" + Arrays.toString(image) + ", userProfileName=" + userProfileName
				+ ", age=" + age + ", dob=" + dob + ", height=" + height + ", city=" + city + ", education=" + education
				+ ", occupation=" + occupation + ", languages=" + languages + ", performance=" + performance
				+ ", gendre=" + gendre + ", hobbies=" + hobbies + ", drinker=" + drinker + ", smoker=" + smoker
				+ ", location=" + location + ", getId()=" + getId() + ", getImage()=" + Arrays.toString(getImage())
				+ ", getUserProfileName()=" + getUserProfileName() + ", getAge()=" + getAge() + ", getDob()=" + getDob()
				+ ", getHeight()=" + getHeight() + ", getCity()=" + getCity() + ", getEducation()=" + getEducation()
				+ ", getOccupation()=" + getOccupation() + ", getLanguages()=" + getLanguages() + ", getPerformance()="
				+ getPerformance() + ", getGendre()=" + getGendre() + ", getHobbies()=" + getHobbies()
				+ ", getDrinker()=" + getDrinker() + ", getSmoker()=" + getSmoker() + ", getLocation()=" + getLocation()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
}
