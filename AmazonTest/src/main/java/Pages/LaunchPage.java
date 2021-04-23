package Pages;

import Base.BasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class LaunchPage extends BasePage {
    private AppiumDriver driver;
    public LaunchPage(AppiumDriver driver){
        super(driver);
        this.driver = driver;
    }

    private By LAUNCH_PAGE_HEADER = By.id("signin_to_yourAccount");
    private By SIGN_IN_BUTTON = By.id("sign_in_button");

    public LoginPage clickSignIn(){
        isPresentWaitTillVisible(LAUNCH_PAGE_HEADER);
        clickElement(SIGN_IN_BUTTON);
        return new LoginPage(driver);
    }
}
