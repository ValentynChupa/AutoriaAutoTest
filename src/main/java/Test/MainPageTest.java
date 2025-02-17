package Test;

import Avtoria.*;
import core.BaseSeleniumTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainPageTest extends BaseSeleniumTest {


    private static final Logger log = LoggerFactory.getLogger(MainPageTest.class);


    @Test
    public void checkRedirectToAdvancedSearch() {
        MainPage mainPage = new MainPage(driver);

        String resultPage = mainPage
                .clickAdvancedSearch()
                .getCurrentURL();

        Assert.assertEquals(
                "https://auto.ria.com/uk/advanced-search/?category_id=1",
                resultPage
        );
    }


    @Test
    public void checkFillForm() {
        AdvancedSearch advancedSearch = new MainPage(driver).clickAdvancedSearch();

        advancedSearch.capchaButtonClick();
        advancedSearch.upPriceSet("1000");

        ListOfCars searchRequest = advancedSearch.listOfCarsClick();

        if (searchRequest != null) {
            System.out.println("URL: " + searchRequest.getCurrentURL());
            Assert.assertEquals(
                    "https://auto.ria.com/uk/advanced-search/?categories.main.id=1&indexName=auto,order_auto,newauto_search",
                    searchRequest.getCurrentURL()
            );
        } else {
            System.out.println("Не вдалося отримати список автомобілів.");
            Assert.fail("Не вдалося знайти список автомобілів.");
        }
    }


    @Test
    public void loginAtemp() {
       ConfigReader configReader = new ConfigReader("C:\\Users\\PC\\Documents\\creads.txt");

       String email = configReader.getEmail();
       String password = configReader.getPassword();

       LoginPage loginPage = new MainPage(driver).clickLoginButton();
       loginPage.captchaButtonClick();
       loginPage.fillEmailField(email);
       loginPage.fillPasswordField(password);
       loginPage.clickLoginButton();

    }
}
