package EPAM.tasks;

import EPAM.config.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckDomain extends BaseTest {

    @Given("Open https:\\/www.google.com\\/")
    @Test(priority = 1, description = "Open first link")
    public void openGoogle() {
        openPage("https://www.google.com/");
    }

    @When("Enter word in text input")
    @Test(priority = 2, description = "Input text")
    public void sendWordToTextInput() {
        searchInGooglePage.inputText("automation");
    }

    @When("Click on search button in Google")
    @Test(priority = 3, description = "Click on search button")
    public void clickOnSearchButton() {
        searchInGooglePage.clickSearchButton();
    }

    @Then("Expected domain should be present on pages")
    @Test(priority = 4, description = "Check pages 1-5 for the expected domain")
    public void checkIfDomainPresent() {
        Assert.assertTrue((checkSearchResultsPage.searchForDomain("testautomationday.com")),"Pages don't contain domain \"testautomationday.com\"");
    }

}
