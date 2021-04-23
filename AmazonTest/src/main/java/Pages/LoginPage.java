package Pages;

import Base.BasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private AppiumDriver driver;

    public LoginPage(AppiumDriver driver){
        super(driver);
        this.driver = driver;
    }

    private By LOGIN_PAGE_HEADER = By.id("login_accordion_header");
    private By EMAIL = By.id("ap_email_login");
    private By CONTINUE_BTN = By.id("continue");
    private By PASSWORD = By.id("ap_password");
    private By SIGN_IN_BTN = By.id("signInSubmit");

    public LoginPage inputUserId(String email){
        isPresentWaitTillVisible(LOGIN_PAGE_HEADER);
        sendInput(EMAIL,email);
        clickElement(CONTINUE_BTN);
        return this;
    }

    public HomePage inputPwd(String pwd){
        isPresentWaitTillVisible(PASSWORD);
        sendInput(PASSWORD,pwd);
        clickElement(SIGN_IN_BTN);
        return new HomePage(driver);
    }





}
