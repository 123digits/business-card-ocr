package com._123digits.businesscard.ocr;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test that the ContactInfo object contains all of the extracted fields.
 * 
 * @author 123digits
 *
 */
public class OCRBusinessCardParserTest {

	@Test
	public void testGetContactInfo_Example1() {
		StringBuilder sb = new StringBuilder();
		sb.append("ASYMMETRIK LTD").append('\n');
		sb.append("Mike Smith").append('\n');
		sb.append("Senior Software Engineer").append('\n');
		sb.append("(410)555-1234").append('\n');
		sb.append("msmith@asymmetrik.com");

		OCRBusinessCardParser parser = new OCRBusinessCardParser();
		ContactInfo contactInfo = parser.getContactInfo(sb.toString());
		Assert.assertEquals("Mike Smith", contactInfo.getName());
		Assert.assertEquals("4105551234", contactInfo.getPhoneNumber());
		Assert.assertEquals("msmith@asymmetrik.com", contactInfo.getEmailAddress());
	}

	@Test
	public void testGetContactInfo_Example2() {
		StringBuilder sb = new StringBuilder();
		sb.append("Foobar Technologies").append('\n');
		sb.append("Analytic Developer").append('\n');
		sb.append("Lisa Haung").append('\n');
		sb.append("1234 Sentry Road").append('\n');
		sb.append("Columbia, MD 12345").append('\n');
		sb.append("Phone: 410-555-1234").append('\n');
		sb.append("Fax: 410-555-4321").append('\n');
		sb.append("lisa.haung@foobartech.com");

		OCRBusinessCardParser parser = new OCRBusinessCardParser();
		ContactInfo contactInfo = parser.getContactInfo(sb.toString());
		Assert.assertEquals("Lisa Haung", contactInfo.getName());
		Assert.assertEquals("4105551234", contactInfo.getPhoneNumber());
		Assert.assertEquals("lisa.haung@foobartech.com", contactInfo.getEmailAddress());
	}

	@Test
	public void testGetContactInfo_Example3() {
		StringBuilder sb = new StringBuilder();
		sb.append("Arthur Wilson").append('\n');
		sb.append("Software Engineer").append('\n');
		sb.append("Decision & Security Technologies").append('\n');
		sb.append("ABC Technologies").append('\n');
		sb.append("123 North 11th Street").append('\n');
		sb.append("Suite 229").append('\n');
		sb.append("Arlington, VA 22209").append('\n');
		sb.append("Tel: +1 (703) 555-1259").append('\n');
		sb.append("Fax: +1 (703) 555-1200").append('\n');
		sb.append("awilson@abctech.com");

		OCRBusinessCardParser parser = new OCRBusinessCardParser();
		ContactInfo contactInfo = parser.getContactInfo(sb.toString());
		Assert.assertEquals("Arthur Wilson", contactInfo.getName());
		Assert.assertEquals("17035551259", contactInfo.getPhoneNumber());
		Assert.assertEquals("awilson@abctech.com", contactInfo.getEmailAddress());
	}

	@Test
	public void testGetPhoneNumber_Scenarios() {
		OCRBusinessCardParser parser = new OCRBusinessCardParser();

		ContactInfo contactInfo = parser.getContactInfo("123-456-7890");
		Assert.assertEquals("1234567890", contactInfo.getPhoneNumber());

		contactInfo = parser.getContactInfo("123-456-7890");
		Assert.assertEquals("1234567890", contactInfo.getPhoneNumber());

		contactInfo = parser.getContactInfo("(123)456-7890");
		Assert.assertEquals("1234567890", contactInfo.getPhoneNumber());

		contactInfo = parser.getContactInfo("(123) 456-7890");
		Assert.assertEquals("1234567890", contactInfo.getPhoneNumber());

		contactInfo = parser.getContactInfo("123 456 7890");
		Assert.assertEquals("1234567890", contactInfo.getPhoneNumber());

		contactInfo = parser.getContactInfo("123.456.7890");
		Assert.assertEquals("1234567890", contactInfo.getPhoneNumber());

		contactInfo = parser.getContactInfo("+91 (123) 456-7890");
		Assert.assertEquals("911234567890", contactInfo.getPhoneNumber());

		contactInfo = parser.getContactInfo("Tel:+1 (123) 456-78909");
		Assert.assertEquals("11234567890", contactInfo.getPhoneNumber());

		contactInfo = parser.getContactInfo("Tel +1 (123) 456-7890");
		Assert.assertEquals("11234567890", contactInfo.getPhoneNumber());

		contactInfo = parser.getContactInfo("Tel: +1 (123) 456-7890");
		Assert.assertEquals("11234567890", contactInfo.getPhoneNumber());

		contactInfo = parser.getContactInfo("Tel| +1 (123) 456-7890");
		Assert.assertEquals("11234567890", contactInfo.getPhoneNumber());

		contactInfo = parser.getContactInfo("Tel | +1 (123) 456-7890");
		Assert.assertEquals("11234567890", contactInfo.getPhoneNumber());

		contactInfo = parser.getContactInfo("Phone:123-456-7890");
		Assert.assertEquals("1234567890", contactInfo.getPhoneNumber());

		contactInfo = parser.getContactInfo("Phone 123-456-7890");
		Assert.assertEquals("1234567890", contactInfo.getPhoneNumber());

		contactInfo = parser.getContactInfo("Phone: 123-456-7890");
		Assert.assertEquals("1234567890", contactInfo.getPhoneNumber());

		contactInfo = parser.getContactInfo("Phone| 123-456-7890");
		Assert.assertEquals("1234567890", contactInfo.getPhoneNumber());

		contactInfo = parser.getContactInfo("Phone | 123-456-7890");
		Assert.assertEquals("1234567890", contactInfo.getPhoneNumber());

		contactInfo = parser.getContactInfo("Mobile:123-456-7890");
		Assert.assertEquals("1234567890", contactInfo.getPhoneNumber());

		contactInfo = parser.getContactInfo("Mobile 123-456-7890");
		Assert.assertEquals("1234567890", contactInfo.getPhoneNumber());

		contactInfo = parser.getContactInfo("Mobile: 123-456-7890");
		Assert.assertEquals("1234567890", contactInfo.getPhoneNumber());

		contactInfo = parser.getContactInfo("Mobile| 123-456-7890");
		Assert.assertEquals("1234567890", contactInfo.getPhoneNumber());

		contactInfo = parser.getContactInfo("Mobile | 123-456-7890");
		Assert.assertEquals("1234567890", contactInfo.getPhoneNumber());

		contactInfo = parser.getContactInfo("Cell:123-456-7890");
		Assert.assertEquals("1234567890", contactInfo.getPhoneNumber());

		contactInfo = parser.getContactInfo("Cell 123-456-7890");
		Assert.assertEquals("1234567890", contactInfo.getPhoneNumber());

		contactInfo = parser.getContactInfo("Cell: 123-456-7890");
		Assert.assertEquals("1234567890", contactInfo.getPhoneNumber());

		contactInfo = parser.getContactInfo("Cell| 123-456-7890");
		Assert.assertEquals("1234567890", contactInfo.getPhoneNumber());

		contactInfo = parser.getContactInfo("Cell | 123-456-7890");
		Assert.assertEquals("1234567890", contactInfo.getPhoneNumber());

		contactInfo = parser.getContactInfo("Office:123-456-7890");
		Assert.assertEquals("1234567890", contactInfo.getPhoneNumber());

		contactInfo = parser.getContactInfo("Office 123-456-7890");
		Assert.assertEquals("1234567890", contactInfo.getPhoneNumber());

		contactInfo = parser.getContactInfo("Office: 123-456-7890");
		Assert.assertEquals("1234567890", contactInfo.getPhoneNumber());

		contactInfo = parser.getContactInfo("Office| 123-456-7890");
		Assert.assertEquals("1234567890", contactInfo.getPhoneNumber());

		contactInfo = parser.getContactInfo("Office | 123-456-7890");
		Assert.assertEquals("1234567890", contactInfo.getPhoneNumber());

		contactInfo = parser.getContactInfo("T:123-456-7890");
		Assert.assertEquals("1234567890", contactInfo.getPhoneNumber());

		contactInfo = parser.getContactInfo("T 123-456-7890");
		Assert.assertEquals("1234567890", contactInfo.getPhoneNumber());

		contactInfo = parser.getContactInfo("T: 123-456-7890");
		Assert.assertEquals("1234567890", contactInfo.getPhoneNumber());

		contactInfo = parser.getContactInfo("T| 123-456-7890");
		Assert.assertEquals("1234567890", contactInfo.getPhoneNumber());

		contactInfo = parser.getContactInfo("T | 123-456-7890");
		Assert.assertEquals("1234567890", contactInfo.getPhoneNumber());

		contactInfo = parser.getContactInfo("T. 123-456-7890");
		Assert.assertEquals("1234567890", contactInfo.getPhoneNumber());

		contactInfo = parser.getContactInfo("Fax: 123-456-7890");
		Assert.assertEquals(StringUtils.EMPTY, contactInfo.getPhoneNumber());
	}

	@Test
	public void testGetName_Scenarios() {
		OCRBusinessCardParser parser = new OCRBusinessCardParser();

		ContactInfo contactInfo = parser.getContactInfo("Mike Smith\nmsmith@asymmetrik.com");
		Assert.assertEquals("Mike Smith", contactInfo.getName());

		contactInfo = parser.getContactInfo("Lisa Haung\nlisa.haung@foobartech.com");
		Assert.assertEquals("Lisa Haung", contactInfo.getName());

		contactInfo = parser.getContactInfo("Arthur Wilson\nawilson@abctech.com");
		Assert.assertEquals("Arthur Wilson", contactInfo.getName());

		contactInfo = parser.getContactInfo("First Last\nflast@name.com");
		Assert.assertEquals("First Last", contactInfo.getName());
	}

	@Test
	public void testGetEmail_Scenarios() {
		OCRBusinessCardParser parser = new OCRBusinessCardParser();

		ContactInfo contactInfo = parser.getContactInfo("a@b.c");
		Assert.assertEquals("a@b.c", contactInfo.getEmailAddress());

		contactInfo = parser.getContactInfo(" a@b.c ");
		Assert.assertEquals("a@b.c", contactInfo.getEmailAddress());

		contactInfo = parser.getContactInfo("Email a@b.c ");
		Assert.assertEquals("a@b.c", contactInfo.getEmailAddress());

		contactInfo = parser.getContactInfo("Email: a@b.c ");
		Assert.assertEquals("a@b.c", contactInfo.getEmailAddress());

		contactInfo = parser.getContactInfo("Email : a@b.c ");
		Assert.assertEquals("a@b.c", contactInfo.getEmailAddress());

		contactInfo = parser.getContactInfo("Email| a@b.c ");
		Assert.assertEquals("a@b.c", contactInfo.getEmailAddress());

		contactInfo = parser.getContactInfo("Email | a@b.c ");
		Assert.assertEquals("a@b.c", contactInfo.getEmailAddress());

		contactInfo = parser.getContactInfo("E-Mail a@b.c ");
		Assert.assertEquals("a@b.c", contactInfo.getEmailAddress());

		contactInfo = parser.getContactInfo("E-Mail: a@b.c ");
		Assert.assertEquals("a@b.c", contactInfo.getEmailAddress());

		contactInfo = parser.getContactInfo("E-Mail : a@b.c ");
		Assert.assertEquals("a@b.c", contactInfo.getEmailAddress());

		contactInfo = parser.getContactInfo("E-Mail| a@b.c ");
		Assert.assertEquals("a@b.c", contactInfo.getEmailAddress());

		contactInfo = parser.getContactInfo("E-Mail | a@b.c ");
		Assert.assertEquals("a@b.c", contactInfo.getEmailAddress());
	}
}
