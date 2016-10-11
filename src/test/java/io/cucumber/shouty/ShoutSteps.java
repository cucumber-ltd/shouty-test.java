package io.cucumber.shouty;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * This class implements Cucumber Step Definitions.
 * Cucumber creates a new instance for each scenario
 * and invokes a matching method for each Gherkin Step
 *
 * Paste generated step definitions in this class
 * and fill them out.
 *
 * Each Step Definition method should delegate to the
 * shoutyApi object.
 */
public class ShoutSteps {

    private ShoutyApi shoutyApi;

    @Before
    public void start() throws Exception {
        if ("selenium".equals(System.getProperty("automation"))) {
            shoutyApi = new SeleniumShouty();
        } else {
            shoutyApi = new SoapShouty();
        }
    }

    @After
    public void stop() {
        shoutyApi.stop();
    }

    // Step Definitions go here
}
