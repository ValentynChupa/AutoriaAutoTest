package Avtoria;

import core.BaseSeleniumPage;
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

    @FindBy(xpath = "//*[@id=\"at_price-to\"]")
    private WebElement upPrice;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[1]/form/div[6]/div/div/button")
    private WebElement findButton;


     public void capchaButtonClick(){
        waitClickable(capchaButton);
        capchaButton.click();
    }

    public AdvancedSearch upPriceSet(String prize){
        waitVisible(upPrice);
        upPrice.sendKeys(prize);
        return this;
    }

    public  String getCurrentURL(){
        return driver.getCurrentUrl();
    }

    public ListOfCars listOfCarsClick(){
        waitClickable(findButton);
        findButton.click();
        return new ListOfCars();
    }
}
