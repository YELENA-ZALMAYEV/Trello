package tests;

import dataproviders.DataProviderBoards;
import dto.BoardDTO;
import dto.UserDTO;
import manager.ApplicationManager;
import manager.TestNGListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BoardsPage;
import pages.HomePage;
import pages.PersonalBoardPage;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Random;

import static pages.BoardsPage.pause;

@Listeners(TestNGListener.class)

public class BoardsTests extends ApplicationManager {

    BoardsPage boardsPage = new BoardsPage(getDriver());

    @BeforeMethod
    public void loginBeforeBoards() {
        HomePage homePage = new HomePage(getDriver());
        boardsPage = homePage.clickBtnLogin()
                .typeEmail(user)
                .typePassword(user);
    }

    @Test(invocationCount = 2)
    public void createBoardPositive(Method method) {
        int i = new Random().nextInt(1000);
        BoardDTO board = BoardDTO.builder()
                .boardTitle("QA26-" + i)
                .build();
        logger.info(method.getName() + "starts with board title --> " + board.getBoardTitle());
        //HomePage homePage = new HomePage(getDriver());
        Assert.assertTrue(
                //homePage.clickBtnLogin()
                //.typeEmail(user)
                //.typePassword(user)
                boardsPage.typeBoardTitle(board)
                        .clickBtnCreateSubmitPositive()
                        .isTextInElementPresent_nameBoard(board.getBoardTitle()))
        ;
    }

    @Test()
    public void createBoardNegative_emptyBoardTitle() {
        BoardDTO board = BoardDTO.builder()
                .boardTitle("  ")
                .build();
        HomePage homePage = new HomePage(getDriver());
        Assert.assertFalse(homePage.clickBtnLogin()
                .typeEmail(user)
                .typePassword(user)
                .typeBoardTitle(board)
                .clickBtnCreateSubmitNegative()
                .isElementClickable_btnCreateSubmit(), "element is clickable")
        ;
    }

    @Test(dataProvider = "DPFile_deleteBoardPositiveTest", dataProviderClass = DataProviderBoards.class)
    public void deleteBoardPositiveTest(BoardDTO board) {
//        int i = new Random().nextInt(1000);
//        BoardDTO board = BoardDTO.builder()
//                .boardTitle("QA26-" + i)
//                .build();
        PersonalBoardPage personalBoardPage = boardsPage
                .typeBoardTitle(board)
                .clickBtnCreateSubmitPositive();
        if (personalBoardPage.isTextInElementPresent_nameBoard(board.getBoardTitle())) {
            Assert.assertTrue(personalBoardPage.deleteBoard(board)
                    .isTextPopUpPresent());
        } else {
            Assert.fail("board isn't create");
        }
    }

    @Test
    public void deleteAllBoard() {
        pause(3);
        List<WebElement> listBoars = getDriver().findElements(
                By.xpath("//li[@class='boards-page-board-section-list-item']"));
        System.out.println("size list --> " + listBoars.size());
        for (int i = 0; i < listBoars.size()-2; i++) {
            boardsPage.clickElement2ListBoards().deleteBoard(BoardDTO.builder().build());
            pause(5);
        }

    }
}