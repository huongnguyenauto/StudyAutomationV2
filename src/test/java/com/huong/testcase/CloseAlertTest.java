package com.huong.testcase;

import com.huong.common.BaseTest;
import com.huong.helpers.PropertiesHelper;
import com.huong.pages.AlertPage;
import com.huong.utils.WebKeyWordOld;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CloseAlertTest extends BaseTest {

    AlertPage alertPage;

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
        WebKeyWordOld.sleep(2);
        Assert.assertTrue(alertPage.verifyTextAlert(),"The message");
    }

}
