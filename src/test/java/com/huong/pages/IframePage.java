package com.huong.pages;

import com.huong.constants.FrameworkConstants;
import com.huong.driver.DriverManager;
import com.huong.utils.WebKeyWordOld;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IframePage {


    public void handleIframe() throws InterruptedException {
        DriverManager.getDriver().get(FrameworkConstants.URL_DEMO_IFRAME);
        WebKeyWordOld.waitForPageLoaded();

        WebKeyWordOld.sleep(10);
        int sizeIframe = DriverManager.getDriver().findElements(By.tagName("iframe")).size();
        System.out.println(sizeIframe);

        //Hàm frameToBeAvailableAndSwitchToIt trong Selenium hỗ trợ
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.WAIT_EXPLICIT), Duration.ofMillis(500));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(1));

//        driver.switchTo().frame(1);
//        DriverManager.getDriver().switchTo().parentFrame();
//        DriverManager.getDriver().switchTo().frame(1);
//        System.out.println("switched to frame");
        DriverManager.getDriver().findElement(By.tagName("svg")).click();
        WebKeyWordOld.sleep(2);
    }
}
