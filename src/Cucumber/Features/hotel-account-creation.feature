@hotel
Feature: Hotel account creation

  @create
  Scenario: User can create an account
    Given I'm on hotel main page
    When I sign in
    And I enter email that is not already taken on the authentication page
    And I enter name John surname Doe and password passs
    Then I can see success message with text "Your account has been created."
    And I close hotel browser

  @create
  Scenario Outline: User can create an account
    Given I'm on hotel main page
    When I sign in
    And I enter email that is not already taken on the authentication page
    And I enter name <name> surname <surname> and password <passwd>
    Then I can see success message with text "Your account has been created."
    And I close hotel browser
    Examples:
      | name   | surname | passwd     |
      | Joanna | Doe     | superpass  |
      | Artur  | Kryszak | tajneHaslo |