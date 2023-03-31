package StepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MS853Steps {
    WebDriver driver;
    String Mail = "maxmusterman@email.com";
    String Password = "passwort";
    @Given("the user logs on the Webshop")
    public void the_user_logs_on_the_webshop() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://demowebshop.tricentis.com/login");
        driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys(Mail);
        driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys(Password);
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input")).click();


    }
    @When("the user chooses {int} articles from the same group")
    public void the_user_chooses_articles_from_the_same_group(Integer int1) {
        System.out.println("The following article were chosen: 14.1-inch Laptop, Build your own cheap computer, Elite Desktop PC");

    }
    @And("the user clicks on the compare button for each item.")
    public void the_user_clicks_on_the_compare_button_for_each_item() {
        driver.get("https://demowebshop.tricentis.com/141-inch-laptop");
        driver.findElement(By.xpath("//*[@id=\"product-details-form\"]/div/div[1]/div[2]/div[8]/input")).click();
        driver.get("https://demowebshop.tricentis.com/build-your-cheap-own-computer");
        driver.findElement(By.xpath("//*[@id=\"product-details-form\"]/div/div[1]/div[2]/div[10]/input")).click();
        driver.get("https://demowebshop.tricentis.com/desktop-pc");
        driver.findElement(By.xpath("//*[@id=\"product-details-form\"]/div/div[1]/div[2]/div[8]/input")).click();

        
    }
    @Then("all articles are displayed in the compare list correctly")
    public void all_articles_are_displayed_in_the_compare_list_correctly() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/table/tbody/tr[2]/td[2]/a")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/table/tbody/tr[2]/td[3]/a")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/table/tbody/tr[2]/td[4]/a")));
        System.out.println("The Compare list shows all article that were added to it");

    }
}
