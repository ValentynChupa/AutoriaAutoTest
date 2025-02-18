package test;

import avtoria.advancedsearch.AdvancedSearch;
import avtoria.advancedsearch.searchpage.SearchPage;
import avtoria.auth.LoginPage;
import avtoria.helper.ConfigReader;
import avtoria.mainpage.MainPage;
import base.pages.BaseSeleniumTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

        SearchPage searchRequest = advancedSearch.listOfCarsClick();
        //create of elements that will be marker that user was redirected to search page
        WebElement newelement = driver.findElement(By.className("content-bar"));
        if (searchRequest != null) {
            System.out.println("URL: " + searchRequest.getCurrentURL());
            Assert.assertTrue(newelement.isDisplayed());
        } else {
            Assert.fail("User is not redirected to the search page");
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
