@FeatureCompare
Feature: Feature compare function

  Scenario: the compare list works as a user


  Given the user logs on the Webshop
  When  the user chooses 3 articles from the same group
  And   the user clicks on the compare button for each item.
  Then  all articles are displayed in the compare list correctly