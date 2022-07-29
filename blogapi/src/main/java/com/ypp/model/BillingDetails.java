package com.ypp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.ypp.model.audit.UserDateAudit;
import lombok.Data;

@Entity
@Data
@Table(name = "billingdetails")
//@Table(name = "posts", uniqueConstraints = { @UniqueConstraint(columnNames = { "title" }) })
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class BillingDetails extends UserDateAudit {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String country;
	private String state;
	private String city;
	private String street;
	private String zipcode;
	private String emali;
	private String nameoncard;
	private String cardnumber;
	private String expirationdate;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public BillingDetails(Long id, String country, String state, String city, String street, String zipcode,
			String emali, String nameoncard, String cardnumber, String expirationdate) {
		super();
		this.id = id;
		this.country = country;
		this.state = state;
		this.city = city;
		this.street = street;
		this.zipcode = zipcode;
		this.emali = emali;
		this.nameoncard = nameoncard;
		this.cardnumber = cardnumber;
		this.expirationdate = expirationdate;
	}

	@Override
	public String toString() {
		return "BillingDetails [id=" + id + ", country=" + country + ", state=" + state + ", city=" + city + ", street="
				+ street + ", zipcode=" + zipcode + ", emali=" + emali + ", nameoncard=" + nameoncard + ", cardnumber="
				+ cardnumber + ", expirationdate=" + expirationdate + ", getId()=" + getId() + ", getCountry()="
				+ getCountry() + ", getState()=" + getState() + ", getCity()=" + getCity() + ", getStreet()="
				+ getStreet() + ", getZipcode()=" + getZipcode() + ", getEmali()=" + getEmali() + ", getNameoncard()="
				+ getNameoncard() + ", getCardnumber()=" + getCardnumber() + ", getExpirationdate()="
				+ getExpirationdate() + ", hashCode()=" + hashCode() + ", getCreatedBy()=" + getCreatedBy()
				+ ", getUpdatedBy()=" + getUpdatedBy() + ", toString()=" + super.toString() + ", getCreatedAt()="
				+ getCreatedAt() + ", getUpdatedAt()=" + getUpdatedAt() + ", getClass()=" + getClass() + "]";
	}

	public BillingDetails() {
		
		super();
		
	}
}
