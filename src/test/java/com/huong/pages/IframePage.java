package com.huong.pages;

import com.huong.constants.FrameworkConstants;
import com.huong.driver.DriverManager;
import com.huong.utils.WebKeyWord;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IframePage {
    WebDriver driver;

    public void handleIframe() throws InterruptedException {
        driver = DriverManager.getDriver();
        DriverManager.getDriver().get(FrameworkConstants.URL_DEMO_IFRAME);
        WebKeyWord.waitForPageLoaded();

        Thread.sleep(8000);
        int sizeIframe = driver.findElements(By.tagName("iframe")).size();
        System.out.println(sizeIframe);

//        driver.switchTo().frame(1);
        driver.switchTo().parentFrame();
        driver.switchTo().frame(1);

        driver.findElement(By.tagName("svg")).click();
        Thread.sleep(2000);
    }
}
