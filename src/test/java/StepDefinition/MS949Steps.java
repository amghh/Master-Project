package StepDefinition;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.sql.Driver;
import java.time.Duration;

public class MS949Steps {

    WebDriver Driver;
    Faker faker=new Faker();
    
    @Given("user is on the website demoqa")
    public void user_is_on_the_website_demoqa_() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.setHeadless(true);


        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");
    }
    @When("user fills the form")
    public void user_fills_the_form() {
        Driver.findElement(By.xpath("//*[@id=\"firstName\"]")).sendKeys(faker.name().firstName());
        Driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(faker.name().lastName());
        Driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("test@web.de");
        ((JavascriptExecutor) Driver).executeScript("arguments[0].click();", Driver.findElement(By.xpath("//label[@for='gender-radio-1']")));
        Driver.findElement(By.xpath("//input[@id='dateOfBirthInput']")).sendKeys((CharSequence) faker.date().birthday());
        Driver.findElement(By.xpath("//div[@class='subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3']")).sendKeys((CharSequence) faker.random());
        ((JavascriptExecutor) Driver).executeScript("arguments[0].click();", Driver.findElement(By.xpath("//label[@for='hobbies-checkbox-1']")));
       // Object file_input = driver.find_element_by_id("uploadPicture");
        //file_input.send_keys("C:/Users/Username/example.txt");


    }
    @When("clicks on submit")
    public void clicks_on_submit() {
        Driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[1]/div[2]/input[1]")).click();
        WebDriver driver;
        WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(9));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[1]/div[2]/input[1]"))).sendKeys("Ahmed");
    }
    @Then("user gets a list of his submitted data")
    public void user_gets_a_list_of_his_submitted_data() {
        Driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[1]/div[2]/input[1]")).click();
        WebDriver driver;
        WebDriverWait wait = new WebDriverWait(Driver, Duration.ofSeconds(9));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[1]/div[2]/input[1]"))).sendKeys("Ahmed");

    }
}
