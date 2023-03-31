package StepDefinition;

import io.cucumber.java.en.And;
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

import java.time.Duration;

public class MS832Steps {
    WebDriver driver;
    String Mail = "maxmusterman@email.com";
    String Password = "passwort";

    String wrongpassword = "blabla";
    @Given("a user wants to add items to the shopping cart without logging in to their account")
    public void a_user_wants_to_add_items_to_the_shopping_cart_without_logging_in_to_their_account() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);

        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.get("https://demowebshop.tricentis.com/notebooks");

    }
    @When("the user visits the website and selects the items they want to purchase")
    public void the_user_visits_the_website_and_selects_the_items_they_want_to_purchase() throws InterruptedException {
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
    @And("click on the checkout")
    public void click_on_the_checkout() {
        driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[3]/a[1]/span[1]")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/div[2]/div[3]/input[1]")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/div[2]/div[4]/button[1]")).click();
        System.out.println("The Articles now in the Shopping Card");



    }
    @Then("they will be prompted to sign in to their account")
    public void they_will_be_prompted_to_sign_in_to_their_account()  {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[4]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/p[1]")));



    }

    @When("the user signs in with the Login Data")
    public void theUserSignsInWithTheLoginData() throws InterruptedException {
        Thread.sleep(3000);
           driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys(Mail);
           driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys(Password);
           driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input")).click();
        System.out.println("The Welcome Page to Sign in is Available");

    }

    @Then("the user can complete the purchase")
    public void theUserCanCompleteThePurchase() throws InterruptedException {
        driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/div[2]/div[3]/input[1]")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/div[2]/div[4]/button[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"billing-buttons-container\"]/input")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"shipping-buttons-container\"]/input")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/input")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"payment-method-buttons-container\"]/input")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"payment-info-buttons-container\"]/input")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"confirm-order-buttons-container\"]/input")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/div[1]/strong")));
        System.out.println("Your Order has been successfully proceed!");
        Thread.sleep(3000);
        driver.quit();

    }

    @Given("a user wants to add items to the shopping cart without logging in to their account,")
    public void aUserWantsToAddItemsToTheShoppingCartWithoutLoggingInToTheirAccount() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.get("https://demowebshop.tricentis.com/notebooks");
    }

    @When("the user visits the website and selects the items they want to purchase,")
    public void theUserVisitsTheWebsiteAndSelectsTheItemsTheyWantToPurchase() throws InterruptedException {
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

    @And("click on the checkout,")
    public void clickOnTheCheckout() {
        driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[3]/a[1]/span[1]")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/div[2]/div[3]/input[1]")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/div[2]/div[4]/button[1]")).click();
        //System.out.println("The Articles now in the Shopping Card");
        
    }

    @Then("they will be prompted to sign in to their account,")
    public void theyWillBePromptedToSignInToTheirAccount() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[4]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/p[1]")));
        
    }

    @When("the user signs in with wrong user Data,")
    public void theUserSignsInWithWrongUserData() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"Email\"]")).sendKeys(Mail);
        driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys(wrongpassword);
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input")).click();

        
    }

    @Then("they will not be able to continue shopping and proceed to checkout because wrong user data.")
    public void theyWillNotBeAbleToContinueShoppingAndProceedToCheckoutBecauseWrongUserData() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[1]/div/span")));
        System.out.println("The Login with wrong userdata is not possible");
    }
}