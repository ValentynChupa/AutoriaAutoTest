package test;

import avtoria.auth.LoginPage;
import avtoria.helper.ConfigReader;
import avtoria.mainpage.MainPage;
import base.pages.BaseSeleniumPage;
import org.junit.Test;

public class AuthTest extends BaseSeleniumPage {

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
