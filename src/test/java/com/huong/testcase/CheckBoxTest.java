package com.huong.testcase;

import com.huong.common.BaseTest;
import com.huong.driver.DriverManager;
import com.huong.helpers.PropertiesHelper;
import com.huong.pages.CheckBoxPage;
import com.huong.pages.LoginCrmPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxTest extends BaseTest {
    CheckBoxPage checkBoxPage;
    By CHECKBOX = By.xpath("//input[@id='isAgeSelected']");


    @Test
    public void TC01_CheckBoxOne(){
        checkBoxPage = new CheckBoxPage();
        checkBoxPage.checkbox();
        Assert.assertTrue(true);
    }
}
