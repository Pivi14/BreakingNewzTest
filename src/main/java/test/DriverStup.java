package test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class DriverStup {

    WebDriver driver = new ChromeDriver();

    @BeforeAll
    void setup(){
        driver.manage().window().maximize();
    }

    @AfterAll
    void close(){
//        driver.close();
    }
}
