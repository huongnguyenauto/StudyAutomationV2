package com.huong.pages;

import com.huong.constants.FrameworkConstants;
import com.huong.driver.DriverManager;
import com.huong.utils.WebKeyWordOld;
import org.openqa.selenium.Alert;
import testobject.ObjectUtil;

public class AlertPage {


    public void closeAlert(String id_customer) throws InterruptedException {
        DriverManager.getDriver().get(FrameworkConstants.URL_DEMO_ALERT);
        WebKeyWordOld.waitForPageLoaded();
        WebKeyWordOld.setText(ObjectUtil.getLocator("TXT_CUSTOMER_ID"), id_customer);
        Thread.sleep(2000);
        WebKeyWordOld.click(ObjectUtil.getLocator("BTN_SUBMIT_ALERT"));

        Alert alert = DriverManager.getDriver().switchTo().alert();
        Thread.sleep(2000);
        alert.accept();
        Thread.sleep(2000);
    }

    public void sendkeyAlert(String value01){
        DriverManager.getDriver().get(FrameworkConstants.URL_DEMO_ALERT_DEMOQA);
        WebKeyWordOld.waitForPageLoaded();

        WebKeyWordOld.click(ObjectUtil.getLocator("BTN_ALERT_CLICK"));

        Alert alert = DriverManager.getDriver().switchTo().alert();
        alert.sendKeys(value01);
        alert.accept();
    }

    public boolean verifyTextAlert(){
        String actualText = WebKeyWordOld.getText(ObjectUtil.getLocator("LBL_MESSAGE_RESULT"));
        if (WebKeyWordOld.verifyText(ObjectUtil.getLocator("LBL_MESSAGE_RESULT"), actualText)){
            return true;
        }
        return false;
    }
}
