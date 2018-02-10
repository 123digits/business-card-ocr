package com._123digits.businesscard.ocr;

/**
 * Extracts the name, phone number, and email address from a String.
 * 
 * @author 123digits
 *
 */
public class OCRBusinessCardParser implements BusinessCardParser {

	public static void main(String[] args) {
		OCRBusinessCardParser parser = new OCRBusinessCardParser();
		for (String arg : args) {
			System.out.println();
			System.out.println(arg);
			System.out.println();
			System.out.println("==>");
			System.out.println();
			ContactInfo contactInfo = parser.getContactInfo(arg);
			System.out.println("Name: " + contactInfo.getName());
			System.out.println("Phone: " + contactInfo.getPhoneNumber());
			System.out.println("Email: " + contactInfo.getEmailAddress());
			System.out.println();
		}
	}

	@Override
	public ContactInfo getContactInfo(String document) {
		// parse into OCRContactInfo object
		return null;
	}
}
