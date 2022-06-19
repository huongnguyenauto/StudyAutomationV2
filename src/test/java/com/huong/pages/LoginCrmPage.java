package com.huong.pages;

import com.huong.constants.FrameworkConstants;
import com.huong.driver.DriverManager;
import com.huong.utils.WebKeyWord;
import testobject.ObjectUtil;

public class LoginCrmPage {

    public void loginCrm(String username, String password){
        DriverManager.getDriver().get(FrameworkConstants.URL_PAGE_CRM);
        WebKeyWord.waitForPageLoaded();

        WebKeyWord.setText(ObjectUtil.getLocator("TXT_USERNAME_CRM"), username, ObjectUtil.getElementNameFromLocator("TXT_USERNAME_CRM"));
        WebKeyWord.setText(ObjectUtil.getLocator("TXT_PASSWORD_CRM"), password, ObjectUtil.getElementNameFromLocator("TXT_PASSWORD_CRM"));
        WebKeyWord.click(ObjectUtil.getLocator("BTN_SUBMIT_CRM"), ObjectUtil.getElementNameFromLocator("BTN_SUBMIT_CRM"));

    }

}
