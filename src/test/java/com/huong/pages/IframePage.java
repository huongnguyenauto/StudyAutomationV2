package com.huong.pages;

import com.huong.constants.FrameworkConstants;
import com.huong.driver.DriverManager;
import com.huong.utils.WebKeyWordOld;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IframePage {

    private Object LoginCrm;

    public void handleIframe() throws InterruptedException {
        DriverManager.getDriver().get(FrameworkConstants.URL_DEMO_IFRAME);
        WebKeyWordOld.waitForPageLoaded();
        
        WebKeyWord.sleep(10);

        WebKeyWordOld.sleep(10);

        int sizeIframe = DriverManager.getDriver().findElements(By.tagName("iframe")).size();
        System.out.println(sizeIframe);

        //Hàm frameToBeAvailableAndSwitchToIt trong Selenium hỗ trợ
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.WAIT_EXPLICIT), Duration.ofMillis(500));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(1));

//        driver.switchTo().frame(1);
//        DriverManager.getDriver().switchTo().parentFrame();
//        DriverManager.getDriver().switchTo().frame(1);
        System.out.println("Switched to Frame");
        WebKeyWord.sleep(2);
        DriverManager.getDriver().findElement(By.tagName("svg")).click();
        WebKeyWord.sleep(2);
    }
}
