package core;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
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

    public void waitVisible(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(element));
    }
    public void waitClickable(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(element));
    }
    public boolean safeClick(WebElement element, String elementName) {
        try {
            waitClickable(element);
            element.click();
            return true;
        } catch (NoSuchElementException e) {
            System.out.println("Помилка: " + elementName + " не знайдено!");
        } catch (TimeoutException e) {
            System.out.println("Помилка: " + elementName + " не стала доступною вчасно!");
        }
        return false;
    }

    public boolean safeSendKeys(WebElement element, String text, String elementName) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(element)); // Очікуємо, поки поле стане видимим
            element.clear(); // Очищаємо поле перед введенням тексту
            element.sendKeys(text);
            System.out.println("✅ Успішно ввели текст у " + elementName + ": " + text);
            return true;
        } catch (NoSuchElementException e) {
            System.out.println("❌ Помилка: " + elementName + " не знайдено!");
        } catch (TimeoutException e) {
            System.out.println("⏳ Помилка: " + elementName + " не стало доступним вчасно!");
        }
        return false;
    }

}
