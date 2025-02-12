package Avtoria;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdvancedSearch extends BaseSeleniumPage {

    public AdvancedSearch() {
        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath = "//*[@id=\"gdpr-notifier\"]/div[1]/div[2]/label[1]")
    private WebElement capchaButton;

    @FindBy(xpath = "//*[@id=\"at_price-to\"]")
    private WebElement up_price;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[1]/form/div[6]/div/div/button")
    private WebElement findbutton;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 секунд

    private void waitElIsCl(WebElement element ){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    } // 10 секунд

    private void waitElIsVi(WebElement element ){
        wait.until(ExpectedConditions.visibilityOf(element));
    }
     public void capcha_Button(){
        waitElIsCl(capchaButton);
        capchaButton.click();
    }

    public AdvancedSearch upPriceSet(String prize){
        waitElIsVi(up_price);
        up_price.sendKeys(prize);
        return this;
    }

    public  String getCurrentURL(){
        return driver.getCurrentUrl();
    }

    public ListOfCars list_of_cars(){
        waitElIsCl(findbutton);
        findbutton.click();
        return new ListOfCars();
    }
}
