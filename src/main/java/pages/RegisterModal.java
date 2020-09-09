package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterModal {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "email")
    WebElement emailAddress;
    @FindBy(id = "rpassword")
    WebElement firstPassword;
    @FindBy(id = "confirm")
    WebElement confirmPassword;
    @FindBy(id = "nickname")
    WebElement userName;
    @FindBy(xpath = "//span[contains(.,'Register')]/ancestor::button")
    WebElement registerButton;

    public RegisterModal(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
    }

    public void typeEmail(String email){
        emailAddress.sendKeys(email);
    }

    public void typeFirstPassword(String password){
        firstPassword.sendKeys(password);
    }

    public void typeSecondPassword(String password){
        confirmPassword.sendKeys(password);
    }

    public void typeUserName(String user){
        userName.sendKeys(user);
    }

    public void sendRegistration(){
        registerButton.submit();
    }
}
