@hotel
Feature: User account edit

  @edit
  Scenario: User adds first address to the account
    Given I'm on the hotel authentication page
    When I login using "artur1685802028593@test.com" and "secretPass"
    And I go to my addresses page
    Then I can see there is no addresses
    When I add new address
    And I enter new address "Street", "62-300", "City", "123456789"
    Then I can see new address
#    wersja rozszerzona
#    And I verify created address "Street", "62-300", "City", "123456789"
#    And I remove the address
#    And I can see the address was removed
    And I close the browser