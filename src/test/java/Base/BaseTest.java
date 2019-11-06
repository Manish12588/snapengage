package Base;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.SignInPage;

import java.io.File;
import java.io.IOException;

public class BaseTest {
    private WebDriver driver;
    protected SignInPage signInPage;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver= new ChromeDriver();
        goHome();
    }

    @BeforeMethod
    public void goHome(){
        driver.get("https://snapengage-qa.appspot.com/signin?to=hub");
        driver.manage().window().maximize();
        signInPage= new SignInPage(driver);
    }

    public void takeScreenshot(){
        var camera=(TakesScreenshot)driver;
        File screenshot = camera.getScreenshotAs(OutputType.FILE);
        try {
            Files.move(screenshot,new File("resources/screenshots/test.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
