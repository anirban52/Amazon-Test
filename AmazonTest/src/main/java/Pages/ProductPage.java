package Pages;

import Base.BasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class ProductPage extends BasePage {
    private AppiumDriver driver;
    public ProductPage(io.appium.java_client.AppiumDriver driver){
        super(driver);
        this.driver = driver;
    }

    private By STYLE_NAME = By.id("inline-twister-expanded-dimension-text-style_name");
    private String STYLE_NAME_TEXT = "4K UHD DTS Studio Sound";
    private By SIZE = By.id("inline-twister-expanded-dimension-text-size_name");
    private By BUY_NOW_BTN = By.id("buyNow_feature_div");

    public AddressPage readStyleSizeAndProceedToBuy(){
        isPresentWaitTillVisible(STYLE_NAME);
        STYLE = driver.findElement(STYLE_NAME).getText();
        swipeDownTillElementFound(SIZE);
        SIZE_TEXT = driver.findElement(SIZE).getText();
//        swipeDownTillElementFound(BUY_NOW_BTN);
        swipeCentre();
        clickElement(BUY_NOW_BTN);
        return  new AddressPage(driver);
    }


}
