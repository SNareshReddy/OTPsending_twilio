package com.naresh.example.springbootrestapiandroid.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "OTPSystem")
public class OTPSystem {
	private long id;
	private String mobilenumber;
	private String otp;
	private long expirytime;
	   @Id
	   @GeneratedValue(strategy = GenerationType.AUTO)
	       public long getId() {
	       return id;
	   }
	   
	public void setId(long id) {
		this.id = id;
	}

	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public long getExpirytime() {
		return expirytime;
	}

	public void setExpirytime(long expirytime) {
		this.expirytime = expirytime;
	}

}
