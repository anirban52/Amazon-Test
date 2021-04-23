package Pages;

import Base.BasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;


public class ShippingOptionsPage extends BasePage {
    private AppiumDriver driver;
    public ShippingOptionsPage(io.appium.java_client.AppiumDriver driver){
        super(driver);
        this.driver = driver;
    }

    private By FEATURES = By.xpath("/android.widget.ListView/android.view.View/android.view.View[2]");
//    private String FEATURES_TEXT = "SAMSUNG 65-inch Class Crystal UHD TU-8000 Series - 4K UHD HDR Smart TV with Alexa Built-in (UN65TU8000FXZA, 2020 Model)";

    public String validateConfig(){
        return driver.findElement(FEATURES).getText();

    }
}
