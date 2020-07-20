
Feature: GDS-ACE Quality Engineer Technical Challenge


  @Test2
  Scenario Outline: As an Applicant, I should be able to input values for the Main Contact Person and Letter of Offeree in the Contact Details page.
  Given I am on the homepage
  When As a user enter "S1234567A" and "Tan Ah Kow" and "BGPQEDEMO"
  And As a user Select the Role and click on the login button
  And As a user click on New Grand Button
  And As a user select Sector and Development and Function area
  And As a user click on the proceed button

  And As a user select the applicant is registered in singapore "<value1>"
  And As a user select the applicant group sales turnover less than or equal to SG100m "<value2>"
  And As a user select the applicant have at lest 30 percentage local equity "<value3>"
  And As a user select the target market that applying for a new market "<value4>"
  And As a user select the applicant has not started work and payment and agreement "<value5>"
  And As a user click on the Next Button

  When As a user enter name "<name>"
  And As a user enter jobtitle "<jobtitle>"
  And As a user enter number "<number>"
  And As a user enter email "<email>"
  And As a user check the Mailing address checkBox
  And As a user check the same as contact person checkBox
  Then Verify the main contact details are prepopulated in Letter offer addressee "<name>" and "<jobtitle>" and "<email>"
  And As a user click on the Save Button
  And As a user click on the Next Button

  Examples:
    | name     | jobtitle | number   |      email     | value1 | value2 | value3 | value4 | value5 |
    | Ranjith  | Manager | 12345678  | qwer@gmail.com |  Yes  |   Yes  |   Yes  |   Yes   |   Yes  |

