package avtoria.auth;

import base.pages.BaseSeleniumPage;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseSeleniumPage {

    @FindBy(xpath = "//*[@id=\"gdpr-notifier\"]/div[1]/div[2]/label[1]")
    private WebElement captchaButton;  // Виправлено назву (capcha → captcha)

    @FindBy(id = "emailloginform-email")
    private WebElement emailField;

    @FindBy(id = "emailloginform-password")
    private WebElement passwordField;

    @FindBy(className = "mb30")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillEmailField(String email) {
        driver.switchTo().frame(0);
       if (safeSendKeys(emailField, email, "Email field")) {
            System.out.println("Email filled");
            driver.switchTo().defaultContent();
        }

    }

    public void fillPasswordField(String password) {
        driver.switchTo().frame(0);
        if (safeSendKeys(passwordField, password, "Password field")) {
            driver.switchTo().defaultContent();
        }

    }

    public void clickLoginButton() {
        driver.switchTo().frame(0);
        if (safeClick(loginButton,"Login button")) {
            driver.switchTo().defaultContent();
        }

    }

    public void captchaButtonClick() {
        if (safeClick(captchaButton, "Capcha button")) {
            System.out.println("Capcha button is clicked");
        }
    }
}