Feature: User Login
  As a user
  I want to login to the application
  So that I can access my account

  Scenario: Successful Login
    Given I am on the login page
    When I enter username "akhila" and password "akhila"
    And I click on the login button
    Then I should be logged in successfully