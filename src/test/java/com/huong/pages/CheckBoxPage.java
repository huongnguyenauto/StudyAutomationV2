package com.huong.pages;

import com.huong.constants.FrameworkConstants;
import com.huong.driver.DriverManager;
import com.huong.utils.WebKeyWordOld;
import org.openqa.selenium.By;

public class CheckBoxPage {

    By CHECKBOX = By.xpath("//input[@id='isAgeSelected']");

    public void checkbox(){
        DriverManager.getDriver().get(FrameworkConstants.URL_DEMO);
        WebKeyWordOld.click(CHECKBOX);
        WebKeyWordOld.verifyCheckbox(CHECKBOX);
    }
}
