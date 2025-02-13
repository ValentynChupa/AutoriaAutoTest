package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

abstract public class BaseSeleniumPage {
    protected static WebDriver driver;

    public static void setDriver(WebDriver webDriver)
    {
        driver = webDriver;

    }
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 секунд
    public void waitVisible(WebElement element ) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitClickable(WebElement element ) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }


}
