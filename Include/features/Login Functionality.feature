Feature: Login Functionality

  Scenario: Verify that the login functionality works correctly
    Given Open the application
    When Verify that the login page is displayed
    Then Enter valid login credentials
    And Click the 'Login' button
    Then Verify that the user is redirected to the manga search page
