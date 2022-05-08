package testobject;

import com.huong.helpers.PropertiesHelper;
import com.huong.log.Log;
import org.openqa.selenium.By;

public class ObjectUtil {

    public static By getLocator(String elementName) {

        // retrieve the specified object from the object list in properties file
        String locator = PropertiesHelper.getValue(elementName);

        if (locator.equals("") || locator.isEmpty()) {
            Log.info("The Locator " + elementName + " does not exist !!");
            try {
                throw new Exception("The Locator " + elementName + " does not exist !!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        // extract the locator type and value from the object
        String locatorType = locator.split(":")[0].trim();
        String locatorValue = locator.split(":")[1].trim();

        Log.info("Retrieving object of type '" + locatorType + "' and value '" + locatorValue + "' from the object repository");

        // Trả về một thể hiện của lớp By dựa trên loại định vị (id, name, xpath, css,...)
        // Đối tượng By có thể được sử dụng bởi driver.findElement (WebElement)
        if (locatorType.toLowerCase().equals("id"))
            return By.id(locatorValue);
        else if (locatorType.toLowerCase().equals("name"))
            return By.name(locatorValue);
        else if (locatorType.toLowerCase().equals("xpath"))
            return By.xpath(locatorValue);
        else if ((locatorType.toLowerCase().equals("cssselector")) || (locatorType.toLowerCase().equals("css")))
            return By.cssSelector(locatorValue);
        else if ((locatorType.toLowerCase().equals("classname")) || (locatorType.toLowerCase().equals("class")))
            return By.className(locatorValue);
        else if ((locatorType.toLowerCase().equals("tagname")) || (locatorType.toLowerCase().equals("tag")))
            return By.tagName(locatorValue);
        else if ((locatorType.toLowerCase().equals("linktext")) || (locatorType.toLowerCase().equals("link")))
            return By.linkText(locatorValue);
        else if ((locatorType.toLowerCase().equals("partiallinktext")) || (locatorType.toLowerCase().equals("partial")))
            return By.partialLinkText(locatorValue);
        else
            try {
                throw new Exception("Unknown locator type '" + locatorType + "'");
            } catch (Exception e) {
                e.printStackTrace();
            }
        return null;
    }
}
