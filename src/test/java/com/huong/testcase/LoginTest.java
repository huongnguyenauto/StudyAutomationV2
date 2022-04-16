package com.huong.testcase;

import com.huong.common.BaseTest;
import com.huong.listeners.TestListener;
import com.huong.helpers.PropertiesHelper;
import com.huong.pages.LoginPage;
import com.huong.utils.WebKeyWord;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
@Epic("Regression Test CRM")
@Feature("Login Test")

public class LoginTest extends BaseTest {
    LoginPage loginPage;
    WebKeyWord action;

    public static String MESSAGE_ERRO = "//span[@id=\"password-error\"]";

    @BeforeClass
    public void createDriver(){
        PropertiesHelper.setPropertiesFile();
        action = new WebKeyWord();
    }

    @Test(description = "Sign in page")
    @Step("Sign in page to CRM system")
    @Description("Login successfully")
    public void TC01_loginTestWithUserPassCorrectCRM() throws InterruptedException {
        loginPage = new LoginPage();
        loginPage.LoginCRM(PropertiesHelper.getPropValue("USER_NAME"), PropertiesHelper.getPropValue("PASS_WORD"));
        Assert.assertTrue(action.verifyUrl("/dashboard"));
    }

//    public void TC02_loginWithUserIsCorrectPasswordBlank() throws InterruptedException {
//        loginPage = new LoginPage();
//        loginPage.LoginCRM(PropertiesHelper.getPropValue("USER_NAME"), PropertiesHelper.getPropValue(""));
//        Assert.assertEquals(action.verifyGetText(MESSAGE_ERRO, "This field is required."));
//    }
}
