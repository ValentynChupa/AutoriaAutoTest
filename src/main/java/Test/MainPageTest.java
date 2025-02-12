package Test;

import Avtoria.AdvancedSearch;
import Avtoria.ListOfCars;
import Avtoria.MainPage;
import core.BaseSeleniumTest;
import org.junit.Assert;
import org.junit.Test;

public class MainPageTest extends BaseSeleniumTest {
    @Test//Advanced search testing if after click on Advanced search user is redirected to the right endpoint
    public void check_redirect_advanced_search() {

        MainPage MP = new MainPage();

        String resultPage = MP
                .advanced_search()
                .getCurrentURL();

        Assert.assertEquals("https://auto.ria.com/uk/advanced-search/?category_id=1", resultPage);
    }
    @Test//
    public void check_login_page(){

        MainPage MP = new MainPage();

        String loginUrl= MP
                .login()
                .getCurrentURL();

        Assert.assertEquals("https://auto.ria.com/uk/login.html",loginUrl);
    }
    @Test
    public void fill_search_form(){

        AdvancedSearch as = new MainPage().advanced_search();

        as.capcha_Button();

        as.upPriceSet("1000");

        String getLink= new AdvancedSearch().list_of_cars().getCurrentURL();

        Assert.assertEquals("https://auto.ria.com/uk/advanced-search/?categories.main.id=1&indexName=auto,order_auto,newauto_search",getLink);
    }
    @Test
    public void login_page(){

    }
}
