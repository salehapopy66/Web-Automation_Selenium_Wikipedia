package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import utilities.DriverSetup;

public class TestMainpage extends DriverSetup {

    MainPage mainPage = new MainPage();

    @Test
    public void testMainPage() {
        mainPage.loadAPage(mainPage.url);
        mainPage.addScreenShot("Main Page");
        Assert.assertEquals(mainPage.getPageTitle(), mainPage.title);

    }

    @Test
    public void testLoginButton(){
        mainPage.loadAPage(mainPage.url);
        mainPage.addScreenShot("Main Page");
        Assert.assertEquals(mainPage.getElementText(mainPage.login_btn),"Log in");
        Assert.assertTrue(mainPage.getElement(mainPage.login_btn).isEnabled());


    }
}
