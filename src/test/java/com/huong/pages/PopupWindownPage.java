package com.huong.pages;

import com.huong.constants.FrameworkConstants;
import com.huong.driver.DriverManager;
import com.huong.utils.WebKeyWordOld;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import testobject.ObjectUtil;

import java.util.Set;

public class
PopupWindownPage {
    WebDriver driver;

    public void handlerPopupWindow(String text) throws InterruptedException {
        driver = DriverManager.getDriver();
        DriverManager.getDriver().get(FrameworkConstants.URL_DEMO_POPUPWINDOWN);
        WebKeyWordOld.waitForPageLoaded();

        WebKeyWordOld.click(ObjectUtil.getLocator("LBL_CLICK"));

        String mainWindow = driver.getWindowHandle();
        System.out.println(mainWindow);

        Set<String> windows = driver.getWindowHandles();
        System.out.println(windows);

        for (String window: windows){
            if (!mainWindow.equals(window)){
                driver.switchTo().window(window);
                Thread.sleep(3000);
                System.out.println("Đã switch sang child window");

                WebKeyWordOld.setText(ObjectUtil.getLocator("TXT_TEXTBOX"), text);
                WebKeyWordOld.click(ObjectUtil.getLocator("BTN_SUBMIT"));

                String textResponse = WebKeyWordOld.getText(ObjectUtil.getLocator("TEXT_APPEAR"));
                Assert.assertEquals(textResponse, "Access details to demo site.");

                driver.close();
            }
        }
        driver.switchTo().window(mainWindow);
        System.out.println("Đã switch sang parent" + driver.getCurrentUrl());
    }
}
