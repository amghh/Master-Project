package cdingsolo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestForm1SeleniumKursChrome {

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
        driver.findElement(By.linkText("Selenium Test Form1")).click();

        //Start Formular
        driver.findElement(By.id("form-widgets-betreff")).sendKeys("Automatischer Test");
        driver.findElement(By.id("form-widgets-name")).sendKeys("Idris PAPA");

        Select selectAuswahl1 = new Select(driver.findElement(By.id("form-widgets-auswahl1")));
        selectAuswahl1.selectByVisibleText("Java Grundlagen Kurs mit Dieter");

        Select selectAuswahl2 = new Select(driver.findElement(By.id("form-widgets-auswahl2-from")));
        selectAuswahl2.selectByIndex(2);
        selectAuswahl2.selectByIndex(4);
        selectAuswahl2.selectByIndex(6);

        Thread.sleep(1000);
        driver.findElement(By.name("from2toButton")).click();

        Select selectAuswahl3 = new Select(driver.findElement(By.id("form-widgets-auswahl2-to")));
        selectAuswahl3.selectByIndex(2);

        driver.findElement(By.name("upButton")).click();

        //Act
           Thread.sleep(1000);
          driver.findElement(By.name("form.buttons.speichern")).click();
       // driver.findElement(By.xpath("//input[@name='form.buttons.speichern']")).click();

        //Assert

        String erfolgsMeldung = driver.findElement(By.id("message")).getText();
        assertTrue(erfolgsMeldung.contains("Java Grundlagen Kurs"));

        String erstesElement = driver.findElement(By.xpath("//*[@id=\"companies\"]/li[1]")).getText();
        assertEquals("Magazzini Alimentari Riuniti", erstesElement);


    }
}
