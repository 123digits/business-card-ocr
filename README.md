# business-card-ocr

We have created a new smartphone app that enables users to snap a photo of a business card and have the information from the card automatically extracted and added to their contact list. We need you to write the component that parses the results of the optical character recognition (OCR) component in order to extract the name, phone number, and email address from the processed business card image. We have provided you with a basic specification [1] and a series of example inputs [2] and would like you to provide the implementation.

[1] Interface Specification

ContactInfo<br>
    String getName() : returns the full name of the individual (eg. John Smith, Susan Malick)<br>
    String getPhoneNumber() : returns the phone number formatted as a sequence of digits<br>
    String getEmailAddress() : returns the email address<br>

BusinessCardParser<br>
    ContactInfo getContactInfo(String document)<br>

[2] Example input documents and their expected results

Example 1:

ASYMMETRIK LTD<br>
Mike Smith<br>
Senior Software Engineer<br>
(410)555-1234<br>
msmith@asymmetrik.com<br>

==>

Name: Mike Smith<br>
Phone: 4105551234<br>
Email: msmith@asymmetrik.com<br>

Example 2:

Foobar Technologies<br>
Analytic Developer<br>
Lisa Haung<br>
1234 Sentry Road<br>
Columbia, MD 12345<br>
Phone: 410-555-1234<br>
Fax: 410-555-4321<br>
lisa.haung@foobartech.com<br>

==>

Name: Lisa Haung<br>
Phone: 4105551234<br>
Email: lisa.haung@foobartech.com<br>

Example 3:

Arthur Wilson<br>
Software Engineer<br>
Decision & Security Technologies<br>
ABC Technologies<br>
123 North 11th Street<br>
Suite 229<br>
Arlington, VA 22209<br>
Tel: +1 (703) 555-1259<br>
Fax: +1 (703) 555-1200<br>
awilson@abctech.com<br>

==>

Name: Arthur Wilson<br>
Phone: 17035551259<br>
Email: awilson@abctech.com<br>

--------------------------------------------------------------

This Maven/Java project can be built via running 'mvn install' or alternatively 'mvn clean install'.

This Maven/Java project can be tested via running the JUnit tests.

This Maven/Java project can be run via using an IDE and run OCTBusinessCardParser with a series of String arguments to be parsed and output on the command line. As one example, running the String arguments would parse out both and print them out separately like the output above: 

"Mark Test|(123)-456-7890|mtest@test.com" "First Last|(123)456-7890|first.last@test.com"

Additionally, when running 'mvn install' or 'mvn clean install', the program can be executed on the command line via the JAR file that is created in the target directory. As an example:

java -cp business-card-ocr-0.0.1-SNAPSHOT.jar com._123digits.businesscard.ocr.OCRBusinessCardParser "Mark Test|(123)456-7890|mtest@test.com" "First Last|(123)456-7890|first.last@test.com"

NOTE: The pipeline character is converted to newline characters before running them as a result of the in-ability to pass newline characters within String arguments to the main method in the jar file.