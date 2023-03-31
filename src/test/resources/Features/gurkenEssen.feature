Feature: Das ist eine Beispielfunktion
  Beschreibung wäre dann hier
@gurkenSubtrahieren
  Scenario Outline: Gurken subtrahieren
    Given Es gibt genau "<start>" Gurken
    When  Ich esse "<anzahl>" Gurken
    Then Ich sollte nun "<end>" Gurken haben

    Examples:
      |start|anzahl|end|
      |12  |5    |7  |
      |12  |2    |10 |
      |20  |5    |10 |
