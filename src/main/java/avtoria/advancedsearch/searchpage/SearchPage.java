package avtoria.advancedsearch.searchpage;

import base.pages.BaseSeleniumPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage extends BaseSeleniumPage {
    public SearchPage(WebDriver driver) {
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
            System.out.println("Error on getting url: " + e.getMessage());
            return "";
        }
    }
}
