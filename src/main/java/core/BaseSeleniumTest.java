package core;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

abstract public class BaseSeleniumTest {
    protected WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver.jar","D:\\selenium-chrome-driver-4.22.0");
        driver = new ChromeDriver();

        driver.manage()
                .timeouts()
                .pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://auto.ria.com/uk/");
        driver.manage()
                .timeouts()
                .implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        BaseSeleniumPage.setDriver(driver);


    }

    @After
    public void tearDown(){
     driver.close();
     driver.quit();
    }
}
