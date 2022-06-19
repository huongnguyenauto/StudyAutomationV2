package com.huong.utils;

import com.huong.constants.FrameworkConstants;
import com.huong.driver.DriverManager;
import com.huong.log.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.text.MessageFormat;
import java.time.Duration;

public class WebKeyWord {

    public static boolean getText(String value, String textShown){
        String textUrlShown = DriverManager.getDriver().getCurrentUrl();
        try {
            if (textUrlShown.contains(value)){
                Log.info(MessageFormat.format("The text {0} the url is contains", textShown));
                return true;
            }
        }catch (Exception e){
            Log.info(MessageFormat.format("The text {0} the url not contains", textShown));
        }
        return false;
    }

    public static void click(By by, String element){
        WebElement we = DriverManager.getDriver().findElement(by);
        try {
            we.click();
            Log.info(MessageFormat.format("Click {0} successfully", element));
        }catch (Exception e){
            Log.info(MessageFormat.format("Not found element {0} ", element));
        }
    }

    public static void setText(By by, String value, String element){
        WebElement we = DriverManager.getDriver().findElement(by);
        try {
            we.sendKeys(value);
            Log.info(MessageFormat.format("Set text {0} successfully", element));
        }catch (Exception e){
            Log.info(MessageFormat.format("Not found element {0}", element));
        }
    }

    public static void delay(int second) throws InterruptedException {
        Thread.sleep(3000);
    }



    public static void waitForPageLoaded() {

        // wait for jQuery to loaded
        ExpectedCondition<Boolean> jQueryLoad = driver -> {
            try {
                return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
            } catch (Exception e) {
                return true;
            }
        };

        // wait for Javascript to loaded
        ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState")
                .toString().equals("complete");

        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.WAIT_PAGE_LOAD), Duration.ofMillis(500));
            wait.until(jQueryLoad);
            wait.until(jsLoad);
//            ExtentReportManager.info("Page loaded");
//            AllureManager.saveTextLog("Page loaded");
        } catch (Throwable error) {
            Assert.fail("Quá thời gian load trang.");
        }
    }
}
