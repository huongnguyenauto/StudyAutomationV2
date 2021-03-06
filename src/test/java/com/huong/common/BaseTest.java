package com.huong.common;

import com.huong.constants.FrameworkConstants;
import com.huong.driver.BrowserFactory;
import com.huong.driver.DriverManager;
import com.huong.helpers.PropertiesHelper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.HashMap;

public class BaseTest {

    static WebDriver driver;
    private HashMap<String, String> repoFile;


    @BeforeMethod
    public void initBrowser(){
        driver = new BrowserFactory().setupDriver(FrameworkConstants.BROWSER);
        DriverManager.setDriver(driver);//Lưu lại giá trị browser đã khởi tạo
        PropertiesHelper.loadAllFiles();
    }

    @AfterMethod
    public void cloaseBrowser(){
        if(DriverManager.getDriver() != null){
            DriverManager.quit();
        }
    }


}
