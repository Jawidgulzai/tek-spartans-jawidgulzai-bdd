@Regression @SetupTest
Feature: This feature to setup framework

  @Smoke
  Scenario: Validate top left corner logo
    # Given Open browser and navigate to retail app
    Then validate top left corner is TEKSCHOOL
    # Then Close the browser
  @Smoke
  Scenario: Validate Logo and Sign in button
    Then validate top left corner is TEKSCHOOL
    Then validate Sign in button is Enabled