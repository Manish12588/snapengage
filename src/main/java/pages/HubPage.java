package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HubPage {
    private WebDriver driver;
    private By agentInformation=By.xpath("//div[@class='toggle']/span/img[@class='avatar']");
    private By userloggedin=By.xpath("//li[text()='Agent Settings']");

    public HubPage(WebDriver driver){
        this.driver = driver;
    }
    public String getLandingPageTitle(){
    return driver.getTitle();
    }

    public void visibleUserAvatarImage(){
        WebDriverWait wait = new WebDriverWait(driver, 90);
        wait.until(ExpectedConditions.visibilityOfElementLocated(agentInformation));
    }

    public void expandAvatarDropdown() throws InterruptedException {
        driver.findElement(agentInformation).click();
    }

    public String getAgentinformation()
    {
        return driver.findElement(userloggedin).getText();
    }





}
