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
}
