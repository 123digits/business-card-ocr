package com._123digits.businesscard.ocr;

/**
 * Stores the extracted name, phone number, and email address.
 * 
 * @author 123digits
 *
 */
public class OCRContactInfo implements ContactInfo {
	private final String name;
	private final String phoneNumber;
	private final String emailAddress;

	/**
	 * Stores the extracted contact information
	 * 
	 * @param name
	 *            extracted full name
	 * @param phoneNumber
	 *            extracted phone number
	 * @param emailAddress
	 *            extracted email address
	 */
	public OCRContactInfo(String name, String phoneNumber, String emailAddress) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getPhoneNumber() {
		return phoneNumber;
	}

	@Override
	public String getEmailAddress() {
		return emailAddress;
	}
}
