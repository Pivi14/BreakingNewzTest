package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Header {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "registration-modal")
    WebElement registrationModal;
    @FindBy(id = "login-modal")
    WebElement loginModal;
    @FindBy(xpath = "//div[@class='navbar-topics']/span[@aria-label='form']")
    WebElement openRegistrationButton;
    @FindBy(xpath = "//div[@class='navbar-topics']/span[@aria-label='login']")
    WebElement openLoginButton;
    @FindBy(xpath = "//div[@class='navbar-topics']/button[@class='logoutbtn']")
    WebElement logOutButton;
    @FindBy(xpath = "//div[@class='navbar-topics']/a[@href='/sports']")
    WebElement sportTopic;
    @FindBy(xpath = "//div[@class='searchbar']/input[@placeholder='Search..']")
    WebElement searchBar;
    @FindBy(xpath = "//a[contains(@href, '/search/')]")
    WebElement searchButton;

    public Header(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
    }

    public void openRegistration(){
        openRegistrationButton.click();
        wait.until(ExpectedConditions.attributeToBe(registrationModal, "style", "transform: translate3d(0%, 0px, 0px);"));
    }

    public void openLoginField(){
        wait.until(ExpectedConditions.visibilityOf(openLoginButton));
        openLoginButton.click();
        wait.until(ExpectedConditions.attributeToBe(loginModal, "style", "transform: translate3d(0%, 0px, 0px);"));
    }

    public boolean userPageButtonIsAppear(){
        return driver.findElements(By.xpath("//div[@class='navbar-topics']/span[@aria-label='user']")).size() > 0;
    }

    public void logout(){
        wait.until(ExpectedConditions.visibilityOf(logOutButton));
        logOutButton.click();
    }

    public void filterSportTopic(){
        sportTopic.click();
    }

    public void searchWithOneWord(String word){
        searchBar.sendKeys(word);
        searchButton.click();
    }
}
