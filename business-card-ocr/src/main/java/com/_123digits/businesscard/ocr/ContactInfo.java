package com._123digits.businesscard.ocr;

/**
 * Provides basic methods for extracted contact information
 * 
 * @author 123digits
 *
 */
public interface ContactInfo {
	/**
	 * Returns the full name of the individual (eg. John Smith, Susan Malick).
	 * 
	 * @return full name
	 */
	public String getName();

	/**
	 * Returns the phone number formatted as a sequence of digits
	 * 
	 * @return phone number
	 */
	public String getPhoneNumber();

	/**
	 * Return the email address
	 * 
	 * @return email address
	 */
	public String getEmailAddress();
}
