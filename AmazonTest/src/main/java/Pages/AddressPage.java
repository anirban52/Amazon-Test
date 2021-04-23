package Pages;

import Base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.util.List;

public class AddressPage extends BasePage {
    private AppiumDriver driver;
    public AddressPage(io.appium.java_client.AppiumDriver driver){
        super(driver);
        this.driver = driver;
    }

    private By DELIVER_TO_THIS_ADDRESS_BTN = By.xpath("//android.widget.Button");

    public ShippingOptionsPage clickDeliverToAddressBtn(){

        isPresentWaitTillVisible(DELIVER_TO_THIS_ADDRESS_BTN);
        List<MobileElement> listOfElements = driver.findElements(DELIVER_TO_THIS_ADDRESS_BTN);
        listOfElements.get(0).click();
        return new ShippingOptionsPage(driver);
    }

}
