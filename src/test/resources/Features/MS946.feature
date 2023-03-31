@flightcheck

Feature: check the search function

  Scenario: The Tickets Search function works

    Given I go to the page flight idealo
    When  I choose Round Trip
    And   I type Hamburg on the departure and choose Barcelona on arrival
    And   I type the Date
    And   I choose the number of Persons on 2
    And   I click on Search
    Then  will be displayed the list of available flights