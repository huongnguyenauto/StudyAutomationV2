package com.huong.testcase;

import com.huong.common.BaseTest;
import com.huong.driver.DriverManager;
import com.huong.helpers.PropertiesHelper;
import com.huong.pages.PopupWindownPage;
import com.huong.utils.WebKeyWord;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import testobject.ObjectUtil;

public class PopupWindowTest extends BaseTest {

    PopupWindownPage popupWindownPage;
    WebDriver driver;

    @Test
    public void handlerPopupWindow() throws InterruptedException {
        driver = DriverManager.getDriver();
        popupWindownPage = new PopupWindownPage();
        popupWindownPage.handlerPopupWindow(PropertiesHelper.getValue("POPUP_VALUE"));

        String urlCurrent = driver.getCurrentUrl();
        Assert.assertEquals(urlCurrent, "https://demo.guru99.com/popup.php");
    }

}
