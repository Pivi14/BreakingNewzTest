package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.Header;
import pages.LogInModal;
import pages.MainPage;
import pages.UserPage;

public class FavoriteTest extends DriverStup{
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
        mainPage.goToPage();
        header.openLoginField();
        logInModal.login(System.getenv("USER"), System.getenv("PASSWORD"));
    }

    @BeforeEach
    void goToMainPage(){
        userPage.goToPage();
    }

    @Test
    void setFavoriteTopicTest(){
        userPage.selectAllTopic();
        Assertions.assertEquals(7, userPage.getAppearedTopicsNumber());
        userPage.deselectAllTopic();
        Assertions.assertEquals(0, userPage.getAppearedTopicsNumber());
    }
}
