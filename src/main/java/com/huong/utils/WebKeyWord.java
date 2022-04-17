package com.huong.utils;

import com.huong.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.MessageFormat;

public class WebKeyWord {

    public static void click(By by){
        DriverManager.getDriver().findElement(by).click();
        Log.info(MessageFormat.format("Click successfully {0}", by));
    }

    public static void setText(By by, Object value){
        try {
            DriverManager.getDriver().findElement(by).sendKeys((CharSequence) value);
            Log.info(MessageFormat.format("SendKey successfully {0} ", by));
        }catch (Exception e){
            Log.error(MessageFormat.format("Not found element {0} ", by));
        }
    }

    public boolean verifyUrl(String stringUrl){
        WebDriver driver = DriverManager.getDriver();
        try {
            String textUrlShow = driver.getCurrentUrl();
            if (textUrlShow.contains(stringUrl)){
                Log.info(MessageFormat.format("Text url already is shown: {0}",stringUrl));
                return true;
            }
        }catch (Exception e){
            Log.error(MessageFormat.format("Not found text url is not correct: {0}",stringUrl));
        }
        return false;
    }

    public String verifyGetText(String locator, String text){
        WebDriver driver = DriverManager.getDriver();
        String textError = null;
        WebElement we = driver.findElement(By.xpath(locator));
        try {
            textError = we.getText();
            Log.info(MessageFormat.format("Text of {0} is the same {1}", locator, text));

        }catch (Exception e){
            Log.info(MessageFormat.format("Text of {0} not the same get text {1} ", locator, text));
        }
       return textError;
    }

}
