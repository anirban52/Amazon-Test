import Base.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.*;
import java.time.LocalDate;

public class SetUpAndTearDown extends DriverFactory {

    @BeforeMethod()
    public void beforeTest(){
        System.out.println("Inside the Before Test Method");
        initAppiumDriver();
    }

    @AfterMethod()
    public void afterTest() throws IOException{
        System.out.println("Inside the After Test Method");
        tearDown();
        File source  = new File (System.getProperty("usr.dir")+"/test-output/html/index.html");
        File dest = new File (System.getProperty("usr.dir")+"/Reports/"+LocalDate.now()+".html");
    }


    }

