@checkoutWithoutLogin

Feature:  Checkout Process

  Scenario:  The late login after the check-out works as a user

    Given a user wants to add items to the shopping cart without logging in to their account
    When  the user visits the website and selects the items they want to purchase
    And   click on the checkout
    Then  they will be prompted to sign in to their account
    When  the user signs in with the Login Data
    Then  the user can complete the purchase

    Scenario: The late login after the check-out dont works as a user with wrong user data.

  Given a user wants to add items to the shopping cart without logging in to their account,
  When  the user visits the website and selects the items they want to purchase,
  And   click on the checkout,
  Then  they will be prompted to sign in to their account,
  When  the user signs in with wrong user Data,
  Then  they will not be able to continue shopping and proceed to checkout because wrong user data.