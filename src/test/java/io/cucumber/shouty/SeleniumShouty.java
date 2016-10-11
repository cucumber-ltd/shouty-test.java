package io.cucumber.shouty;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This implementation of ShoutyApi interacts with the Shouty
 * server via the browser UI, driven by Selenium WebDriver.
 *
 * Learn about the WebDriver API here:
 * http://www.seleniumhq.org/docs/03_webdriver.jsp
 */
public class SeleniumShouty implements ShoutyApi {
    private final Map<String, WebDriver> browsers = new HashMap<String, WebDriver>();

    @Override
    public void setLocation(String personName, int locationInMetres) {
        throw new UnsupportedOperationException("Write me please");
    }

    @Override
    public void shout(String shouterName, String message) {
        throw new UnsupportedOperationException("Write me please");
    }

    @Override
    public List<String> getMessagesHeardBy(String personName) {
        throw new UnsupportedOperationException("Write me please");
    }

    private String url(String path) {
        return "http://shouty.cucumber.io" + path;
    }

    public void stop() {
        for (WebDriver browser : browsers.values()) {
            browser.close();
        }
    }

    private WebDriver findOrCreateBrowser(String personName) {
        WebDriver browser = browsers.get(personName);
        if (browser == null) {
            browsers.put(personName, browser = new FirefoxDriver());
        }
        return browser;
    }
}
