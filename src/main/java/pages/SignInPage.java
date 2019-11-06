package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {
    private WebDriver driver;
    private By emailInputField= By.name("email");
    private By passwordInputField= By.name("password");
    private By signInButton= By.xpath("//input[@value='Sign In']");

    public SignInPage(WebDriver driver){
        this.driver=driver;
    }

    public void setEmailAddress(String emailaddress){
        driver.findElement(emailInputField).sendKeys(emailaddress);
    }

    public void setPassword(String password){
        driver.findElement(passwordInputField).sendKeys(password);
    }

    public HubPage clickSignInButton(){
        driver.findElement(signInButton).click();
        return new HubPage(driver);
    }


}
