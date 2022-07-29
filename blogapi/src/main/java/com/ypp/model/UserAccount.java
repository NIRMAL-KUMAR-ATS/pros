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
@Table(name = "useraccount")
public class UserAccount extends UserDateAudit   {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String twitteraccount;
	private String googleaccount;
	private String facebookaccount;
	private String instagramaccount;
	private String onlyfriends;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public UserAccount(Long id, String twitteraccount, String googleaccount, String facebookaccount,
			String instagramaccount, String onlyfriends) {
		super();
		this.id = id;
		this.twitteraccount = twitteraccount;
		this.googleaccount = googleaccount;
		this.facebookaccount = facebookaccount;
		this.instagramaccount = instagramaccount;
		this.onlyfriends = onlyfriends;
	}

	@Override
	public String toString() {
		return "UserAccount [id=" + id + ", twitteraccount=" + twitteraccount + ", googleaccount=" + googleaccount
				+ ", facebookaccount=" + facebookaccount + ", instagramaccount=" + instagramaccount + ", onlyfriends="
				+ onlyfriends + ", getId()=" + getId() + ", getTwitteraccount()=" + getTwitteraccount()
				+ ", getGoogleaccount()=" + getGoogleaccount() + ", getFacebookaccount()=" + getFacebookaccount()
				+ ", getInstagramaccount()=" + getInstagramaccount() + ", getOnlyfriends()=" + getOnlyfriends()
				+ ", hashCode()=" + hashCode() + ", getCreatedBy()=" + getCreatedBy() + ", getUpdatedBy()="
				+ getUpdatedBy() + ", toString()=" + super.toString() + ", getCreatedAt()=" + getCreatedAt()
				+ ", getUpdatedAt()=" + getUpdatedAt() + ", getClass()=" + getClass() + "]";
	}

	public UserAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
}
