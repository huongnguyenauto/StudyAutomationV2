package com.huong.pages;

import com.huong.constants.FrameworkConstants;
import com.huong.driver.DriverManager;
import com.huong.utils.WebKeyWordOld;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testobject.ObjectUtil;

import java.time.Duration;

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

<<<<<<< HEAD
        WebKeyWord.sleep(2);

        //Viết hàm wait cái Alert xuất hiện (Exist)
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10), Duration.ofMillis(500));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
=======
        Alert alert = DriverManager.getDriver().switchTo().alert();
>>>>>>> LoginCrm
        alert.sendKeys(value01);
        WebKeyWord.sleep(1);
        alert.accept();
    }

    public boolean verifyTextAlert(){
<<<<<<< HEAD
        String actualText = WebKeyWord.getText(ObjectUtil.getLocator("LBL_MESSAGE_RESULT"));
        if (WebKeyWord.verifyText(ObjectUtil.getLocator("LBL_MESSAGE_RESULT"), actualText)){
=======
        String actualText = WebKeyWordOld.getText(ObjectUtil.getLocator("LBL_MESSAGE_RESULT"));
        if (WebKeyWordOld.verifyText(ObjectUtil.getLocator("LBL_MESSAGE_RESULT"), actualText)){
>>>>>>> LoginCrm
            return true;
        }
        return false;
    }
}
