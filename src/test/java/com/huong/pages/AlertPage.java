package com.huong.pages;

import com.huong.constants.FrameworkConstants;
import com.huong.driver.DriverManager;
import com.huong.utils.WebKeyWord;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testobject.ObjectUtil;

public class AlertPage {

    WebDriver driver;

    public void closeAlert(String id_customer) throws InterruptedException {
        driver = DriverManager.getDriver();
        DriverManager.getDriver().get(FrameworkConstants.URL_DEMO_ALERT);
        WebKeyWord.waitForPageLoaded();
        WebKeyWord.setText(ObjectUtil.getLocator("TXT_CUSTOMER_ID"), id_customer);
        Thread.sleep(2000);
        WebKeyWord.click(ObjectUtil.getLocator("BTN_SUBMIT_ALERT"));

        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        alert.accept();
        Thread.sleep(2000);
    }

    public void sendkeyAlert(String value01){
        driver = DriverManager.getDriver();
        DriverManager.getDriver().get(FrameworkConstants.URL_DEMO_ALERT_DEMOQA);
        WebKeyWord.waitForPageLoaded();

        WebKeyWord.click(ObjectUtil.getLocator("BTN_ALERT_CLICK"));

        Alert alert = driver.switchTo().alert();
        alert.sendKeys(value01);
        alert.accept();
    }

    public boolean verifyTextAlert(){
        String actualText = WebKeyWord.getText(ObjectUtil.getLocator("LBL_MESSAGE_RESULT"));
        if (WebKeyWord.verifyText(actualText)){
            return true;
        }
        return false;
    }
}