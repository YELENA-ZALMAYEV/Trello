package pages;

import dto.UserDTO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(
                new AjaxElementLocatorFactory(driver, 10), this);
    }
    @FindBy(xpath = "//input[@data-testid='username']")
    WebElement inputEmail;
    @FindBy(id = "login-submit")
    WebElement btnContinue;
    @FindBy(xpath = "//input[@data-testid='password']")
    WebElement inputPassword;
    @FindBy(xpath = "//span[text()='Log in']/..")
    WebElement btnLoginSubmit;

    public LoginPage typeEmail(UserDTO user){
        inputEmail.sendKeys(user.getEmail());
        btnContinue.click();
        return this;
    }

    public void typePassword(UserDTO user){
        pause(5);
        inputPassword.sendKeys(user.getPassword());
        btnLoginSubmit.click();
    }
}