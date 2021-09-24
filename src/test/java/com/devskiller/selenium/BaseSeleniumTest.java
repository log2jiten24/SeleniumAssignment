package com.devskiller.selenium;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseSeleniumTest {

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8089);

    protected WebDriver webDriver;

    @BeforeClass
    public static void prepareWebDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void beforeEachBaseSeleniumTest() {
        createWebDriver();
    }

    @After
    public void afterEachBaseSeleniumTest() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

    private void createWebDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--window-size=1920,1200");

        webDriver = new ChromeDriver(options);
    }
}
