package tests;

import dto.UserDTO;
import manager.ApplicationManager;
import manager.TakeScreenShot;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;
import pages.HomePage;

import static manager.PropertiesReader.getProperty;

public class LoginTests extends ApplicationManager {

//    UserDTO user = UserDTO.builder()
//            .email(getProperty("login.properties", "email"))
//            .password(getProperty("login.properties", "password"))
//            .build();

    @Test
    public void loginTest(){
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogin()
                .typeEmail(user)
                .typePassword(user)
        ;
        TakeScreenShot.takeScreenShot((TakesScreenshot) getDriver());
    }
}