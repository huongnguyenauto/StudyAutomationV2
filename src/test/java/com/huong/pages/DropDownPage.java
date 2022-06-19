package com.huong.pages;

import com.huong.constants.FrameworkConstants;
import com.huong.driver.DriverManager;
import com.huong.utils.WebKeyWordOld;
import org.openqa.selenium.By;

public class DropDownPage {
    By DROPDOWN = By.xpath("//span[contains(text(),\"Select a Category\")]");
    By TXT_SEARCH = By.xpath("(//div[@class='chosen-search']//input)[3]");
    By CLICK_VALUE = By.xpath("//li[normalize-space()='Shops']");

    public void dropdown() throws InterruptedException {
        DriverManager.getDriver().get(FrameworkConstants.URL_DEMO_DROPDOWN);
        Thread.sleep(3000);
        WebKeyWordOld.click(DROPDOWN);
        Thread.sleep(2000);
        WebKeyWordOld.setText(TXT_SEARCH, "Shops");
        Thread.sleep(2000);
        WebKeyWordOld.click(CLICK_VALUE);
    }

}
