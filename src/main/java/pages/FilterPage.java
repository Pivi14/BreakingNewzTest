package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FilterPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//div[@class='topic-title']")
    WebElement topicTitle;

    public FilterPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
    }

    public String getTopicTitle(){
        return topicTitle.getText();
    }
}
