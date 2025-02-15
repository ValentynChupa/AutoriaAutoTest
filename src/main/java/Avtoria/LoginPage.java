package Avtoria;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseSeleniumPage {

    @FindBy(xpath = "//*[@id=\"gdpr-notifier\"]/div[1]/div[2]/label[1]")
    private WebElement captchaButton;  // Виправлено назву (capcha → captcha)

    @FindBy(xpath = "//*[@id=\"emailloginform-password\"]")
    private WebElement emailField;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillEmailField(String email) {
        if (safeSendKeys(emailField, email, "Поле email")) {
            System.out.println("Email введено успішно.");
        }
    }

    public void captchaButtonClick() {
        if (safeClick(captchaButton, "Кнопка капчі")) {
            System.out.println("Капча натиснута успішно.");
        }
    }
}