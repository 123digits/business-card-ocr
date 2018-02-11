package com._123digits.businesscard.ocr;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests the parsing of the contact information
 * 
 * @author 123digits
 *
 */
public class OCRContactInfoTest {
	private static final String TEST_VALUE = "testValue";

	@Test
	public void testGetName() {
		OCRContactInfo contactInfo = new OCRContactInfo();
		contactInfo.setName(TEST_VALUE);
		Assert.assertEquals(TEST_VALUE, contactInfo.getName());
	}

	@Test
	public void testPhoneNumber() {
		OCRContactInfo contactInfo = new OCRContactInfo();
		contactInfo.setPhoneNumber(TEST_VALUE);
		Assert.assertEquals(TEST_VALUE, contactInfo.getPhoneNumber());
	}

	@Test
	public void testGetEmailAddress() {
		OCRContactInfo contactInfo = new OCRContactInfo();
		contactInfo.setEmailAddress(TEST_VALUE);
		Assert.assertEquals(TEST_VALUE, contactInfo.getEmailAddress());
	}
}
