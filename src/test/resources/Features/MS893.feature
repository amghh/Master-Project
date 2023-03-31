@UdemyStudenten
Feature: Login Funktionalität für Udemy Studenten
  Ein Udemy Student kann sich in das Testportal einloggen, wenn der Benutzername und das Passwort korrekt sind.
  Der Udemy Student soll benachrichtigt werden wenn der Benutzername und das Passwort nicht stimmen.
  Der Udemy Student soll auf die Homepage navigiert werden, wenn Benutzername und Passwort Korrekt sind.


  Scenario: Erfolgreicher Login in das Test-Portal
    Given Ich bin auf der Seite "https://seleniumkurs.codingsolo.de"
    When Ich gebe einen Benutzernamen ein "selenium102"
    And Ich gebe ein Passwort ein "codingsolo"
    And Ich klicke auf Anmelden
    Then Ich habe ich mich erfolgreich in "https://seleniumkurs.codingsolo.de/selenium-tests" eingeloggt


  Scenario: Fehlerhafter Login in das Test-Portal
    Given Ich bin auf der Seite "https://seleniumkurs.codingsolo.de"
    When Ich gebe einen Benutzernamen ein "selenium102"
    And Ich gebe ein Passwort ein "blabla"
    And Ich klicke auf Anmelden
    Then Ich bekomme eine Fehlermeldung angezeigt wenn ich "https://seleniumkurs.codingsolo.de/selenium-tests" aufrufe