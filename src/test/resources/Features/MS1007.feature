@DragDrop
Feature: Drag and Drop Example

  Scenario: Drag and Drop of Logos

  Given i am on the page seleniumkurs.codingsolo
  When  i log in with the username selenium101 and the password codingsolo
  And   navigate to the selenium Testapplikationen
  And   i navigate to the page Drag and Drop Beispiel
  Then  I should be able to move the logos via drag and drop