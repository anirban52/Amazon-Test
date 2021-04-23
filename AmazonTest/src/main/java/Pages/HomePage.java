package Pages;

import Base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.List;

public class HomePage extends BasePage {

    private AppiumDriver driver;
    public HomePage(AppiumDriver driver){
        super(driver);
        this.driver = driver;
    }

    private By SEARCH_INPUT = By.id("rs_search_src_text");
    private By SEARCH_LIST_SUGGESTIONS = By.id("iss_search_dropdown_item_suggestions");

    public SearchResultPage searchProductAndSelect(String searchInput){
        clickElement(SEARCH_INPUT);
        sendInput(SEARCH_INPUT,searchInput);
        List<MobileElement> list = driver.findElements(SEARCH_LIST_SUGGESTIONS);
        list.get(0).click();
        return new SearchResultPage(driver);
    }




}
