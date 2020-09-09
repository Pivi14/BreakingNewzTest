package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInModal {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//div[@class='navbar-topics']/span[@aria-label='login']")
    WebElement openLoginButton;
    @FindBy(id = "username")
    WebElement userName;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(xpath = "//span[contains(.,'Log in')]/ancestor::button")
    WebElement loginButton;
    @FindBy(xpath = "//div[@class='welcome-header']")
    WebElement welcomeMessage;

    public LogInModal(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
    }

    public void login(String userName, String password){
        this.userName.sendKeys(userName);
        this.password.sendKeys(password);
        loginButton.submit();
        wait.until(ExpectedConditions.textToBePresentInElement(welcomeMessage, "Welcome " + userName + "!"));
    }
}
