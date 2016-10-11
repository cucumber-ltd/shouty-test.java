package io.cucumber.shouty;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * This class instructs JUnit to run Cucumber, which runs all
 * scenarios in all .feature files.
 *
 * You can run this test from the IDE, or from Maven using
 * `mvn test`
 */
@RunWith(Cucumber.class)
@CucumberOptions(monochrome = false, plugin = {"pretty", "html:target/cucumber"})
public class RunCukesTest {
}
