package Base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage extends ReadConfig {
    private  AppiumDriver driver;
    private WebDriverWait wait;


    public BasePage(AppiumDriver driver){
        this.driver=driver;
    }

    public boolean isPresent(By by) {
        return driver.findElements(by).size() > 0;
    }

    public boolean isPresentWaitTillClickable(By by) {
        try {
            wait = new WebDriverWait(this.driver,10,200);
            this.wait.until(ExpectedConditions.elementToBeClickable(by));
            return true;
        } catch (TimeoutException var5) {
            return false;
        }
    }

    public boolean isPresentWaitTillVisible(By by) {
        try {
            wait = new WebDriverWait(this.driver,10,200);
            this.wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        } catch (TimeoutException var5) {
            return false;
        }
    }

    public void clickElement(By by){
        if(isPresentWaitTillClickable(by)){
            driver.findElement(by).click();
        }

    }

    public void sendInput(By by, String str){
        if(isPresentWaitTillVisible(by)){
            driver.findElement(by).sendKeys(str);
        }
    }

    public void swipeUpTillElementFound(By by){
        Dimension dimension = driver.manage().window().getSize();
        io.appium.java_client.TouchAction action = new io.appium.java_client.TouchAction<>(driver);
        int pressX = (dimension.getWidth()) / 2;
        int endY = 10;
        int startY = (dimension.getHeight()/2);
        for (int swipeCount = 0; swipeCount < 15; swipeCount++) {
            try {
                int countOfElement = driver.findElements(by).size();
                if (countOfElement==0 || driver.findElement(by).getAttribute("displayed").equals("false")) {
                    throw new Exception();
                }
                break;
            } catch (Exception e) {

                action.press(PointOption.point(pressX, startY)).
                        waitAction(new WaitOptions().withDuration(Duration.ofMillis(3000)))
                        .moveTo(PointOption.point(pressX, endY))
                        .release()
                        .perform();
            }
        }

    }

    public void swipeCentreUp(){

        Dimension dimension = driver.manage().window().getSize();
        io.appium.java_client.TouchAction action = new io.appium.java_client.TouchAction<>(driver);
        int pressX = (dimension.getWidth()) / 2;
        int endY = 10;
        int startY = (int) ((dimension.getHeight())-10);
        action.press(PointOption.point(pressX, startY)).
                waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(pressX, endY))
                .release().perform();

    }


}
