package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MeetSkyDashboardPAGE {
    public MeetSkyDashboardPAGE(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[@id=\"expand\"]/div/img")
    public WebElement menubutton;
    @FindBy(xpath = "//li[@data-id='settings']")
    public WebElement settingsbutton;
}
