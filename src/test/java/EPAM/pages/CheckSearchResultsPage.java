package EPAM.pages;

import EPAM.config.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class CheckSearchResultsPage extends BaseTest {

    public CheckSearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "pnnext")
    private WebElement nextPage;

    @FindAll({@FindBy(css = ".srg .g .r>a .iUh30")})
    public List<WebElement> linksInSearch;

    public CheckSearchResultsPage clickOnFirstLink() {
        linksInSearch.get(0).click();
        logger.info("Clicking on first link on page");
        return this;
    }

    public Boolean searchForDomain(String text) {
        logger.info("Searching for expected domain " + text);

        Boolean bRes = false;
        outerloop:
        for (int i = 0; i < 5; i++) {
            for (WebElement link : linksInSearch) {

                if (link.getText().contains(text)) {
                    bRes = true;
                    logger.info("Expected domain is present on page!");
                    break outerloop;
                }
            }
            nextPage.click();
            logger.info("Expected domain is not present on page");

        }
        return bRes;
    }

}











