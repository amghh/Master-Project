@buffer
Feature: Total Price functionality

  Scenario: Check the Total Price with the Articles in the Shopping Cart


    Given The user logs into their account to the DemoWebshop
    When  the user selects the items they want to purchase
    And   click on Shopping Cart
    And   The website has correctly calculated the prices of each item and displayed them in the shopping cart.
    Then  The website should display the total price of all the items in the shopping cart.
