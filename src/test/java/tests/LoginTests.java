package tests;

import dto.UserDTO;
import manager.ApplicationManager;
import org.testng.annotations.Test;
import pages.HomePage;

public class LoginTests extends ApplicationManager {

    UserDTO user = UserDTO.builder()
            .email("elenkina73@gmail.com")
            .password(",3P?CY5.!FtscxU")
            .build();


    @Test
    public  void  loginTest(){
        HomePage homePage = new HomePage(getDriver());
        homePage.clickBtnLogin();
    }
}
