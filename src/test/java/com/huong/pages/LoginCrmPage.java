package com.huong.pages;

import com.huong.constants.FrameworkConstants;
import com.huong.driver.DriverManager;
import com.huong.utils.WebKeyWord;
import testobject.ObjectUtil;

public class LoginCrmPage {

    public void  LoginCRM(String user, String password){
        DriverManager.getDriver().get(FrameworkConstants.URL_PAGE);
        WebKeyWord.waitForPageLoaded();
        WebKeyWord.setText(ObjectUtil.getLocator("TXT_USERNAME"), user);
        WebKeyWord.setText(ObjectUtil.getLocator("TXT_PASSWORD"), password);
        WebKeyWord.click(ObjectUtil.getLocator("BTN_SUBMIT"));
    }
}
