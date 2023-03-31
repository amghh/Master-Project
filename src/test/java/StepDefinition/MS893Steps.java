package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
@RunWith(Cucumber.class)
public class MS893Steps {

    HttpURLConnection http;
    String benutzername;
    String passwort;


    @Given("^Ich bin auf der Seite \"([^\"]*)\"$")
    public void ich_bin_auf_der_seite_something(String webseite) throws Throwable {

        URL url = new URL(webseite);
        URLConnection con = url.openConnection();
        http = (HttpURLConnection) con;

        http.setRequestMethod("GET");
        http.setRequestProperty("Accept", "application/json; charset=UTF8");
        if (http.getResponseCode() == 200) {
            System.out.println("Ich navigiere zu " + webseite);
        }
    }

    @When("^Ich gebe einen Benutzernamen ein \"([^\"]*)\"$")
    public void ich_gebe_einen_benutzernamen_ein_something(String benutzername) throws Throwable {
        System.out.println("Ich gebe den Benutzernamen "+benutzername + " ein.");
        this.benutzername = benutzername;

    }

    //  @Then("^Ich habe mich erfolgreich in \"([^\"]*)\" eingeloggt$")
    //public void ich_habe_mich_erfolgreich_in_something_eingeloggt(String webseite) throws Throwable {

    @Then("Ich habe ich mich erfolgreich in {string} eingeloggt")
    public void ichHabeIchMichErfolgreichInEingeloggt(String webseite) throws Throwable{

        URL url = new URL(webseite);
        URLConnection con = url.openConnection();
        http = (HttpURLConnection) con;

        String encoded = Base64.getEncoder()
                .encodeToString((benutzername + ":" + passwort).getBytes(StandardCharsets.UTF_8));
        http.addRequestProperty("Authorization", "Basic + encoded");
        System.out.println("Ich bin auf der Homepage");

        http.setRequestMethod("GET");
        http.setRequestProperty("Accept", "application/json; charset=UTF8");
        if (http.getResponseCode() == 200) {
            System.out.println("Ich bin auf der Testseite");
        }
    }

    @Then("^Ich bekomme eine Fehlermeldung angezeigt wenn ich \"([^\"]*)\" aufrufe$")
    public void ich_bekomme_eine_fehlermeldung_angezeigt_wenn_ich_webseite_aufrufe(String webseite) throws Throwable {
        System.out.println("Fehler beim Login...");

        String encoded = Base64.getEncoder()
                .encodeToString((benutzername + ":" + passwort).getBytes(StandardCharsets.UTF_8));
        http.addRequestProperty("Authorization", "Basic + encoded");
        System.out.println("Ich bin auf der Homepage");

        http.setRequestMethod("GET");
        http.setRequestProperty("Accept", "application/json; charset=UTF8");
        if (http.getResponseCode() != 200) {
            System.out.println("Ich bekomme eine Fehlermeldung");
        }
    }

    @And("^Ich gebe ein Passwort ein \"([^\"]*)\"$")
    public void ich_gebe_ein_passwort_ein_something(String password) throws Throwable {
        System.out.println("Ich gebe das Passwort "+password+" ein" );

    }

    @And("^Ich klicke auf Anmelden$")
    public void ich_klicke_auf_anmelden() throws Throwable {
        System.out.println("Ich klicke auf Anmelden.");

    }
}
