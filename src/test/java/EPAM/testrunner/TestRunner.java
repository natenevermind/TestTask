package EPAM.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/java/EPAM/features/",
        strict = true,
        glue= "EPAM"
)
public class TestRunner extends AbstractTestNGCucumberTests {

}