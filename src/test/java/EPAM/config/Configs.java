package EPAM.config;

import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import static io.github.bonigarcia.wdm.DriverManagerType.*;

public class Configs {

    protected WebDriver driver;

    @Parameters({"browser"})
    @BeforeClass

    public void setUp(@Optional("chrome") String browser) {

        if (browser.equalsIgnoreCase("chrome")) {

            WebDriverManager.getInstance(CHROME).setup();

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--disable-popup-blocking");options.addArguments("<--headless>");
            driver = new ChromeDriver (options);

        } else if (browser.equalsIgnoreCase("firefox")) {

            WebDriverManager.getInstance(FIREFOX).setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless");
            options.addArguments("--start-maximized");

            driver = new FirefoxDriver(options);

        } else if (browser.equalsIgnoreCase("opera")) {

            WebDriverManager.getInstance(OPERA).setup();
            driver = new OperaDriver();

        } else if (browser.equalsIgnoreCase("IE")) {

            WebDriverManager.getInstance(IEXPLORER).setup();
            driver = new InternetExplorerDriver();

        }
            driver.manage().timeouts().pageLoadTimeout(45L, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(15L, TimeUnit.SECONDS);
        }

}


























































//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.opera.OperaDriver;
//import org.openqa.selenium.remote.RemoteWebDriver;
//
//public class Configs {
//
//    public RemoteWebDriver driver;
//
//    public static WebDriver getDriver(String browser) {
//
//
//        System.setProperty("webdriver.chrome.driver",  "C:/Users/Admin/IdeaProjects/TestTask_EPAM/src/main/resources/drivers/chromedriver.exe");
//
//        WebDriver driver = new ChromeDriver();
//
//        if ("CHROME".equalsIgnoreCase(browser)) {
//            return new ChromeDriver();
//        } else if ("OPERA".equalsIgnoreCase(browser)) {
//            return new OperaDriver();
//        }else if ("FIREFOX".equalsIgnoreCase(browser)) {
//            return new FirefoxDriver();
//        } else {
//            return driver;
//        }
//    }
//}


//import java.io.FileInputStream;
//import java.net.URL;
//import java.util.Properties;
//import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.Platform;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.testng.ITestContext;
//import org.testng.annotations.*;
//
//public class Configs {
//
//    public RemoteWebDriver driver;
//    public Properties URL = null;
//    public DesiredCapabilities capability;
////    public String id_user;
//
//
////    @BeforeTest
////    public void initialize() throws Exception {
////        URL = new Properties();
////        FileInputStream baseUrl = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/config/URL.properties");
////        URL.load(baseUrl);
////    }
//
//    @Parameters({"browser", "os"})
//    @BeforeTest
//
//    public void setUp (@Optional("chrome") String browser, @Optional("WINDOWS") String os, final ITestContext context) throws Exception {
////    public void setUp(@Optional("chrome") String browser, @Optional("LINUX") String os, final ITestContext context) throws Exception {
//
//
//        if (browser.equalsIgnoreCase("firefox")) {
//
//            System.out.println("OPENING FIREFOX");
//            capability = DesiredCapabilities.firefox();
//            capability.setBrowserName("firefox");
//            //capability.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
//            capability.setPlatform(Platform.valueOf(os));
//
//        } else if (browser.equalsIgnoreCase("chrome"))
//
//        {
//            System.out.println("OPENING CHROME HEADLESS");
//            capability = DesiredCapabilities.chrome();
//
//            ChromeOptions options = new ChromeOptions();
//            System.setProperty("webdriver.chrome.driver",  "C:/Users/Admin/IdeaProjects/TestTask_EPAM/src/main/resources/drivers/chromedriver.exe");
//
////            driver = new RemoteWebDriver(new URL("http://127.0 0.1"), options);
//
//
////            options.addArguments("--headless");
////            options.addArguments("--disable-gpu");
//            capability.setCapability(ChromeOptions.CAPABILITY, options);
//            capability.setBrowserName("chrome");
//            capability.setPlatform(Platform.valueOf(os));
//
//        } else if (browser.equalsIgnoreCase("opera"))
//
//        {
//            System.out.println("OPENING OPERA");
//            capability = DesiredCapabilities.opera();
//            capability.setCapability("opera.binary", "C:\\Program Files\\Opera x64\\opera.exe");
//            capability.setBrowserName("opera");
//            capability.setPlatform(Platform.valueOf(os));
//
//        } else if (browser.equalsIgnoreCase("internet explorer"))
//
//        {
//            System.out.println("OPENING INTERNET EXPLORER");
//            capability = DesiredCapabilities.internetExplorer();
//            capability.setBrowserName("internet explorer");
//            capability.setPlatform(Platform.WINDOWS);
//
//        } else if (browser.equalsIgnoreCase("gecko"))
//
//        {
//            System.out.println("RUN GECKO DRIVER");
//            capability = DesiredCapabilities.firefox();
//            System.setProperty("webdriver.gecko.driver", "C:\\SeleniumServer\\geckodriver.exe");
////            capability.setCapability("webdriver.gecko.driver", "/var/www/geckodriver");
//            capability.setCapability("marionette", true);
//            capability.setBrowserName("firefox");
//            capability.setPlatform(Platform.valueOf(os));
//        }
//
//        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
////        this.driver = (RemoteWebDriver) WebDriverFactory.getDriver("http://localhost:4444/wd/hub", capability);
////        driver.manage().window().maximize();
////        this.driver = new ChromeDriver();
//        context.setAttribute("driverKey", driver);
//        driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//    }
//
//    @AfterTest(alwaysRun = true)
//    public void BrowserClose() {
//
//        driver.quit();
////		WebDriverFactory.dismissAll();
//        System.out.println("CLOSE BROWSER");
//    }
//}
