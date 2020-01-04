Feature: As a new user i want signing up on www.facebook.com

  Scenario: I would like to signup for facebook using input field
    Given I should be able t navigate to facebook
    Then I should be able to input First name into first name field
    Then I should be able to input last  name into last name field
    Then I should be able to input email address
    Then I should be able to input password

  Scenario: key in the date of birth
    
     And Enter the month
    Given Enter the day
    Given Enter the year

