package Avtoria;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BaseSeleniumPage {

     @FindBy(xpath = "//*[@id=\"desktop-nav-head\"]/a[3]")
     private WebElement realEstate;

    @FindBy(xpath = "//*[@id=\"desktop-nav-head\"]/a[4]")
    private WebElement autoPart;

    @FindBy(xpath = "//*[@id=\"mainSearchForm\"]/div[3]/a")
    private WebElement fullSearch;

    @FindBy(css = "#bu-desktop-header > div.app-head > div > div > a:nth-child(4) > span")
    private WebElement loginButton;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
     }

    public AdvancedSearch clickAdvancedSearch() {
        if (safeClick(fullSearch, "Кнопка розширеного пошуку")) {
            System.out.println("Кнопка розширеного пошуку натиснута");
            return new AdvancedSearch(driver);
        }
        return null;
    }

    public LoginPage clickLoginButton() {
        if (safeClick(loginButton, "Кнопка входу")) {
            System.out.println("Кнопка входу натиснута");
            return new LoginPage(driver);
        }
        return null;
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }
}
