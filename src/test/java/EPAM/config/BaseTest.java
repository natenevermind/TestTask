package EPAM.config;

import EPAM.pages.CheckSearchResultsPage;
import EPAM.pages.SearchInGooglePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;


public class BaseTest extends Configs {

    public CheckSearchResultsPage checkSearchResultsPage;
    public SearchInGooglePage searchInGooglePage;

    public static final Logger logger = LogManager.getLogger();

    @BeforeClass
    public void initPages() {
        checkSearchResultsPage = new CheckSearchResultsPage(driver);
        searchInGooglePage = new SearchInGooglePage(driver);
    }

    @AfterTest(alwaysRun = true)
    public void BrowserClose() {
        this.driver.quit();
        logger.info("Closing browser");

    }

    public void openPage(String url) {
        driver.get(url);
        logger.info("Opening page " + url);
    }

}
