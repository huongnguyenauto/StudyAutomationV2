package com.huong.testcase;

import com.huong.common.BaseTest;
import com.huong.helpers.PropertiesHelper;
import com.huong.pages.DropDownPage;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DropDownTest extends BaseTest {

    DropDownPage dropDownPage;

    @BeforeClass
    public void createDriver(){
        PropertiesHelper.setDefaultFile();
    }

    @Test
    public void chooseDropDown() throws InterruptedException {
        dropDownPage = new DropDownPage();
        dropDownPage.dropdown();
    }
}
