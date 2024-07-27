package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PersonalBoardPage extends BasePage{
    public PersonalBoardPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(
                new AjaxElementLocatorFactory(driver, 10), this);
    }
    @FindBy(xpath = "//h1[@data-testid='board-name-display']")
    WebElement nameBoard;

    public boolean isTextInElementPresent_nameBoard(String text){
        return isTextInElementPresent(nameBoard, text, 5);
    }



}