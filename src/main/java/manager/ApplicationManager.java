package manager;

import dto.UserDTO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import static manager.PropertiesReader.getProperty;

//https://github.com/AlexAksioma/QA_26_Trello/tree/master/src

public class ApplicationManager {
    //private EventFiringDecorator driver;
    private WebDriver driver;

    public Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
    public WebDriver getDriver(){
        return driver;
    }

    protected UserDTO user = UserDTO.builder()
            .email(getProperty("login.properties", "email"))
            .password(getProperty("login.properties", "password"))
            .build();


    @BeforeMethod
    public void setup(){
        ChromeOptions chromeOptions = new ChromeOptions().addArguments("--lang=en");
        driver = new ChromeDriver(chromeOptions);
       // driver = new FirefoxDriver();
        //new realization WDListeners in Selenium 4
        WebDriverListener webDriverListener = new WDListenerNew();
        driver = new EventFiringDecorator(webDriverListener).decorate(driver);

        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
        //wait for script to finish execution
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        //wait for loading page



    }
    @AfterMethod
    public void tearDown(){
        if(driver!=null)
            driver.quit();
    }
}