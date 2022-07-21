package com.ypp.entity;

import javax.persistence.*;

import lombok.Data;

import java.util.Set;

@Entity
@Table
@Data
public class User {

    @Id
  //  @GeneratedValue(strategy= GenerationType.AUTO)
  //  private Long id;
    private String userName;
    private String userFirstName;
    private String userLastName;
    private String userPassword;
    
    private String address;
    private String avatarURL;
    private String phone;    
    private String age;
	private String dob;
	private String height;
	private String education;
	private String languages;
	private String gendre;
   	private String hobbies;
   	private String drinker;
   	private String smoker;
   	
   	private String website;
	private String github;
	private String twitter;
	private String instagram;
	private String facebook;
	
	private String country;
	private String state;
	private String city;
	private String street;
	private String zipcode;
	private String email;
	private String nameoncard;
	private String cardnumber;
	private String expirationdate;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLE",
            joinColumns = {
                    @JoinColumn(name = "USER_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "ROLE_ID")
            }
    )
    
    private Set<Role> role;  
}
