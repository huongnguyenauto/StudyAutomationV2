package com.huong.pages;

import com.huong.constants.FramworkConstants;
import com.huong.driver.DriverManager;
import com.huong.utils.WebKeyWord;
import org.openqa.selenium.By;

public class LoginCrmPage {

    By USER_BY = By.xpath("//input[@id='email']");
    By PASSWORD_BY = By.xpath("//input[@id='password']");
    By SUBMIT_BY = By.xpath("//button[@type='submit']");


    public void LoginCRM(String user, String password){
        DriverManager.getDriver().get(FramworkConstants.URL_PAGE);
        WebKeyWord.setText(USER_BY, user);
        WebKeyWord.setText(PASSWORD_BY, password);
        WebKeyWord.click(SUBMIT_BY);
    }
}
