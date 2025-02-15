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

    @FindBy(id = "at_price-to")
    private WebElement upPrice;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[1]/form/div[6]/div/div/button")
    private WebElement findButton;


     public void capchaButtonClick(){
        if(safeClick(capchaButton, "кнопка капчі не знайдена")) {
        }
    }

    public AdvancedSearch upPriceSet(String prize){
        if(safeSendKeys(upPrice,prize,"upPrize")){
            return this;
        }
        return null;
    }

    public  String getCurrentURL(){
        return driver.getCurrentUrl();
    }

    public ListOfCars listOfCarsClick(){
        if(safeClick(findButton,"Кнопки пошуку незнайдено")) {
            findButton.click();
            return new ListOfCars();
        }
        return null;
    }
}
