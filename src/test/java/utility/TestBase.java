package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {


    public static WebDriver driver;

    public WebDriver WebDriverManager() throws IOException {

        FileInputStream fis = new FileInputStream(".//src/test/resources/GlobalProperty.properties");
        Properties prop = new Properties();
        prop.load(fis);

        String url = prop.getProperty("url");

        if (driver == null) {
            if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
            }

            if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
            }

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
            driver.get(url);
            driver.manage().window().maximize();
        }


        return driver;
    }
}
