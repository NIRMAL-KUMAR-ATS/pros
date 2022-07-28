package com.ypp.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBillingDetails {

	private Long id;
	private String username;
	private String country;
	private String state;
	private String city;
	private String street;
	private String zipcode;
	private String emali;
	private String nameoncard;
	private String cardnumber;
	private String expirationdate;
}
