package com.pm.domain;

import java.util.Date;

import org.springframework.data.mongodb.core.index.Indexed;

public class UserBasicInfo {

	private Name name;
	private Gender gender;
	@Indexed(unique=true)
	private MobileNumber mobileNumber;
	
	@Indexed(unique=true)
	private Email emailId;
	private Date dateOfBirth;
	private MaritalStatus maritalStatus;
	private Address homeAddress;
	private Address officeAddress; 
	
	private enum MaritalStatus {
		UNMARRIED, MARRIED
	}
	
	private enum Gender {
		MALE, FEMALE
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public MobileNumber getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(MobileNumber mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Email getEmailId() {
		return emailId;
	}

	public void setEmailId(Email emailId) {
		this.emailId = emailId;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public Address getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
	
}
