package Avtoria;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BaseSeleniumPage {
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"gdpr-notifier\"]/div[1]/div[2]/label[1]")
    private WebElement capchaButton;
    @FindBy(xpath = "//*[@id=\"emailloginform-password\"]")
    private WebElement emailField;


    public void fillEmailField(){
        waitClickable(emailField);
        emailField.sendKeys("123123123123");

    }

    public void capchaButtonClick(){
        waitClickable(capchaButton);
        capchaButton.click();
    }
}
