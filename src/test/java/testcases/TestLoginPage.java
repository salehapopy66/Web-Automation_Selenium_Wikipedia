package testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LogInPage;
import pages.MainPage;
import utilities.DataSet;
import utilities.DriverSetup;

public class TestLoginPage extends DriverSetup {

    MainPage mainPage = new MainPage();
    LogInPage logInPage = new LogInPage();

    @Test
    public void testUserCanLoginWithValidCredentials(){
        mainPage.loadAPage(mainPage.url);
        mainPage.addScreenShot("Main Page");
        mainPage.cliclOnElement(mainPage.login_btn);

        logInPage.writeOnElement(logInPage.username_input,logInPage.username);
        logInPage.writeOnElement(logInPage.password_input,logInPage.password);
        logInPage.addScreenShot("LogIn Page after adding username and password");
        logInPage.cliclOnElement(logInPage.login_button);

        Assert.assertEquals(mainPage.getElementText(mainPage.username),logInPage.username);
        Assert.assertTrue(mainPage.waitForElementVisible(mainPage.user_icon).isDisplayed());
        mainPage.addScreenShot("Log in success");


    }
    @Test
    public void testUserShouldNotBeAbleToLoginWithInvalidUsername(){
        mainPage.loadAPage(mainPage.url);
        mainPage.cliclOnElement(mainPage.login_btn);

        logInPage.writeOnElement(logInPage.username_input,"username");
        logInPage.writeOnElement(logInPage.password_input,logInPage.password);
        logInPage.cliclOnElement(logInPage.login_button);

        Assert.assertEquals(logInPage.getElementText(logInPage.error_message),logInPage.error_text);
        Assert.assertTrue(logInPage.visibleState(logInPage.login_button));
    }

    @Test
    public void testUserShouldNotBeAbleToLoginWithInvalidPassword(){
        mainPage.loadAPage(mainPage.url);
        mainPage.cliclOnElement(mainPage.login_btn);

        logInPage.writeOnElement(logInPage.username_input,logInPage.username);
        logInPage.writeOnElement(logInPage.password_input,"password");
        logInPage.cliclOnElement(logInPage.login_button);

        Assert.assertEquals(logInPage.getElementText(logInPage.error_message),logInPage.error_text);
        Assert.assertTrue(logInPage.visibleState(logInPage.login_button));
    }

    @Test
    public void testUserShouldNotBeAbleToLoginWithInvalidUsernamePassword(){
        mainPage.loadAPage(mainPage.url);
        mainPage.cliclOnElement(mainPage.login_btn);

        logInPage.writeOnElement(logInPage.username_input,"username");
        logInPage.writeOnElement(logInPage.password_input,"password");
        logInPage.cliclOnElement(logInPage.login_button);

        Assert.assertEquals(logInPage.getElementText(logInPage.error_message),logInPage.error_text);
        Assert.assertTrue(logInPage.visibleState(logInPage.login_button));
    }

    @Test(dataProvider = "invalidUserCredentials", dataProviderClass = DataSet.class)
    public void testUserShouldNotBeAbleToLoginWithInvalidCredentials(String username, String password, String error_message){
        mainPage.loadAPage(mainPage.url);
        mainPage.cliclOnElement(mainPage.login_btn);

        logInPage.writeOnElement(logInPage.username_input, username);
        logInPage.writeOnElement(logInPage.password_input, password);
        logInPage.addScreenShot("LogIn Page after adding username and password");
        logInPage.cliclOnElement(logInPage.login_button);

        Assert.assertEquals(logInPage.getElementText(logInPage.error_message), error_message );
        Assert.assertTrue(logInPage.visibleState(logInPage.login_button));
        logInPage.addScreenShot("Log in page with Error message");
    }


}
