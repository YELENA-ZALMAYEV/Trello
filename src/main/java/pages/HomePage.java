package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static manager.PropertiesReader.getProperty;
public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        setDriver(driver);
        //driver.get("https://trello.com/home");
        driver.get(getProperty("login.properties", "url"));
        PageFactory.initElements(
                new AjaxElementLocatorFactory(driver, 15), this);
    }
    @FindBy(xpath = "//a[@data-uuid='MJFtCCgVhXrVl7v9HA7EH_login']")
    WebElement btnLogin;

    public LoginPage clickBtnLogin(){
        btnLogin.click();
        return new LoginPage(driver);
    }
}