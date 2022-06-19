package com.huong.testcase;

import com.huong.common.BaseTest;
import com.huong.helpers.PropertiesHelper;
import com.huong.pages.LoginCrmPage;
import com.huong.utils.WebKeyWord;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testobject.ObjectUtil;

public class LoginCrmTest extends BaseTest {

    public static String MESSAGE_ERRO = "//span[@id='password-error']";

    @BeforeClass
    public void createDriver(){
        PropertiesHelper.setDefaultFile();
    }

    @Test
    @Step("Sign in page to CRM system")
    public void TC01_loginTestWithUserPassCorrectCRM() throws InterruptedException {
        loginCrmPage = new LoginCrmPage();
        loginCrmPage.loginCrm(PropertiesHelper.getValue("USERNAME_VALUE_CRM"), PropertiesHelper.getValue("PASSWORD_VALUE_CRM"));
        Assert.assertTrue(WebKeyWord.getText(PropertiesHelper.getValue("TEXT_SHOWN"), "TEXT_SHOWN"));
    }
}
