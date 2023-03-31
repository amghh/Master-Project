package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GurkenEssenStepDefinitions {
    int start;
    int anzahl;
    int end;

    @Given("Es gibt genau {string} Gurken")
    public void esGibtGenauGurken(String anzahlGurkenStr) {
        this.start = Integer.parseInt(anzahlGurkenStr);
    }

    @When("Ich esse {string} Gurken")
    public void ichEsseGurken(String anzahlStr) {
        this.anzahl = Integer.parseInt(anzahlStr);
        this.end = this.start - this.anzahl;
    }

    @Then("Ich sollte nun {string} Gurken haben")
    public void ichSollteNunGurkenHaben(String endStr) {
        int expectedEnd = Integer.parseInt(endStr);
        assertEquals(expectedEnd, this.end);
    }
}