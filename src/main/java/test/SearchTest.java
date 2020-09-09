package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.FilterPage;
import pages.Header;
import pages.MainPage;

public class SearchTest extends DriverStup {
    Header header;
    MainPage mainPage;
    FilterPage filterPage;

    @BeforeAll
    void loadPages(){
        header = new Header(driver);
        mainPage = new MainPage(driver);
        filterPage = new FilterPage(driver);
    }

    @BeforeEach
    void goToMainPage(){
        mainPage.goToPage();
    }

    @Test
    void searchWithOneWord(){
        header.searchWithOneWord("space");
        Assertions.assertEquals("http://localhost:3000/search/space", driver.getCurrentUrl());
    }
}
