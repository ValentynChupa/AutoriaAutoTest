package Avtoria;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdvancedSearch extends BaseSeleniumPage {

    public AdvancedSearch() {
        PageFactory.initElements(driver,this);

    }
    String prize = "1000";
    @FindBy(xpath = "//*[@id=\"gdpr-notifier\"]/div[1]/div[2]/label[1]")
    private WebElement capchaButton;

    @FindBy(xpath = "//*[@id=\"at_price-to\"]")
    private WebElement up_price;

    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/div[1]/form/div[6]/div/div/button")
    private WebElement findbutton;
    public void capcha_Button(){
        capchaButton.click();
    }

    public AdvancedSearch upPriceSet(){
        up_price.sendKeys(prize);
        return this;
    }
    public  String getCurrentURL(){
        return driver.getCurrentUrl();
    }

    public ListOfCars list_of_cars(){
        findbutton.click();
        return new ListOfCars();
    }
}
