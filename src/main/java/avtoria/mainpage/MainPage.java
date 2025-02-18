package avtoria.mainpage;

import avtoria.advancedsearch.AdvancedSearch;
import avtoria.auth.LoginPage;
import base.pages.BaseSeleniumPage;
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
        if (safeClick(fullSearch, "Advanced search button")) {
            System.out.println("Advanced search button clicked");
            return new AdvancedSearch(driver);
        }
        return null;
    }

    public LoginPage clickLoginButton() {
        if (safeClick(loginButton, "login button")) {
            System.out.println("Login button clicled");
            return new LoginPage(driver);
        }
        return null;
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }
}
