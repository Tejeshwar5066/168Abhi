package com.cdac.training.pms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long stId;
	private String name;
	private String email;
	private String phoneNo;
	
	public Student() {
		super();
	}

	public Student(long stId, String name, String email, String phoneNo) {
		super();
		this.stId = stId;
		this.name = name;
		this.email = email;
		this.phoneNo = phoneNo;
	}

	public long getStId() {
		return stId;
	}

	public void setStId(long stId) {
		this.stId = stId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Override
	public String toString() {
		return "Student [stId=" + stId + ", name=" + name + ", email=" + email + ", phoneNo=" + phoneNo + "]";
	}
	
	
	
	
	
	

}
