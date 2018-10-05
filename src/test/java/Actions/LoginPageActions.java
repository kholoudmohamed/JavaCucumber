package Actions;

import PageObjects.LoginPage;
import Utilities.Enum;
import Utilities.GetData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class LoginPageActions {
    private static GetData data = new GetData();

    public static void Navigate(WebDriver driver)
    {
        driver.get(data.getPageUrl(Enum.Pages.LOGINPAGE));
    }

    //Actions
    public static void EnterUserNameAndPassword(String username, String password){
        LoginPage.UsernameTxt.sendKeys(username);
        LoginPage.PasswordTxt.sendKeys(password);
    }
    public static void ClickLogin(){
        LoginPage.LoginBtn.click();
    }
    public static String GetLoginErrorMessageTitleTxt(){
        return LoginPage.LoginErrorMsgTitle.getText();
    }
    public static String GetLoginErrorMessageSubTitleTxt(){
        return LoginPage.LoginErrorMsgSubTitle.getText();
    }
    public static String GetUsernameClassNameTxt(){
        return LoginPage.UsernameIcon.getAttribute("class");
    }
    public static String GetPasswordClassNameTxt(){
        return LoginPage.PasswordIcon.getAttribute("class");
    }
    public static boolean IsLoginErrorMessageTitleDisplayed(){
        return LoginPage.LoginErrorMsgTitle.isDisplayed();
    }
    public static boolean IsLoginErrorMessageSubTitleDisplayed(){
        return LoginPage.LoginErrorMsgSubTitle.isDisplayed();
    }
}
