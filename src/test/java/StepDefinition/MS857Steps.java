package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class MS857Steps {
    WebDriver driver;
    String Mail = "maxmusterman@email.com";
    String Password = "passwort";
    @Given("The user has made past purchases on the website and has an account with the website.")
    public void the_user_has_made_past_purchases_on_the_website_and_has_an_account_with_the_website() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
    }
    @When("The user logs into their account {string}")
    public void the_user_logs_into_their_account(String string) {
        driver.get("https://demowebshop.tricentis.com/login");
        driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys(Mail);
        driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys(Password);
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input")).click();

    }
    @When("navigates to orders")
    public void navigates_to_orders() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[1]/div[1]/div[1]/a/img")));
        driver.get("https://demowebshop.tricentis.com/customer/orders");

    }
    @When("The user click on the Details so that he comes to the overview")
    public void the_user_click_on_the_details_so_that_he_comes_to_the_overview() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div/div[1]/div[2]/input")));
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div/div[1]/div[2]/input")).click();

    }
    @When("when the PDF Invoice Button is available")
    public void when_the_pdf_invoice_button_is_available() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[1]/a[2]")));
        System.out.println("The PDF Button is available");

    }
    @When("the user click und the Button")
    public void the_user_click_und_the_button() {
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[1]/a[2]")).click();
        System.out.println("PDF being downloaded");

    }
    @Then("The PDF file should download successfully and display correctly on the user's device.")
    public void the_pdf_file_should_download_successfully_and_display_correctly_on_the_user_s_device() {
        File dir = new File("C:/Users/Ahmed Ghars/Downloads/");
        File[] files = dir.listFiles((dir1, name) -> name.matches(".*order.*\\.pdf"));
        Assert.assertTrue(files.length > 0);
        System.out.println("The PDF file was found in the Downloads folder. Test Successful");
    }
}
