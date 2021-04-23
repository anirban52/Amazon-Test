import Base.DriverFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class SetUpAndTearDown extends DriverFactory {

    @BeforeMethod()
    public void beforeTest(){
        System.out.println("Inside the Before Test Method");
        initAppiumDriver();
    }

    @AfterMethod()
    public void afterTest(){
        System.out.println("Inside the After Test Method");
        tearDown();
    }
}
