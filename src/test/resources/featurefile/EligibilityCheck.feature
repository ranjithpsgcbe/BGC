
Feature: GDS-ACE Quality Engineer Technical Challenge

  @Test1
  Scenario Outline: As an Applicant, I should be able to answer a set of Yes/No Eligibility questions in the Eligibility page.
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
  And As a user click on the warning Message
  And As a user click on the Save Button
  Then Verify the InputValue "<value1>" and "<value2>" and "<value3>" and "<value4>" and "<value5>"

  Examples:
    | value1 | value2 | value3 | value4 | value5 |
    |   Yes  |   Yes  |   Yes  |   No   |   No  |

