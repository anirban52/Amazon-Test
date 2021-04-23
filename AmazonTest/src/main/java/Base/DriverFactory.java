package Base;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverFactory extends ReadConfig {
    public WebDriver driver;
    public DesiredCapabilities cap = new DesiredCapabilities();
    //    private Properties properties;
    public String ParentWindow;

    private static final String APP_PATH = System.getProperty("user.dir") + "/apps/Amazon_shopping.apk";
    private static final String CHROME_DRIVER_PATH = System.getProperty("user.dir") + "/Drivers/chromedriver";
    private static final String FIREFOX_DRIVER_PATH = System.getProperty("user.dir") + "/Drivers/geckodriver";
    private static final String CHROME_PROPERTY = "webdriver.chrome.driver";
    private static final String FIREFOX_PROPERTY = "webdriver.gecko.driver";
    private static final String HUB = "http://127.0.0.1:4723/wd/hub";




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

    public WebDriver launchWebDriver() {
        System.out.println("Launching the Browser");
        if (getData("browser").equals(Browsers.CHROME.name())) {
            System.setProperty(CHROME_PROPERTY, CHROME_DRIVER_PATH);
            return this.driver = new ChromeDriver();
        } else if (getData("browser").equals(Browsers.FIREFOX.name())) {
            System.setProperty(FIREFOX_PROPERTY, FIREFOX_DRIVER_PATH);
            return driver = new FirefoxDriver();
        } else {
            return driver = null;
        }
    }

    public WebDriver getDriver() {
        return this.driver;
    }


    public void initWebDriver() {
        loadProperties(FilePath);
        if (this.driver == null) {
            this.launchWebDriver();
        }

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

    public static enum Browsers {
        FIREFOX,
        CHROME;
    }


}
