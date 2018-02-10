package com._123digits.businesscard.ocr;

/**
 * Provides method for extracting contact information
 * 
 * @author 123digits
 *
 */
public interface BusinessCardParser {
	/**
	 * Parses the String text of a business card and returns back the extracted
	 * contact information.
	 * 
	 * @param document
	 *            document to be parsed
	 * @return extracted contact information
	 */
	public ContactInfo getContactInfo(String document);
}
