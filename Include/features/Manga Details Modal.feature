Feature: Manga Details Modal

  Background: 
    Given Open the application
    When Verify that the login page is displayed
    Then Enter valid login credentials
    And Click the 'Login' button

  Scenario: Verify that the modal displays the correct manga details
    Given Ensure the user is on the manga search page
    When Click the 'Details' link on a manga card
    And Verify that the modal appears and displays the correct manga information
    And Click the 'Close' button on the modal
    Then Verify that the modal is closed and no longer visible
