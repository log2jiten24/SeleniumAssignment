# Introduction

You are working on tests for user authentication. The login page allows users to log in with valid credentials and can remember the credentials.
A tester not familiar with the Selenium WebDriver has already implemented the tests and left the LoginPage class with not implemented methods.

# Task definition

Your task is to implement four methods at the LoginPage class marked with //TODO implementation. All of them should use the Selenium WebDriver to interact with the `src/test/resources/__files/index.html` page. 
You can assume that the page has already been loaded by the driver. 

The implementation will be correct if all tests from the `\src\test\java\com\descriptor\selenium\SeleniumLoginPageTest` class pass.

Description of methods to be implemented:
1. The `fillCredentials` method should fill in the username and password input on the page.
2. The `clickLoginButton`method should click the login button.
3. The `getErrorMessage` method should return an error message from the `span` element with the `error-message` class.
An element can appear on the page with random delay, varying from 0 to 3 seconds upon clicking the login button when entered credentials are incorrect. 
4. The `setRememberMeChecked(Boolean checked)` method should leave the checkbox with the `Remember me` label to be checked if the passed argument is true and unchecked when the passed argument is false. You cannot assume that the page will load with a checked or unchecked checkbox!

