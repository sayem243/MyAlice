Feature: Manga Search and Display

  Background: Verify that the login functionality works correctly
    Given Open the application
    When Verify that the login page is displayed
    Then Enter valid login credentials
    And Click the 'Login' button

 
  
  Scenario: Verify that searching for manga returns the correct results.
    Given Ensure the user is on the manga search page
    And Enter the search term 'Naruto' into the search box
    When Click the 'Search' button
    Then Verify that manga cards with the name 'Naruto' are displayed
    And Enter the search term 'One Piece' into the search box
    When Click the 'Search' button
    And Verify that manga cards with the name 'One Piece' are displayed
   
   
   
    #And Enter the search term 'Seven Deadly Sins' into the search box
    #When Click the 'Search' button
    #Then Verify that manga cards with the name 'Seven Deadly Sins' are displayed
    And Enter a search term that returns no results  'No manga found'
    When Click the 'Search' button
    Then Verify that a 'No manga found' message is displayed
