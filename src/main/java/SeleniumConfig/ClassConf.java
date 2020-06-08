package SeleniumConfig;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ClassConf {
    public static WebDriver driver;
    public Properties properties;
    public FileInputStream file;
    public static JavascriptExecutor js;
    public static WebDriverWait wait;

    public ClassConf(){
        try{
            properties = new Properties();
            file = new FileInputStream("src\\main\\java\\Values\\values.properties");
            properties.load(file);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void initialization(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5), Duration.ofMillis(100));
        js = (JavascriptExecutor) driver;
    }

    public void clearCookiesAndLocalStorage(){
        driver.manage().deleteAllCookies();
        js.executeScript("localStorage.clear();");
    }
}