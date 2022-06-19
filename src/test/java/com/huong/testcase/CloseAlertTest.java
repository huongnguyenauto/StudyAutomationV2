
package com.huong.testcase;

import com.huong.common.BaseTest;
import com.huong.driver.DriverManager;
import com.huong.helpers.PropertiesHelper;
import com.huong.pages.AlertPage;
import com.huong.utils.WebKeyWordOld;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CloseAlertTest extends BaseTest {

    AlertPage alertPage;

    @BeforeClass
    public void createDriver() {
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

        //Kiểm tra giá trị nhập tù Alert có giống với Text dưới page chưa
        WebKeyWord.sleep(1);
        Assert.assertTrue(alertPage.verifyTextAlert(), "The message");
        WebKeyWord.sleep(1);
    }

}
