package com.cydeo.step_definitions;

import com.cydeo.pages.MeetSkyDashboardPAGE;
import com.cydeo.pages.MeetSkyLoginPage;
import com.cydeo.pages.SettingsUserPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Wait;

import javax.security.auth.login.Configuration;

public class SettingsPageStepDefinitions {
    MeetSkyLoginPage meetSkyLoginPage = new MeetSkyLoginPage();
    MeetSkyDashboardPAGE meetSkyDashboardPAGE = new MeetSkyDashboardPAGE();
    SettingsUserPage settingsUserPage = new SettingsUserPage();
    @Given("user is on the sign in page and type username and password")
    public void user_is_on_the_sign_in_page_and_type_username_and_password() {
        Driver.getDriver().get("https://qa.meetsky.net/index.php/login?clear=1");
        meetSkyLoginPage.username.sendKeys(ConfigurationReader.getProperty("username"));
        meetSkyLoginPage.password.sendKeys(ConfigurationReader.getProperty("password"));
        meetSkyLoginPage.loginbutton.click();
    }
    @Given("user is on the dashboard and user clicks settings")
    public void user_is_on_the_dashboard_and_clicks_settings(){
        BrowserUtils.waitForVisibility(meetSkyDashboardPAGE.menubutton,5);
        meetSkyDashboardPAGE.menubutton.click();
        meetSkyDashboardPAGE.settingsbutton.click();
    }
    @Then("user should see Full name Email Phone Number")
    public void user_should_see_full_name_email_phone_number() {
        Assert.assertTrue(settingsUserPage.settingsusername.isDisplayed());
        Assert.assertTrue(settingsUserPage.setingsphonenubmer.isDisplayed());
        Assert.assertTrue(settingsUserPage.settingsemail.isDisplayed());
    }
    @Then("user should be able to change full name to something else")
    public void user_should_be_able_to_change_full_name_to_something_else(){
        settingsUserPage.settingsusername.clear();
        settingsUserPage.settingsusername.sendKeys("NewName");
        Assert.assertTrue(settingsUserPage.settingsusername.isDisplayed());
    }
    @Then("user should click phone number and pick the private")
    public void userShouldClickPhoneNumberAndPickThePrivate() {
        settingsUserPage.fedrationmenu.click();
        settingsUserPage.dropdownprivate.click();
    }
    @Then("user should be able to see loca time")
    public void userShouldBeAbleToSeeLocaTime() throws InterruptedException {
        BrowserUtils.waitForVisibility(settingsUserPage.localtime,5);
         Assert.assertTrue(settingsUserPage.localtime.isDisplayed());
    }

    @Then("user enters speacial characters, numbers then user click enters")
    public void userEntersSpeacialCharactersAndNumbers() throws InterruptedException {
        settingsUserPage.settingsusername.clear();
        Thread.sleep(2000);
        settingsUserPage.settingsusername.sendKeys("?124@.,");
        settingsUserPage.settingsusername.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
    }

    @Then("user should not be able to see the special characters and numbers")
    public void userShouldGetAErrorMessage() throws InterruptedException {
        Driver.getDriver().navigate().back();
        Thread.sleep(1000);
        if (meetSkyDashboardPAGE.displaynamemessage.getText().contains("?124@.,")){
            assert false;
        }
        else {
            assert true;
        }

    }
}
