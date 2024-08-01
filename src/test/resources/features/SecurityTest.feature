Feature: Security tests feature

  Scenario: Validate Login with valid username and password
    When user click on sign in link
    Then validate user is in sign in page
    When user enter username and password and click on login
    Then user should be able to see account link