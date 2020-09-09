package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.Header;
import pages.LogInModal;
import pages.MainPage;
import pages.UserPage;

public class LogTest extends DriverStup{
    Header header;
    MainPage mainPage;
    UserPage userPage;
    LogInModal logInModal;

    @BeforeAll
    void loadPages(){
        header = new Header(driver);
        mainPage = new MainPage(driver);
        userPage = new UserPage(driver);
        logInModal = new LogInModal(driver);
    }

    @BeforeEach
    void goToMainPage(){
        mainPage.goToPage();
    }

    @Test
    void logInHappyWay(){
        header.openLoginField();
        logInModal.login(System.getenv("USER"), System.getenv("PASSWORD"));
        Assertions.assertTrue(mainPage.userNameCheck(System.getenv("USER")));
    }

    @Test
    void logInFail(){
        header.openLoginField();
        logInModal.login(System.getenv("USER"), "wrongpass");
        Assertions.assertFalse(header.userPageButtonIsAppear());
        Assertions.assertTrue(mainPage.userNameIsNotAppear(System.getenv("USER")));
        userPage.goToPage();
        Assertions.assertEquals(driver.getCurrentUrl(), "http://localhost:3000/");
    }

    @Test
    void logOutTest(){
        header.openLoginField();
        logInModal.login(System.getenv("USER"), System.getenv("PASSWORD"));
        header.logout();
        Assertions.assertFalse(header.userPageButtonIsAppear());
        Assertions.assertTrue(mainPage.userNameIsNotAppear(System.getenv("USER")));
        userPage.goToPage();
        Assertions.assertEquals(driver.getCurrentUrl(), "http://localhost:3000/");
    }
}
