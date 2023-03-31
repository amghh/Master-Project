package cdingsolo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.assertTrue;

public class TestNavigationSeleniumKursChrome {

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        System.out.println("Initialisiere Webdriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://seleniumkurs.codingsolo.de");

    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Test abgeschlossen- ich räume");
       // driver.close();
    }

    @Test
    public void test() throws InterruptedException {
        System.out.println("Starte Test Login mit Fehlschlag");

        //Arrange

        WebElement inputUsername = driver .findElement(By.cssSelector("#__ac_name"));
        inputUsername.sendKeys("selenium101");
        WebElement inputPassword = driver.findElement(By.cssSelector("#__ac_password"));
        inputPassword.sendKeys("codingsolo");
        WebElement btnLogin = driver.findElement(By.cssSelector("input[value='Anmelden']"));
        btnLogin.click();

        //Act

       WebElement btnMenu = driver.findElement(By.xpath("//i[@id='portaltab-burger-menu']"));
       btnMenu.click();

        Thread.sleep(2000);
        WebElement linkSideMenuSelenium = driver.findElement(By.linkText("Selenium Testapplikationen"));
        linkSideMenuSelenium.click();

        WebElement linkSeleniumTestApp =driver.findElement(By.linkText("Selenium Test Form1"));
        linkSeleniumTestApp.click();

        //Assert

        String erfolgsMeldung = driver.findElement(By.tagName("h1")).getText();
        assertTrue(erfolgsMeldung.contains("Selenium Test Form1"));


    }
}
