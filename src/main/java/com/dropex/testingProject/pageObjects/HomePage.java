package com.dropex.testingProject.pageObjects;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    @FindBy(id="brand")
    private WebElement brand;

    public Boolean test(){
        return true;
    }

}
