package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Footer {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//div[@class='footer-primary-links']/ul/li/a[@href='/sports']")
    WebElement sportTopic;

    public Footer(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
    }

    public void filterSportTopic(){
        sportTopic.click();
    }
}
