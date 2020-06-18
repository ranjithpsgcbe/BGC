
Feature: GDS-ACE Quality Engineer Technical Challenge

  Background:  User login
  Given I am on the homepage
  When As a user enter "S1234567A" and "Tan Ah Kow" and "BGPQEDEMO"
  And As a user Select the Role and click on the login button
  And As a user click on New Grand Button
  And As a user select Sector and Development and Function area
  And As a user click on the proceed button


  @tag1
  Scenario Outline: As an Applicant, I should be able to answer a set of Yes/No Eligibility questions in the Eligibility page.
    And As a user select the applicant is registered in singapore "<value1>"
    And As a user select the applicant group sales turnover less than or equal to SG100m "<value2>"
    And As a user select the applicant have at lest 30 percentage local equity "<value3>"
    And As a user select the target market that applying for a new market "<value4>"
    And As a user select the applicant has not started work and payment and agreement "<value5>"
    And As a user click on the Save Button
    And As a user click on the warning Message

    Examples:
      | value1 | value2 | value3 | value4 | value5 |
      |   Yes  |   Yes  |   Yes  |   Yes   |   No  |

  @tag2
  Scenario Outline: As an Applicant, I should be able to input values for the Main Contact Person and Letter of Offeree in the Contact Details page.
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
    And As a user click on the Next Button

    Examples:
      | name     | jobtitle | number   |      email     | value1 | value2 | value3 | value4 | value5 |
      | Ranjith  | Manager | 12345678  | qwer@gmail.com |  Yes  |   Yes  |   Yes  |   Yes   |   Yes  |


  @tag3
  Scenario Outline: As an Applicant, I should be able to input values for the Business Impact Page.

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
    And As a user click on the Next Button

    When As a user enter Project Title
    And As a user enter Start Date
    And As a user enter End Date
    And As a user enter Project Description
    And As a user select Activity from dropdownbox
    And As a user check the Target Market checkBox
    And As a user click on the target market outside Singapore
    And As a user click on the Next Button

    When As a user enter FY End Date
    And As a user enter Overseas sale for Next three years
    And As a user enter Overseas Investment for Next three years
    And As a user enter Rational for project
    And As a user enter Non tangile Benifits
    And As a user click on the Next Button

    When As a user click on the office rental button
    And As a user click on the Add new Item Button
    And As a user enter the Description
    And As a user enter the rental duration
    And As a user enter the Estimate cost in billing currency
    And As a user click on the Next Button

    When As a user select the Declare and acknowledge
    And As a user check the acknowledge checkBox
    And As a user click on the Review button
    And As a user check the Final acknowledge checkBox
    And As a user should click on the submit Button
    And As a user Click on the MyGrand menu
    And As a user click on the processing Tab
    Then verify the RefID

    Examples:
      | name     | jobtitle | number   |      email     | value1 | value2 | value3 | value4 | value5 |
      | Ranjith  | Manager | 12345678  | qwer@gmail.com |  Yes  |   Yes  |   Yes  |   Yes   |   Yes  |


  @tag4
  Scenario Outline: As an Applicant, I should be able to validate input values.
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
    And As a user click on the Next Button


    When As a user enter Project Title
    And As a user enter Start Date
    And As a user enter End Date
    And As a user enter Project Description
    And As a user select Activity from dropdownbox
    And As a user check the Target Market checkBox
    And As a user click on the target market outside Singapore
    And As a user click on the Next Button

    When As a user enter FY End Date
    And As a user enter Overseas sale for Next three years
    And As a user enter Overseas Investment for Next three years
    And As a user enter Rational for project
    And As a user enter Non tangile Benifits
    And As a user click on the Next Button

    When As a user click on the office rental button
    And As a user click on the Add new Item Button
    And As a user enter the Description
    And As a user enter the rental duration
    And As a user enter the Estimate cost in billing currency
    And As a user click on the Next Button

    When As a user select the Declare and acknowledge
    And As a user check the acknowledge checkBox
    And As a user click on the Review button
    And Verify the mandatory input missing and number of error

    Examples:
      | name     | jobtitle | number   |   email   | value1 | value2 | value3 | value4 | value5 |
      | Ranjith  | Manager  | 12345678  | qwerwefwe |  Yes  |   Yes  |   Yes  |   Yes   |   Yes  |