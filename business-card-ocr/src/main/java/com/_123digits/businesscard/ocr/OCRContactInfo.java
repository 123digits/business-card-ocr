package com._123digits.businesscard.ocr;

import org.apache.commons.lang3.StringUtils;

/**
 * Stores the extracted name, phone number, and email address.
 * 
 * @author 123digits
 *
 */
public class OCRContactInfo implements ContactInfo {
	private String name = StringUtils.EMPTY;
	private String phoneNumber = StringUtils.EMPTY;
	private String emailAddress = StringUtils.EMPTY;

	public OCRContactInfo() {
		// implicit public constructor
	}

	/**
	 * Stores the extracted full name
	 * 
	 * @param name
	 *            extracted full name
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}

	/**
	 * Stores the extracted phone number
	 * 
	 * @param phoneNumber
	 *            extracted phone number
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Stores the extracted email address
	 * 
	 * @param emailAddress
	 *            extracted email address
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Override
	public String getEmailAddress() {
		return emailAddress;
	}
}
