package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AllFiles_Page {
    public AllFiles_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }



    @FindBy(xpath = "//*[@id=\"appmenu\"]/li[2]/a")
    public WebElement filesButton;

    @FindBy (xpath = "//div[@id='app-content-files']//table//span[.='Name']")
    public WebElement nameButton;

    @FindBy (xpath = "//div[@id='app-content-files']//table//span[.='Size']")
    public WebElement sizeButton;

    @FindBy (xpath = "//table[@id='filestable']/tbody/tr/td[3]")
    public List<WebElement> fileSize;


    @FindBy (xpath = "//div[@id='app-content-files']//table//span[.='Modified']")
    public WebElement modifiedButton;

    @FindBy (xpath = "//table[@id='filestable']/tbody/tr/td[4]")
    public List<WebElement> modifiedDate;

    @FindBy (id = "view-toggle")
    public WebElement viewToggle;

    @FindBy (xpath = "//label[@class='button icon-toggle-pictures']")
    public WebElement picturesView;

    @FindBy (xpath = "//label[@class='button icon-toggle-filelist']")
    public WebElement listView;



    @FindBy(xpath = "//tr/td[2]")
    public List<WebElement> tableElements;


    @FindBy (xpath ="//table[@class='list-container has-controls']")
    public WebElement checkBox;

    @FindBy (xpath = "//div[@id='app-content-files']//table//span[.='3 folders']")
    public WebElement allSelected;





}
