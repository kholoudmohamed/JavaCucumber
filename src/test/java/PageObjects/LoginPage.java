package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Selectors
    @FindBy(how = How.CSS,using = "div.logo>a>img")
    public static WebElement AppLogo ;

    @FindBy(how = How.ID,using = "username")
    public static WebElement UsernameTxt ;

    @FindBy(how = How.CSS,using = "#loginForm > div:nth-child(4) > span")
    public static WebElement UsernameIcon ;

    @FindBy(how = How.ID,using = "password-field")
    public static WebElement PasswordTxt ;

    @FindBy(how = How.CSS,using = "#loginForm > div:nth-child(5) > span")
    public static WebElement PasswordIcon ;

    @FindBy(how = How.CSS,using = "#loginForm > div > input[value='Log In']")
    public static WebElement LoginBtn ;

    @FindBy(how = How.CSS,using = "#loginForm > a")
    public static WebElement ForgetPasswordLink ;

    @FindBy(how = How.CSS,using = "#loginForm > div>p.title")
    public static WebElement LoginErrorMsgTitle ;

    @FindBy(how = How.CSS,using = "#loginForm > div>p.subtitle")
    public static WebElement LoginErrorMsgSubTitle ;
}
