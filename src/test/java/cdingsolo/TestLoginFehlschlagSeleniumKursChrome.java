package cdingsolo;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestLoginFehlschlagSeleniumKursChrome {

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
    public void test() {
        System.out.println("Starte Test Login mit Fehlschlag");

        //Arrange

        driver.findElement(By.id("__ac_name")).sendKeys("Benutzer");
        driver.findElement(By.name("__ac_password")).sendKeys("test");

        //Act

        driver.findElement(By.xpath("//input[@name='buttons.login']")).click();

        //Assert

        String fehlerMeldung = driver.findElement(By.cssSelector("div.portalMessage:nth-child(1)")).getText();
        assertTrue(fehlerMeldung.contains("Anmeldung fehlgeschlagen"));


    }
}
