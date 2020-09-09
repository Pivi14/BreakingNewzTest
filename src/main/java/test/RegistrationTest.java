package test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.*;

public class RegistrationTest extends DriverStup{
    MainPage mainPage;
    UserPage userPage;
    Header header;
    RegisterModal registerModal;
    LogInModal logInModal;

    @BeforeAll
    void setupPage(){
        mainPage = new MainPage(driver);
        userPage = new UserPage(driver);
        header = new Header(driver);
        registerModal = new RegisterModal(driver);
        logInModal = new LogInModal(driver);
    }

    @BeforeEach
    void goToMainPage(){
        mainPage.goToPage();
    }
}
