package pages;

import interfaces.Path;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ProfileAndVisibility extends BasePage implements Path {
    public ProfileAndVisibility(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(
                new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath = "//div[@data-test-selector='profile-hover-info']")
    WebElement profilePhoto;
    @FindBy(xpath = "//button[@data-testid='change-avatar']")
    WebElement changeProfilePhoto;
    @FindBy(id = "image-input")
    WebElement inputUploadPhoto;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnUpload;
    @FindBy(xpath = "//div[@class='css-1748k3u']")
    WebElement popUpMessageAvatarAdded;
    @FindBy(xpath = "//span[@class='css-d8rbi4']")
    WebElement messageWrongFileFormat;

    public ProfileAndVisibility changeAvatar(String fileName) {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        Actions actions = new Actions(driver);
        actions.moveToElement(profilePhoto).pause(2000).click().perform();
        changeProfilePhoto.click();
        //pause(3);
        File file = new File(PHOTOS_PATH+fileName);
        String filePath = file.getAbsolutePath();
        inputUploadPhoto.sendKeys(filePath);
//        pause(3);
//        btnUpload.click();
        clickWait(btnUpload, 10);
        return this;
    }
    public boolean isTextInElementPresent_AvatarAdded(){
        return isTextInElementPresent(popUpMessageAvatarAdded, "We've uploaded your new avatar. " +
                "It may take a few minutes to display everywhere.", 7);
    }
    public boolean isTextInElementPresent_WrongFileFormat(){
        return isTextInElementPresent(messageWrongFileFormat, "Upload a photo or select", 3);
    }
}