package manager;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    private WebDriver driver;
    private ChromeOptions chromeOptions; //multi languishes - chromeOptions;
    public Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    public  WebDriver getDriver(){
        return driver;
    }

    @BeforeMethod
    public void setUp(){
        chromeOptions = new ChromeOptions().addArguments("--lang=en");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
       // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //wait search element
        driver.manage().timeouts().setScriptTimeout(5,TimeUnit.SECONDS); // loading java script on pages
        driver.manage().timeouts().pageLoadTimeout(5,TimeUnit.SECONDS); //loading pages


    }

    @AfterMethod
    public void tearDown(){
 //       if(driver!=null)
 //           driver.quit();
    }
}
