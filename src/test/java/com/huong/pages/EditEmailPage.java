package com.huong.pages;

import com.huong.constants.FrameworkConstants;
import com.huong.driver.DriverManager;
import com.huong.utils.WebKeyWord;
import org.openqa.selenium.WebElement;
import testobject.ObjectUtil;

import java.util.List;

public class EditEmailPage {

    public void EditEmail(String email){
        DriverManager.getDriver().get(FrameworkConstants.URL_DEMO_QA);
        WebKeyWord.waitForPageLoaded();

        List<WebElement> listEmail = DriverManager.getDriver().findElements(ObjectUtil.getLocator("WEBELEMENT_EMAIL"));
        List<WebElement> clickButton = DriverManager.getDriver().findElements(ObjectUtil.getLocator("BUTTON_EDIT"));

        if (listEmail.contains("alden@example.com")){
            WebKeyWord.click(clickButton, "BUTTON_EDIT");
        }
    }
}
