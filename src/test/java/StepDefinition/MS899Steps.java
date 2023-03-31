package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MS899Steps {

    WebDriver driver;

    @Given("The user logs into their account to the DemoWebshop")
    public void theUserLogsIntoTheirAccountToTheDemoWebshop() {
    } {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);

        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.get("https://demowebshop.tricentis.com/notebooks");
    }
    @When("the user selects the items they want to purchase")
    public void the_user_selects_the_items_they_want_to_purchase() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div/div/div[2]/div[3]/div[2]/input")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[2]/ul[1]/li[2]/a[1]")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/a[1]/img[1]")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[1]/div[1]/div[2]/div[3]/div[2]/input[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[4]/div[2]/div[2]/div[1]/form[1]/div[1]/div[1]/div[2]/div[8]/div[1]/input[2]")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[2]/ul[1]/li[7]/a[1]")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[3]/div[1]/div[2]/div[3]/div[2]/input[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[4]/div[2]/div[2]/div[1]/form[1]/div[1]/div[1]/div[2]/div[6]/div[1]/input[1]")).sendKeys("Leo");
        driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[4]/div[2]/div[2]/div[1]/form[1]/div[1]/div[1]/div[2]/div[6]/div[2]/input[1]")).sendKeys("Ahmed");
        driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[4]/div[2]/div[2]/div[1]/form[1]/div[1]/div[1]/div[2]/div[8]/div[1]/input[2]")).click(); // Gift Card
    }
    @And("click on Shopping Cart")
    public void click_on_shopping_cart() {
        driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[3]/a[1]/span[1]")).click();



    }
    @And("The website has correctly calculated the prices of each item and displayed them in the shopping cart.")
    public void the_website_has_correctly_calculated_the_prices_of_each_item_and_displayed_them_in_the_shopping_cart() {
        // Write code here that turns the phrase above into concrete actions


    }
    @Then("The website should display the total price of all the items in the shopping cart.")
    public void the_website_should_display_the_total_price_of_all_the_items_in_the_shopping_cart() {
        // Write code here that turns the phrase above into concrete actions
        WebElement preis1Element = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/table/tbody/tr[1]/td[6]/span[2]"));
        String preis1Text = preis1Element.getText().replaceAll("[^0-9]", ""); // Entfernen von Nicht-Ziffern
        double preis1Price = Double.parseDouble(preis1Text)/100.0;
        System.out.println("Einzelpreis Artikel 1: " + preis1Price);

        WebElement preis2Element = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/table/tbody/tr[2]/td[6]/span[2]"));
        String preis2Text = preis2Element.getText().replaceAll("[^0-9]", ""); // Entfernen von Nicht-Ziffern
        double preis2Price = Double.parseDouble(preis2Text)/100.0;
        System.out.println("Einzelpreis Artikel 2: " + preis2Price);

        WebElement preis3Element = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/table/tbody/tr[3]/td[6]/span[2]"));
        String preis3Text = preis3Element.getText().replaceAll("[^0-9]", ""); // Entfernen von Nicht-Ziffern
        double preis3Price = Double.parseDouble(preis3Text)/100.0;
        System.out.println("Einzelpreis Artikel 3: " + preis3Price);

        WebElement totalpreis = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/form/div[2]/div[2]/div[1]/table/tbody/tr[4]/td[2]/span/span/strong"));
        String totalpreistext = totalpreis.getText().replaceAll("[^0-9]", "");
        double totalpreispreis = Double.parseDouble(totalpreistext)/100.0;

        double gesamtpreis = (preis1Price + preis2Price + preis3Price); //alle artikel zusammengerechnet

        double differenz = (gesamtpreis - totalpreispreis);

        System.out.println("Total Preis: " + totalpreispreis +" Summe aller Artikel: "+gesamtpreis);

        if (differenz == 0) {
            System.out.println("Berechnung Richtig!");
        }
        else {
            System.out.println("Berechnung Falsch!");
        }
    }


}
