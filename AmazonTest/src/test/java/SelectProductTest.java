import Base.DriverFactory;
import ListenersPack.ReporterClass;
import Pages.LaunchPage;
import Pages.ShippingOptionsPage;
import io.appium.java_client.AppiumDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
@Listeners(value =ReporterClass.class)
public class SelectProductTest extends DriverFactory {

    @BeforeMethod()
    public void beforeTest(){
        System.out.println("Inside the Before Test Method");
        initAppiumDriver();
        REPORT_PATH = System.getProperty("user.dir")+"/Reports/Report_"+LocalDate.now()+LocalTime.now();
    }

    @AfterMethod()
    public void afterTest() throws IOException {
        System.out.println("Inside the After Test Method");
        File source1  = new File (System.getProperty("user.dir")+"/test-output/html/index.html");
        File dest1 = new File (REPORT_PATH+"/ReportNG_"+LocalDate.now()+LocalTime.now()+".html");
        File source2 = new File(System.getProperty("user.dir")+"/target/reports/AmazonTest/AmazonTest.html");
        File dest2 = new File(REPORT_PATH+"/TestNGDefault_"+LocalDate.now()+LocalTime.now()+".html");
        tearDown();

        copyFileUsingStream(source1,dest1,source2,dest2);
    }



    @Test(groups = {"WIPRO_TEST"},dataProvider = "Select_Product_Data")
    public void selectProductInAmzon(String email, String pwd, String searchProduct){
        System.out.println("Inside the Test Method");
        new LaunchPage((AppiumDriver) driver)
                .clickSignIn()
                .inputUserId(email)
                .inputPwd(pwd)
                .searchProductAndSelect(searchProduct)
                .selectProduct()
                .readStyleSizeAndProceedToBuy()
                .clickDeliverToAddressBtn();
        String FEATURE = new ShippingOptionsPage((AppiumDriver) driver).validateConfig();
        Assert.assertTrue(FEATURE.contains(STYLE));
        Assert.assertTrue(FEATURE.contains(SIZE_TEXT));

    }

    @DataProvider(name = "Select_Product_Data")
    public Object[][] selectProductData(){
        return new Object[][]{
                {"UserName","Password","65-inch"}
        };
    }
}
