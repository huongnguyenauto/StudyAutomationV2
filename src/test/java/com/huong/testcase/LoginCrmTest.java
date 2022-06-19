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

    LoginCrmPage loginCrmPage;

    @BeforeClass
    public void createDriver(){
        PropertiesHelper.setDefaultFile();
    }

    @Test
    public void TC01_LoginCrm(){
        loginCrmPage = new LoginCrmPage();
        loginCrmPage.loginCrm(PropertiesHelper.getValue("USERNAME_VALUE_CRM"), PropertiesHelper.getValue("PASSWORD_VALUE_CRM"));
        Assert.assertTrue(WebKeyWord.getText(PropertiesHelper.getValue("TEXT_SHOWN"), "TEXT_SHOWN"));
    }
}
