package com._123digits.businesscard.ocr;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

/**
 * Extracts the name, phone number, and email address from a String.
 * 
 * @author 123digits
 *
 */
public class OCRBusinessCardParser implements BusinessCardParser {

	private static final Pattern PHONE_REGEX = Pattern.compile(
			"(t|tel|telephone|phone|cell|office|mobile|f|fax)?[ ]?[:|\\.]?[ ]?(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{4}",
			Pattern.CASE_INSENSITIVE);
	private static final Pattern EMAIL_REGEX = Pattern.compile(
			"(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])",
			Pattern.CASE_INSENSITIVE);

	public static void main(String[] args) {
		System.out.println(PHONE_REGEX.toString());
		System.out.println(PHONE_REGEX.pattern());
		System.out.println(EMAIL_REGEX.toString());
		System.out.println(EMAIL_REGEX.pattern());
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
		OCRContactInfo contactInfo = new OCRContactInfo();
		String match;
		// First scan for phone number and email address
		for (String line : document.split("\n")) {
			// Short-cut if the phone number has already been extracted or if the extracted
			// phone number is prefixed letter f/F for a fax number.
			if (StringUtils.EMPTY.equals(contactInfo.getPhoneNumber())
					&& Objects.nonNull(match = getMatch(line, PHONE_REGEX))
					&& !StringUtils.startsWithIgnoreCase(match, "f")) {
				// Remove non-digit characters and store the phone number
				contactInfo.setPhoneNumber(match.replaceAll("[^\\d]", ""));
			}
			// Short-cut if the email has already been extracted.
			if (StringUtils.EMPTY.equals(contactInfo.getEmailAddress())
					&& Objects.nonNull(match = getMatch(line, EMAIL_REGEX))) {
				// Store the email address
				contactInfo.setEmailAddress(match);
			}
		}
		// Second scan for full name leveraging the email address
		for (String line : document.split("\n")) {
			// work out name based on email
		}
		return contactInfo;
	}

	private static final String getMatch(String line, Pattern pattern) {
		Matcher matches = pattern.matcher(line);
		if (matches.find()) {
			return matches.group(0);
		}
		return null;
	}
}
