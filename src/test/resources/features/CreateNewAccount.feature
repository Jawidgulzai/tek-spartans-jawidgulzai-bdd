@Regression
Feature: Create new account functionality

  Background: Setup create account scenario
    Given user click on "Sign in" link
    Then validate user is in sign in page
    Given user click on "Create New Account" link

  Scenario: create valid account with random email
    When user enter "Jawid" and "random" and "Jawid123$"
    When user click on "Sign Up" button
    Then validate user is in account page
    Then validate email address in account page match

  @UserStory1
  Scenario: Create account with existing email
    When user enter "Jawid" and "jawid_g9@gmail.com" and "Jawid123$"
    When user click on "Sign Up" button
    Then user should see error "this email is already exist, please use another email address"

  @UserStory2
  Scenario: Navigate to create new account page and click on sign up button and validate all errors in fields
    When user click on "Sign Up" button
    Then user should see error under each field
      | nameError            | Name is a required field             |
      | emailError           | Email is a required field            |
      | passwordError        | Password is a required field         |
      | confirmPasswordError | Confirm Password is a required field |