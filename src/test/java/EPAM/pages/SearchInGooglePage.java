package EPAM.pages;

import EPAM.config.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SearchInGooglePage extends BaseTest {

    public SearchInGooglePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[name=q]")
    private WebElement textSearchInput;

    @FindBy(css = "input[name=btnK]")
    private WebElement searchButton;

    public SearchInGooglePage inputText(String value) {
        textSearchInput.sendKeys(value);
        logger.info("Typing text: " + value);
        return this;
    }

    public SearchInGooglePage clickSearchButton() {
        searchButton.click();
        logger.info("Clicking on search button");
        return this;
    }

}
