package login;

import Base.BaseTest;
import org.testng.annotations.Test;
import pages.HubPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SignInTest extends BaseTest {

    @Test
    public void testSuccessfulSignIn() throws InterruptedException {
        signInPage.setEmailAddress("pedroalmodovar@test.com");
        signInPage.setPassword("1q2w3e");
        HubPage hubPage=signInPage.clickSignInButton();
        assertEquals(hubPage.getLandingPageTitle(),"Hub","The Landing page is not the Hub page");
        hubPage.visibleUserAvatarImage();
        hubPage.expandAvatarDropdown();
        assertTrue(hubPage.getAgentinformation().contains("Agent"));
        takeScreenshot();
    }
}
