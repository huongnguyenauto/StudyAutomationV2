package com.huong.testcase;

import com.google.common.collect.LinkedListMultimap;
import com.huong.common.BaseTest;
import com.huong.helpers.PropertiesHelper;
import com.huong.pages.AlertPage;
import com.huong.utils.WebKeyWord;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testobject.ObjectUtil;

public class CloseAlertTest extends BaseTest {

    AlertPage alertPage;
    WebDriver driver;

    @BeforeClass
    public void createDriver(){
        PropertiesHelper.setDefaultFile();
    }

    @Test
    public void pressOkToCloseAler() throws InterruptedException {
        alertPage = new AlertPage();
        alertPage.closeAlert(PropertiesHelper.getValue("ID_CUSTOMER"));
    }

    @Test
    public void senkeyValue() throws InterruptedException {
        alertPage = new AlertPage();
        alertPage.sendkeyAlert(PropertiesHelper.getValue("VALUE_DEMO_ALERT"));
//        Assert.assertTrue(alertPage.verifyTextAlert(),PropertiesHelper.getValue("VALUE_DEMO_ALERT"));

        String value = driver.findElement(By.xpath("//span[@id=\"promptResult\"]")).getText();
        Thread.sleep(2000);
        System.out.println(value);
        Assert.assertTrue(value.contains("huongnt"),"không chứa giá trị cần tìm");
    }

}
