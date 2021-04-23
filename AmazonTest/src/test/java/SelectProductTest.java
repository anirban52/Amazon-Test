import Base.DriverFactory;
import Pages.LaunchPage;
import Pages.ShippingOptionsPage;
import io.appium.java_client.AppiumDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class SelectProductTest extends DriverFactory {

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
                {"UserName","Pwd","65-inch"}
        };
    }
}
