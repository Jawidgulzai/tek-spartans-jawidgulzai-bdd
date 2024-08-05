Feature: Security tests feature

  Scenario: Validate login with valid username and password
    When user click on sign in link
    Then validate user is in sign in page
    #When user enter username and password and click on login
    When user enter "jawid_g9@gmail.com" and "Jawid123$" and click on login
    Then user should be able to see account link