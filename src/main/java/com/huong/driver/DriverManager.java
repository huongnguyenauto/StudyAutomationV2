package com.huong.driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    //Lấy giá trị Browser đã khởi tạo lại cho tất cả các class
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverManager(){

    }

    public static WebDriver getDriver(){
        return driver.get();
    }

    public static void setDriver(WebDriver driver){
        DriverManager.driver.set(driver);
    }

    public static void quit(){
        DriverManager.getDriver().quit();
        DriverManager.driver.remove();
    }

}
