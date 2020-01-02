package EPAM.tasks;

import EPAM.config.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.*;

public class CheckTitle extends BaseTest {


    @Given("Open https:\\/\\/www.google.com\\/")
    @Test(priority = 1, description = "Open first link")
    public void openGoogle() {
     openPage("https://www.google.com/");
    }

    @When("Enter text 'automation' in text Input")
    @Test(priority = 2, description = "Open first link")
    public void sendWord() {
        searchInGooglePage.inputText("automation");
    }

    @And("Click on search button")
    @Test(priority = 3, description = "Open first link")
    public void clickSearchButton() {
        searchInGooglePage.clickSearchButton();
    }

    @And("Open first link in search")
    @Test(priority = 4, description = "Open first link")
    public void clickOnFirstLink() {
        checkSearchResultsPage.clickOnFirstLink();
    }

    @Then("Title should contain word 'automation'")
    @Test(priority = 5, description = "Get title and check")
    public void checkTitleOnPage() {
        String expectedTitle = driver.getTitle();
        Assert.assertEquals(StringUtils.containsIgnoreCase(expectedTitle, "automation"), true, "Title doesn't contain word \"automation\"");
    }
}
