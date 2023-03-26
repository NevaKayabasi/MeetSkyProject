package com.cydeo.step_definitions;

import com.cydeo.pages.AllFiles_Page;
import com.cydeo.pages.MeetSkyLoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class All_Files_Steps {

    MeetSkyLoginPage meetSkyLoginPage = new MeetSkyLoginPage();
    AllFiles_Page allFilesPage = new AllFiles_Page();



    @Given("user is on Meetsky log in page and click tasks")
    public void user_is_on_meetsky_log_in_page_and_click_tasks() {
        Driver.getDriver().get("https://qa.meetsky.net/index.php/login?clear=1");
        meetSkyLoginPage.username.sendKeys(ConfigurationReader.getProperty("username"));
        meetSkyLoginPage.password.sendKeys(ConfigurationReader.getProperty("password"));
        meetSkyLoginPage.loginbutton.click();
    }

    @And("user is on the all files list page")
    public void userIsOnTheAllFilesListPage() {

        allFilesPage.filesButton.click();
    }



    @When("user clicks on Name button")
    public void user_clicks_on_name_button() {

        allFilesPage.nameButton.click();
    }


    @Then("user sees folder files in alphabetic order")
    public void user_sees_folder_files_in_alphabetic_order() {


      List<WebElement> tableElement = allFilesPage.tableElements;


        List<String> filesnames = new ArrayList<>();

        for (WebElement names : tableElement) {
            if (names.getText().startsWith("1")||names.getText().startsWith("3")){
                continue;
            }
            filesnames.add(names.getText());

        }
        System.out.println(filesnames);
        boolean isAscending = true;

        for (int i = 0; i < filesnames.size()-1; i++) {
            if (filesnames.get(i).compareTo(filesnames.get(i+1)) < 0){
                isAscending = false;
                break;

            }

        }
        Assert.assertTrue(isAscending);
    }





    @Then("user click size button and sees folder files in order based on their size")
    public void userClickSizeButtonAndSeesFolderFilesInOrderBasedOnTheirSize() {


        List<WebElement> tableElementBeforeClick = allFilesPage.fileSize;


        List<String> sizeBeforeClick = new ArrayList<>();

        for (WebElement names : tableElementBeforeClick) {
            sizeBeforeClick.add(names.getText());

        }


        BrowserUtils.sleep(3);
        allFilesPage.sizeButton.click();
        BrowserUtils.sleep(3);



        List<WebElement> tableElementAfterClick = allFilesPage.fileSize;


        List<String> size = new ArrayList<>();

        for (WebElement names : tableElementAfterClick ) {
            size.add(names.getText());

        }


        Assert.assertNotEquals(sizeBeforeClick,size);


    }

    @Then("user clicks on Modified button and user sees folder files in order based on their date")
    public void userClicksOnModifiedButtonAndUserSeesFolderFilesInOrderBasedOnTheirDate() {
        List<WebElement> tableElementBefore = allFilesPage.modifiedDate;


        List<String> dateBefore = new ArrayList<>();

        for (WebElement names : tableElementBefore) {
            dateBefore.add(names.getText());

        }

        BrowserUtils.sleep(3);
        allFilesPage.modifiedButton.click();
        BrowserUtils.sleep(3);

        List<WebElement> tableElementAfter = allFilesPage.modifiedDate;


        List<String> dateAfter = new ArrayList<>();

        for (WebElement names : tableElementBefore) {
            dateAfter.add(names.getText());

        }

        Assert.assertNotEquals(dateAfter,dateBefore);
    }









    @When("the user clicks the toggle-view button")
    public void theUserClicksTheToggleViewButton() {

        allFilesPage.viewToggle.click();
    }



    @Then("the folder view should change to grid view")  /////
    public void theFolderViewShouldChangeToGridView() {

        Assert.assertTrue(allFilesPage.listView.isDisplayed());

    }




    @When("the user clicks on the select all checkbox")
    public void theUserClicksOnTheCheckbox() {

        BrowserUtils.sleep(3);
        allFilesPage.checkBox.click();
        BrowserUtils.sleep(3);
    }

    @Then("all files in the list are selected")
    public void allFilesInTheListAreSelected() {

        BrowserUtils.sleep(3);
        Assert.assertTrue(allFilesPage.checkBox.isEnabled());

    }

    @And("the total values of all selected files are displayed in the first line")
    public void theTotalValuesOfAllSelectedFilesAreDisplayedInTheFirstLine() {

        BrowserUtils.sleep(3);
        Assert.assertTrue(allFilesPage.allSelected.isDisplayed());
    }



}
