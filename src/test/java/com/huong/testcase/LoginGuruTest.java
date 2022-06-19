package com.huong.testcase;

import com.huong.common.BaseTest;
import com.huong.helpers.PropertiesHelper;
import com.huong.pages.LoginGuruPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginGuruTest extends BaseTest {
    LoginGuruPage loginGuruPage;

    @BeforeClass
    public void createDriver(){
        PropertiesHelper.setDefaultFile();
    }

    @Test
    public void TC01_LoginGuruWithDataValid(){
        loginGuruPage = new LoginGuruPage();
        loginGuruPage.loginGuru(PropertiesHelper.getValue("USERNAME_VALUE_GURU"), PropertiesHelper.getValue("PASSWORD_VALUE_GURU"));
    }
}
