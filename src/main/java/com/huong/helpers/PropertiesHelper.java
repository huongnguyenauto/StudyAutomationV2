package com.huong.helpers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class PropertiesHelper {

    private static Properties properties;
    private static FileInputStream fileIn;
    private static FileOutputStream fileOut;

    //Lấy đường dẫn đến project hiện tại
    static String projectPath = System.getProperty("user.dir") + "/";
    //Tạo đường dẫn đến file login.properties mặc định
    private static String propertiesFilePathRoot = "src/test/resources/login.properties";


    public static void setPropertiesFile() {
        properties = new Properties();
        try {
            //Khởi tạo giá trị cho đối tượng của class FileInputStream
            fileIn = new FileInputStream(projectPath + propertiesFilePathRoot);
            //Load properties file
            properties.load(fileIn);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
        }
    }

    //Xây dựng hàm Get Value từ Key của file properties đã setup bên trên
    public static String getPropValue(String KeyProp) {
        String value = null;
        try {
            //get values from properties file
            value = properties.getProperty(KeyProp);
            System.out.println(value);
            return value;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
        }
        return value;
    }

    //Xây dựng hàm Set Value với Key tương ứng vào trong file properties đã setup bên trên
    public static void setPropValue(String KeyProp, String Value) {
        try {
            //Khởi tạo giá trị cho đối tượng của class FileOutputStream
            fileOut = new FileOutputStream(projectPath + propertiesFilePathRoot);
            //Load properties file hiện tại và thực hiện mapping value với key tương ứng
            properties.setProperty(KeyProp, Value);
            //Lưu key và value vào properties file
            properties.store(fileOut, "Set new value in properties file");
            System.out.println("Set new value in file properties success.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            e.printStackTrace();
        }
    }

}
