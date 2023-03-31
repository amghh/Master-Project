package cdingsolo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestDragDropSeleniumKursChrome {

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
        // Login
        driver.findElement(By.cssSelector("#__ac_name")).sendKeys("selenium101");
        driver.findElement(By.cssSelector("#__ac_password")).sendKeys("codingsolo");
        driver.findElement(By.cssSelector("input[value='Anmelden']")).click();

        //Navigation zum Formular
        driver.findElement(By.xpath("//i[@id='portaltab-burger-menu']")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Selenium Testapplikationen")).click();
        driver.findElement(By.linkText("Drag and Drop Beispiel")).click();

        //Start Drag and Drop

        WebElement drgLogoNormal = driver.findElement(By.id("white-logo"));
        WebElement drgLogoBlue = driver.findElement(By.id("blue-logo"));
        WebElement drgLogoRed = driver.findElement(By.id("red-logo"));
        WebElement drgLogoGreen = driver.findElement(By.id("green-logo"));


        WebElement drpBox = driver.findElement(By.id("droppable"));

        Actions action = new Actions(driver);

        //Act

        action.dragAndDrop(drgLogoNormal, drpBox).build().perform();
        action.dragAndDrop(drgLogoBlue, drpBox).build().perform();

        action.dragAndDropBy(drgLogoRed, 250, 0).build().perform();

        action.clickAndHold(drgLogoGreen).perform();
        action.moveByOffset(250,0).perform();
        action.release(drgLogoGreen).perform();

        //Assert

        String erfolgsMeldung = driver.findElement(By.cssSelector("#droppable > p")).getText();
        assertTrue(erfolgsMeldung.contains("green-logo"));




    }
}
