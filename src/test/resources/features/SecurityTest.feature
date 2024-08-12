@Smoke @Regression @SecurityTest
Feature: Security tests scenarios

  Scenario: validate sign in functionality with valid credential
    When user click on sign in link
    Then validate user is in sign in page
    When user enter "jawid_g9@gmail.com" and "Jawid123$" and click on login
    Then user should be able to see account link

  Scenario Outline: Validate sign in with invalid credentials
    When user click on sign in link
    Then validate user is in sign in page
    When user enter "<username>" and "<password>" and click on login
    Then user should see error "wrong username or password"
    Examples:
      | username               | password      |
      | invalid@gmail.com      | Jawid123$  |
      | jawid_g9@gmail.com | WrongPassword |
      | invalid@gmail.com      | WrongPassword |