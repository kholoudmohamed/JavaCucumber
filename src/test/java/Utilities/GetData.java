package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class GetData {
    private Properties pro;
    public GetData()
    {
        try {
            File source = new File ("src\\test\\java\\Utilities\\Data.properties");
            FileInputStream input=new FileInputStream(source);
            pro=new Properties();
            pro.load(input);
        }catch(Exception exp) {
            System.out.println("Exception is: ---" + exp.getMessage());
        }
    }

    // Get properties file data
    public String getBrowser(){
        return pro.getProperty("browser");
    }
    public String getChromeDriverPath(){
        return pro.getProperty("chromeDriverpath");
    }
    public String getFirefoxDriverPath(){
        return pro.getProperty("firefoxDriverpath");
    }
    public String getScreenSize(){
        return pro.getProperty("screenSize");
    }
    public String getScreenSizeHeight(){
        return pro.getProperty("screenSizeHeight");
    }
    public String getScreenSizeWidth(){
        return pro.getProperty("screenSizeWidth");
    }

    //Get test validators
    public String getLoginErrorMsgTitle(){
        return pro.getProperty("LoginErrorMessageTitle");
    }
    public String getLoginErrorMsgSubTitle(){
        return pro.getProperty("LoginErrorMessageSubTitle");
    }

    // Pages URLs
    public String getPageUrl(Enum.Pages page){
        String baseUrl =  pro.getProperty("BaseUrl");
        String pageName=page.toString().toUpperCase();
        String pageRelativeUrl = pro.getProperty(pageName);
        return baseUrl+pageRelativeUrl;
    }
}
