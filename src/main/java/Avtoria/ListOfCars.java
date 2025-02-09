package Avtoria;

import core.BaseSeleniumPage;
import org.openqa.selenium.support.PageFactory;

public class ListOfCars extends BaseSeleniumPage {
    public ListOfCars() {
        PageFactory.initElements(driver,this);

    }

    public  String getCurrentURL(){
        return driver.getCurrentUrl();
    }
}
