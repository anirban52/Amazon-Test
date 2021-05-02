package Base;

import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory extends ReadConfig {
    public WebDriver driver;
    public DesiredCapabilities cap = new DesiredCapabilities();

    private static final String APP_PATH = System.getProperty("user.dir") + "/apps/Amazon_shopping.apk";
    private static final String HUB = "http://127.0.0.1:4723/wd/hub";
    public static String REPORT_PATH;




//    private String getData(String element){
//        String data = properties.getProperty(element);
//        return data;
//    }

    public AppiumDriver launchAppiumDriver(){
        try {
            System.out.println("Starting the Launch of Appium driver");
            cap.setCapability("platformName", getData("platformName"));
            cap.setCapability("appiumVersion", getData("appiumVersion"));
            cap.setCapability("deviceName", getData("deviceName"));
            cap.setCapability("automationName", getData("automationName"));
            cap.setCapability("app", APP_PATH);
            cap.setCapability("orientation", getData("orientation"));
            cap.setCapability("noReset", false);
            cap.setCapability("fullReset", true);
            cap.setCapability("implicitWaitTime",10);
            driver = new AppiumDriver(new URL(HUB), cap);
            driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        }
        catch(MalformedURLException e){
            System.out.println(e.getMessage());
        }
        return (AppiumDriver)driver;
    }

    public WebDriver getDriver() {
        return this.driver;
    }


    public void initAppiumDriver() {
        loadProperties(FilePath);
        if (this.driver == null) {
            this.launchAppiumDriver();
        }

    }


    public void tearDown() {
        System.out.println("Quitting the Browser");
        this.driver.quit();
    }

    public static void copyFileUsingStream(File source1, File dest1, File source2, File dest2) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        FileUtils.copyFile(source1,dest1);
        FileUtils.copyFile(source2,dest2);
    }


}
