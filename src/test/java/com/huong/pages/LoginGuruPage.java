package com.huong.pages;

import com.huong.constants.FrameworkConstants;
import com.huong.driver.DriverManager;
import com.huong.utils.WebKeyWord;
import testobject.ObjectUtil;

public class LoginGuruPage {

    public void loginGuru(String username, String pasword){
        DriverManager.getDriver().get(FrameworkConstants.URL_PAGE_GURU);
        WebKeyWord.waitForPageLoaded();

        WebKeyWord.setText(ObjectUtil.getLocator("TXT_USERNAME_GURU"), username, ObjectUtil.getElementNameFromLocator("TXT_USERNAME_GURU"));
        WebKeyWord.setText(ObjectUtil.getLocator("TXT_PASSWORD_GURU"), pasword, ObjectUtil.getElementNameFromLocator("TXT_PASSWORD_GURU"));
        WebKeyWord.click(ObjectUtil.getLocator("BTN_SUBMIT_GURU"), ObjectUtil.getElementNameFromLocator("BTN_SUBMIT_GURU"));
    }
}
