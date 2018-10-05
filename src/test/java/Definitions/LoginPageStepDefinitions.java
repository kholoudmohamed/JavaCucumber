package Definitions;

import Actions.LoginPageActions;
import PageObjects.LoginPage;
import Utilities.Enum;
import Utilities.GetData;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class LoginPageStepDefinitions {
    public WebDriver driver;
    private static GetData data = new GetData();

    public LoginPageStepDefinitions()
    {
        driver = Hook.driver;
    }

    @Given("^I navigated to Login Page$")
    public void iNavigatedToTheLoginPage() throws Throwable {
        LoginPageActions.Navigate(driver);
    }

    @And("^I enter invalid ([^\"]*) and ([^\"]*)$")
    public void enterInValidUsernameAndPassword(String username, String password) throws Throwable {
        PageFactory.initElements(driver, LoginPage.class);
        LoginPageActions.EnterUserNameAndPassword(username,password);
    }

    @And("^I click on login button$")
    public void iClickOnLoginButton() throws Throwable {
        PageFactory.initElements(driver, LoginPage.class);
        LoginPageActions.ClickLogin();
    }

    @Then("^Login Error message should be displayed$")
    public void invalidUsernameOrPasswordErrorMessageShouldBeDisplayed() throws Throwable {
        PageFactory.initElements(driver, LoginPage.class);
        Assert.assertTrue("Login Error Message Title is not displayed",LoginPageActions.IsLoginErrorMessageTitleDisplayed());
        Assert.assertTrue("Login Error Message Sub Title is not displayed",LoginPageActions.IsLoginErrorMessageSubTitleDisplayed());
    }

    @And("^Error message text is correct$")
    public void errorMessageTextIsCorrect() throws Throwable {
        PageFactory.initElements(driver, LoginPage.class);
        Assert.assertEquals("Login Error Message Title text is not correct",data.getLoginErrorMsgTitle(),LoginPageActions.GetLoginErrorMessageTitleTxt());
        Assert.assertEquals("Login Error Message Subtitle text is not correct",data.getLoginErrorMsgSubTitle(),LoginPageActions.GetLoginErrorMessageSubTitleTxt());
    }

    @And("^Username and Password Icons changed to Error Mode$")
    public void usernameAndPasswordIconsInErrorMode() throws Throwable {
        PageFactory.initElements(driver, LoginPage.class);
        Assert.assertTrue("Username icon not in error mode",LoginPageActions.GetUsernameClassNameTxt().contains("error"));
        Assert.assertTrue("Password icon not in error mode",LoginPageActions.GetPasswordClassNameTxt().contains("error"));
    }

    @And("^User should be directed to Login Error Page$")
    public void currentPageIsLoginError() throws Throwable {
        PageFactory.initElements(driver, LoginPage.class);
        Assert.assertEquals("Current URL is not correct",data.getPageUrl(Enum.Pages.LOGINERRORPAGE),driver.getCurrentUrl());
    }
}
