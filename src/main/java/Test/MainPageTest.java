package Test;

import Avtoria.AdvancedSearch;
import Avtoria.LoginPage;
import Avtoria.MainPage;
import core.BaseSeleniumTest;
import org.junit.Assert;
import org.junit.Test;

public class MainPageTest extends BaseSeleniumTest {

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
    public void checkFillForm(){
        AdvancedSearch advencedSearch = new MainPage(driver).clickAdvancedSearch();
        advencedSearch.capchaButtonClick();
        advencedSearch.upPriceSet("1000");

        String advancetSearchUrl= new AdvancedSearch(driver)
                .listOfCarsClick()
                .getCurrentURL();
        System.out.println(advancetSearchUrl);
        Assert.assertEquals(
                "https://auto.ria.com/uk/advanced-search/?categories.main.id=1&indexName=auto,order_auto,newauto_search",
                advancetSearchUrl
        );
    }

    @Test
    public void loginAtemp(){
       LoginPage loginPage = new MainPage(driver).clickLoginButton();
       loginPage.captchaButtonClick();
       loginPage.fillEmailField("111");

    }
}
