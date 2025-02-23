package avtoria.advancedsearch;

import avtoria.advancedsearch.searchpage.SearchPage;
import base.pages.BaseSeleniumPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdvancedSearch extends BaseSeleniumPage {

    public AdvancedSearch(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"gdpr-notifier\"]/div[1]/div[2]/label[1]")
    private WebElement capchaButton;

    @FindBy(id = "at_price-to")
    private WebElement upPrice;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[1]/form/div[6]/div/div/button")
    private WebElement findButton;

    public void capchaButtonClick() {
        if (safeClick(capchaButton, "Capcha button has not found")) {
            System.out.println("Capcha button clicked");
        }
    }

    public AdvancedSearch upPriceSet(String prize) {
        if (safeSendKeys(upPrice, prize, "upPrize")) {
            System.out.println("Prize field is filled");
            return this;
        }
        return null;
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public SearchPage listOfCarsClick() {

        if (safeClick(findButton, "FindButton")) {
            return new SearchPage(driver);
        }
        return null;

    }
}

