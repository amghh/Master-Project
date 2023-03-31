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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;

import static org.junit.Assert.assertTrue;

public class MS1007Steps {

   public static WebDriver driver;


    @Given("i am on the page seleniumkurs.codingsolo")
    public void i_am_on_the_page_seleniumkurs_codingsolo() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://seleniumkurs.codingsolo.de");

    }
    @When("i log in with the username selenium101 and the password codingsolo")
    public void i_log_in_with_the_username_selenium101_and_the_password_codingsolo() throws Exception {

        driver.findElement(By.cssSelector("#__ac_name")).sendKeys("selenium101");
        driver.findElement(By.cssSelector("#__ac_password")).sendKeys("codingsolo");
        driver.findElement(By.cssSelector("input[value='Anmelden']")).click();

    }
    @And("navigate to the selenium Testapplikationen")
    public void navigate_to_the_selenium_testapplikationen() throws InterruptedException {

        driver.findElement(By.xpath("//i[@id='portaltab-burger-menu']")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Selenium Testapplikationen")).click();


    }
    @And("i navigate to the page Drag and Drop Beispiel")
    public void i_navigate_to_the_page_drag_and_drop_beispiel() {

        driver.findElement(By.linkText("Drag and Drop Beispiel")).click();

    }
    @Then("I should be able to move the logos via drag and drop")
    public void i_should_be_able_to_move_the_logos_via_drag_and_drop() {

        WebElement drgLogoNormal = driver.findElement(By.id("white-logo"));
        WebElement drgLogoBlue = driver.findElement(By.id("blue-logo"));
        WebElement drgLogoRed = driver.findElement(By.id("red-logo"));
        WebElement drgLogoGreen = driver.findElement(By.id("green-logo"));


        WebElement drpBox = driver.findElement(By.id("droppable"));

        Actions action = new Actions(driver);

        action.dragAndDrop(drgLogoNormal, drpBox).build().perform();
        action.dragAndDrop(drgLogoBlue, drpBox).build().perform();

        action.dragAndDropBy(drgLogoRed, 250, 0).build().perform();

        action.clickAndHold(drgLogoGreen).perform();
        action.moveByOffset(250,0).perform();
        action.release(drgLogoGreen).perform();

        String erfolgsMeldung = driver.findElement(By.cssSelector("#droppable > p")).getText();
        assertTrue(erfolgsMeldung.contains("green-logo"));

    }
}
