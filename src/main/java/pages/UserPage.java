package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//button[contains(.,'Select All')]")
    WebElement selectAllButton;
    @FindBy(xpath = "//button[contains(.,'Deselect All')]")
    WebElement deselectAllButton;
    @FindBy(xpath = "//button[contains(.,'Save')]")
    WebElement saveFavoriteTopicButton;
    @FindBy(xpath = "//section[@class='main-section']")
    WebElement topicSection;


    public UserPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
    }

    public void goToPage(){
        driver.navigate().to(System.getenv("BASE_URL") + "/userpage");
    }

    public void selectAllTopic(){
        selectAllButton.click();
        saveFavoriteTopicButton.click();
        wait.until(ExpectedConditions.visibilityOf(topicSection));
    }

    public void deselectAllTopic(){
        deselectAllButton.click();
        saveFavoriteTopicButton.click();
        wait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.xpath("//section[@class='main-section']"), 7));
    }

    public Integer getAppearedTopicsNumber(){
        return driver.findElements(By.xpath("//section[@class='main-section']")).size();
    }

}
