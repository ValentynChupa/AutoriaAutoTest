package Avtoria;

import core.BaseSeleniumPage;
import core.BaseSeleniumTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BaseSeleniumPage {
     @FindBy(xpath = "//*[@id=\"desktop-nav-head\"]/a[3]")
     private WebElement real_estate;

    @FindBy(xpath = "//*[@id=\"desktop-nav-head\"]/a[4]")
    private WebElement auto_part;

    @FindBy(xpath = "//*[@id=\"mainSearchForm\"]/div[3]/a")
    private WebElement full_search;

    @FindBy(css = "#bu-desktop-header > div.app-head > div > div > a:nth-child(4) > span")
    private WebElement login_button;

     public MainPage() {

         driver.get("https://auto.ria.com/uk/");

         PageFactory.initElements(driver,this);

     }

     public AdvancedSearch advanced_search() {

         full_search.click();

         return new AdvancedSearch();
     }

     public MainPage login(){
         login_button.click();
         return this;
     }

    public  String getCurrentURL(){
        return driver.getCurrentUrl();
    }


}
