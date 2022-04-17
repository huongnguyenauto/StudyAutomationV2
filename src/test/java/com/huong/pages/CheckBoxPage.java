package com.huong.pages;

import com.huong.utils.WebKeyWord;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CheckBoxPage {

    By checkbox = By.xpath("//input[@id='isAgeSelected']");
    WebKeyWord action;

    public CheckBoxPage(){
        action = new WebKeyWord();
    }

    public void checkbox(){
        WebKeyWord.click(checkbox);



    }

}
