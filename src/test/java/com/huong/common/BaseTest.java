package com.huong.common;

import com.huong.constants.FramworkConstants;
import com.huong.driver.BrowserFactory;
import com.huong.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    static WebDriver driver;


    @BeforeMethod
    public void initBrowser(){
        driver = new BrowserFactory().setupDriver(FramworkConstants.URL_PAGE);
        DriverManager.setDriver(driver);//Lưu lại giá trị browser đã khởi tạo
    }

    @AfterMethod
    public void cloaseBrowser(){
        DriverManager.quit();
    }
}
