package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
    public Properties properties;
    public String STYLE;
    public String SIZE_TEXT;
    public static final String FilePath = System.getProperty("user.dir") + "/dataFile.properties";
    public Properties loadProperties(String FilePath) {
        try {
            BufferedReader dataFile = new BufferedReader(new FileReader(FilePath));
            properties = new Properties();
            properties.load(dataFile);
            dataFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;

    }

    public String getData(String element){
        String data = properties.getProperty(element);
        return data;
    }
}
