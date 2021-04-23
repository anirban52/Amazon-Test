package Pages;

import Base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.util.List;

public class SearchResultPage extends BasePage {

    private AppiumDriver driver;
    public SearchResultPage(AppiumDriver driver){
        super(driver);
        this.driver = driver;
    }

    private By LIST_OF_PRODUCTS=By.id("list_product_linear_layout");

    public ProductPage selectProduct(){
        isPresentWaitTillClickable(LIST_OF_PRODUCTS);
        List<MobileElement> listOfElements = driver.findElements(By.id("list_product_linear_layout"));
        listOfElements.get(0).click();
        return new ProductPage(driver);
    }


}
