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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MS946Steps {

    WebDriver driver;


    @Given("I go to the page flight idealo")
    public void i_go_to_the_page_flight_idealo() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://flug.idealo.de/");
        WebElement framecookies = driver.findElement(By.id("sp_message_iframe_708310"));
        driver.switchTo().frame(framecookies);
        driver.findElement(By.cssSelector("button[title='Alle akzeptieren']")).click();




      //  sp_message_iframe_708310
    }
    @When("I choose Round Trip")
    public void i_choose_round_trip() {
        driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div[2]/form/div[1]/div[1]/div/div/button[2]")).click();


    }
    @And("I type Hamburg on the departure and choose Barcelona on arrival")
    public void i_type_Hamburg_on_the_departure_and_choose_Barcelona_on_arrival() {
        driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div[2]/form/div[2]/div[1]/div/div[1]/div/div/div[1]/input")).click();
        driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div[2]/form/div[2]/div[1]/div/div[1]/div/div/div[3]/div/ul/li[4]/span")).click();

driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div[2]/form/div[2]/div[1]/div/div[2]/div/div[1]/input")).click();
driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div[2]/form/div[2]/div[1]/div/div[2]/div/div[3]/div/ul/li[3]/span")).click();

    }
    @When("I type the Date")
    public void i_type_the_date() {
        driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[2]/div[2]/form[1]/div[2]/div[2]/div[1]/div[1]/input[1]")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[2]/div[2]/form[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[5]/td[5]/span[1]")).click();
    }
    @When("I choose the number of Persons on 2")
    public void i_choose_the_number_of_persons_on_2() {
        driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[2]/div[2]/form[1]/div[2]/div[3]/div[1]/div[1]/input[1]")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[2]/div[2]/form[1]/div[2]/div[3]/div[1]/div[3]/div[1]/div[2]/button[2]/*[name()='svg'][1]")).click();



    }
    @When("I click on Search")
    public void i_click_on_Search() {
        driver.findElement(By.cssSelector(".MuiButton-root")).click();


    }
    @Then("will be displayed the list of available flights")
    public void will_be_displayed_the_list_of_available_flights() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"uId137_filter_payment\"]/div/h4/span")));
        System.out.println("Die Anzeige wird in unter 15 sekunden richtig dargestellt.");

    }


}
