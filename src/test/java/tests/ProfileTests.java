package tests;

import dto.UserDTO;
import manager.ApplicationManager;
import manager.RetryAnalyzer;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BoardsPage;
import pages.HomePage;
import pages.ProfileAndVisibility;

public class ProfileTests extends ApplicationManager {
    UserDTO user = UserDTO.builder()
            .email("elenkina73@gmail.com")
            .password("qweQaz12#$%")
            .build();
    ProfileAndVisibility profileAndVisibility;

    @BeforeMethod
    public void loginBeforeProfile() {
        HomePage homePage = new HomePage(getDriver());
        profileAndVisibility = homePage.clickBtnLogin()
                .typeEmail(user)
                .typePassword(user)
                .goToProfileAndVisibility();
    }

    @Test (retryAnalyzer = RetryAnalyzer.class)
    public void changeProfilePhotoPositiveTest(){
        Assert.assertTrue(profileAndVisibility
                .changeAvatar("qa_blue.jpg")
                .isTextInElementPresent_AvatarAdded());
    }
    @Test
    public void changeProfilePhotoNegativeTest_wrongFileFormat(){
        Assert.assertTrue(profileAndVisibility
                .changeAvatar("log-20240731T190803.log")
                .isTextInElementPresent_WrongFileFormat());
    }
}