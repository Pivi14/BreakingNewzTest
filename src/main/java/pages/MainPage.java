package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//section[@class='main-section']/div[@class='main-topnews-container']")
    WebElement mainNewsContainer;
    @FindBy(xpath = "//section[@class='main-section']/div[@class='main-topnews-container']/div/a[1]")
    WebElement firstNews;
    @FindBy(xpath = "//div[@class='welcome-header']")
    WebElement welcomeMessage;

    public void goToPage(){
        driver.get(System.getenv("BASE_URL"));
        wait.until(ExpectedConditions.visibilityOfAllElements(mainNewsContainer));
    }

    public MainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
    }

    public String getFirstNewsLink(){
        return firstNews.getAttribute("href");
    }

    public void openFirstNews(){
        firstNews.click();
    }

    public boolean userNameCheck(String username){
        wait.until(ExpectedConditions.textToBePresentInElement(welcomeMessage, "Welcome " + username + "!"));
        return welcomeMessage.getText().contains(username);
    }

    public boolean userNameIsNotAppear(String username){
        try{
            wait.until(ExpectedConditions.textToBePresentInElement(welcomeMessage, "Welcome " + username + "!"));
            return false;
        } catch(Exception ignore){
            return true;
        }
    }

}
