package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingsUserPage {
    public SettingsUserPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "displayname")
    public WebElement settingsusername;
    @FindBy(id = "email")
    public WebElement settingsemail;
    @FindBy(id = "phone")
    public WebElement setingsphonenubmer;
    @FindBy(className = "federation-menu")
    public WebElement fedrationmenu;
    @FindBy(className = "menuitem-text-detail")
    public WebElement dropdownprivate;
    @FindBy(id = "localeexample-time")
    public WebElement localtime;
}
