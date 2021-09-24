package com.devskiller.selenium;

import org.junit.Before;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo;
import static org.junit.Assert.assertEquals;

public class SeleniumLoginPageTest extends BaseSeleniumTest {

    private LoginPage loginPage;

    @Before
    public void beforeEachSeleniumLoginPageTest() {
        loginPage = new LoginPage(webDriver);
    }

    @Test
    public void shouldLoginUser() {
        loginPage.open();
        loginPage.fillCredentials("david", "pass123");
        loginPage.clickLoginButton();

        wireMockRule.verify(getRequestedFor(urlPathEqualTo("/api/login?username=david&password=pass123&rememberMe=false")));
    }

    @Test
    public void shouldDisplayErrorMessage() {
        String expectedMessage = "Invalid credentials";

        loginPage.open();
        loginPage.fillCredentials("aa", "bb");
        loginPage.clickLoginButton();

        String errorMessage = loginPage.getErrorMessage();
        System.out.println ("Error message :" + errorMessage);
        assertEquals(expectedMessage, errorMessage);
    }

    @Test
    public void shouldCheckUncheckedRememberMe() {
        loginPage.open("rememberMe", "false");
        loginPage.fillCredentials("david", "pass123");
        loginPage.setRememberMeChecked(true);
        loginPage.clickLoginButton();

        wireMockRule.verify(getRequestedFor(urlPathEqualTo("/api/login?username=david&password=pass123&rememberMe=true")));
    }

    @Test
    public void shouldUncheckCheckedRememberMe() {
        loginPage.open("rememberMe", "true");
        loginPage.fillCredentials("david", "pass123");
        loginPage.setRememberMeChecked(false);
        loginPage.clickLoginButton();

        wireMockRule.verify(getRequestedFor(urlPathEqualTo("/api/login?username=david&password=pass123&rememberMe=false")));
    }

    @Test
    public void shouldLeaveCheckedRememberMeToBeChecked() {
        loginPage.open("rememberMe", "true");
        loginPage.fillCredentials("david", "pass123");
        loginPage.setRememberMeChecked(true);
        loginPage.clickLoginButton();

        wireMockRule.verify(getRequestedFor(urlPathEqualTo("/api/login?username=david&password=pass123&rememberMe=true")));
    }
}
