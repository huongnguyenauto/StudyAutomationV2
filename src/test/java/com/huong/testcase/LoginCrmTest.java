package com.huong.testcase;

import com.huong.common.BaseTest;
import com.huong.listeners.TestListener;
import com.huong.helpers.PropertiesHelper;
import com.huong.pages.LoginCrmPage;
import com.huong.utils.WebKeyWord;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
@Epic("Regression Test CRM")
@Feature("Login Test")

public class LoginCrmTest extends BaseTest {
    LoginCrmPage loginCrmPage;

    public static String MESSAGE_ERRO = "//span[@id='password-error']";

    @BeforeClass
    public void createDriver(){
        PropertiesHelper.setDefaultFile();
    }

    @Test
    @Step("Sign in page to CRM system")
    public void TC01_loginTestWithUserPassCorrectCRM() throws InterruptedException {
        loginCrmPage = new LoginCrmPage();
        loginCrmPage.LoginCRM(PropertiesHelper.getValue("USERNAME"), PropertiesHelper.getValue("PASSWORD"));
        Assert.assertTrue(WebKeyWord.verifyUrl("/dashboard"));
    }

}
