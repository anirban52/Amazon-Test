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

    private By STYLE_NAME = By.xpath("//*[contains(@text,'Style:')]");
    private By FEATURE = By.xpath("//*[@text='SAMSUNG 65-inch Class Crystal UHD TU-8000 Series - 4K UHD HDR Smart TV with Alexa Built-in (UN65TU8000FXZA, 2020 Model)']");
    private By SIZE = By.xpath("//*[contains(@text,'Size:')]");
    private By BUY_NOW_BTN = By.id("buyNow");

    public AddressPage readStyleSizeAndProceedToBuy(){
        isPresentWaitTillVisible(FEATURE);
        STYLE = driver.findElement(STYLE_NAME).getText();
        System.out.println(STYLE);
        SIZE_TEXT = driver.findElement(SIZE).getText();
        System.out.println(SIZE);
        swipeUpTillElementFound(BUY_NOW_BTN);
        swipeCentreUp();
        clickElement(BUY_NOW_BTN);
        return  new AddressPage(driver);
    }


}
