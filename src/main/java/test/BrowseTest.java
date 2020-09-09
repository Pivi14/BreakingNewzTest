package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.*;

public class BrowseTest extends DriverStup{
    Header header;
    MainPage mainPage;
    Footer footer;
    FilterPage filterPage;

    @BeforeAll
    void loadPages(){
        header = new Header(driver);
        mainPage = new MainPage(driver);
        footer = new Footer(driver);
        filterPage = new FilterPage(driver);
    }

    @BeforeEach
    void goToMainPage(){
        mainPage.goToPage();
    }

    @Test
    void browseNewsTest(){
        String expectedLink = mainPage.getFirstNewsLink();
        mainPage.openFirstNews();
        Assertions.assertEquals(driver.getCurrentUrl(), expectedLink);
    }

    @Test
    void filterNewsOnHeader(){
        header.filterSportTopic();
        Assertions.assertEquals("SPORTS", filterPage.getTopicTitle());
        Assertions.assertEquals("http://localhost:3000/sports", driver.getCurrentUrl());
    }

    @Test
    void filterNewsOnFooter(){
        footer.filterSportTopic();
        Assertions.assertEquals("SPORTS", filterPage.getTopicTitle());
        Assertions.assertEquals("http://localhost:3000/sports", driver.getCurrentUrl());
    }
}
