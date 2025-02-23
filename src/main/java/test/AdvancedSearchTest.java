package test;

import avtoria.advancedsearch.AdvancedSearch;
import avtoria.advancedsearch.searchpage.SearchPage;
import avtoria.mainpage.MainPage;
import base.pages.BaseSeleniumTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdvancedSearchTest extends BaseSeleniumTest {
    private static final Logger log = LoggerFactory.getLogger(AdvancedSearchTest.class);

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
}
