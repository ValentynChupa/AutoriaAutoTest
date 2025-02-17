package Avtoria;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ListOfCars extends BaseSeleniumPage {
    public ListOfCars(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public String getCurrentURL() {
        try {
            // Додаємо затримку або явне очікування для завантаження нової сторінки
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.urlContains("auto.ria.com"));

            return driver.getCurrentUrl();
        } catch (Exception e) {
            System.out.println("Помилка при отриманні URL: " + e.getMessage());
            return "";
        }
    }
}
