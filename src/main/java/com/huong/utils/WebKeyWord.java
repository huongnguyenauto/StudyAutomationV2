package com.huong.utils;

import com.huong.constants.FrameworkConstants;
import com.huong.driver.DriverManager;
import com.huong.log.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.text.MessageFormat;
import java.time.Duration;

public class WebKeyWord {


    /**
     * Hàm này dùng để chờ đợi khoảng thời gian cố định. Đơn vị Giây
     *
     * @param second là đơn vị giây cần chờ đợi
     */
    public static void sleep(double second) {
        try {
            Thread.sleep((long) (second * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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

    public static boolean verifyCheckbox(By by) {
        boolean checkbox = DriverManager.getDriver().findElement(by).isSelected();
        if (checkbox == true) {
            return true;
        } else {
            return false;
        }

    }

    public static void click(By by) {
        DriverManager.getDriver().findElement(by).click();
        Log.info(MessageFormat.format("Click successfully {0}", by));
    }

    public static void setText(By by, String value) {
        try {
            System.out.println(by);
            System.out.println(value);
            DriverManager.getDriver().findElement(by).sendKeys(value);
            Log.info(MessageFormat.format("SendKey successfully {0} ", by));
        } catch (Exception e) {
            Log.error(MessageFormat.format("Not found element {0} ", by));
        }
    }

    public static void setText(By by, String value, String elementName) {
        try {
            System.out.println(by);
            System.out.println(value);
            DriverManager.getDriver().findElement(by).sendKeys(value);
            Log.info(MessageFormat.format("SendKey successfully {0} ", elementName));
        } catch (Exception e) {
            Log.error(MessageFormat.format("Not found element {0} ", elementName));
        }
    }

    public static boolean verifyUrl(String stringUrl) {
        WebDriver driver = DriverManager.getDriver();
        try {
            String textUrlShow = driver.getCurrentUrl();
            if (textUrlShow.contains(stringUrl)) {
                Log.info(MessageFormat.format("Text url already is shown: {0}", stringUrl));
                return true;
            }
        } catch (Exception e) {
            Log.error(MessageFormat.format("Not found text url is not correct: {0}", stringUrl));
        }
        return false;
    }

    public static String verifyGetText(String locator, String text) {
        WebDriver driver = DriverManager.getDriver();
        String textError = null;
        WebElement we = driver.findElement(By.xpath(locator));
        try {
            textError = we.getText();
            Log.info(MessageFormat.format("Text of {0} is the same {1}", locator, text));

        } catch (Exception e) {
            Log.info(MessageFormat.format("Text of {0} not the same get text {1} ", locator, text));
        }
        return textError;
    }

    public static String getText(By by) {
        System.out.println(by);
        String textError = null;
        WebElement we = DriverManager.getDriver().findElement(by);
        try {
            textError = we.getText();
            Log.info(MessageFormat.format("Text of {0} is the same {1}", we, textError));

        } catch (Exception e) {
            Log.info(MessageFormat.format("Text of {0} not the same get text {1} ", we));
        }
        return textError;
    }

    public static boolean verifyText(By by, String text) {
        WebDriver driver = DriverManager.getDriver();
        String textMessage = null;
        WebElement we = driver.findElement(by);
        try {
            textMessage = we.getText();
            Log.info(MessageFormat.format("The text of element " + by + " is {0}", textMessage));
            if (textMessage.contains(text)) {
                return true;
            }
        } catch (Exception e) {

        }
        return false;
    }

}
