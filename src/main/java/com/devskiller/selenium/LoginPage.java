package com.devskiller.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class LoginPage {

	private static final String URL = "http://localhost:8089/index.html";
	private final WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void open(String... queryParams) {
		String queryString = QueryStringBuilder.buildQueryString(queryParams);
		driver.get(URL + queryString);
	}

	public void fillCredentials(String username, String password) {

		driver.findElement(By.xpath("//input[@name ='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name ='password']")).sendKeys(password);

	}

	public void clickLoginButton() {

		driver.findElement(By.xpath("//input[@value ='login']")).click();

	}

	public String getErrorMessage() {

		WebElement error_Message = driver.findElement(By.xpath("//span[contains(text(),'Invalid credentials')]"));
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(error_Message));

		String error_msg = driver.findElement(By.xpath("//span[contains(text(),'Invalid credentials')]"))
				.getAttribute("innerHTML");

		return error_msg;
	}

	public void setRememberMeChecked(boolean checked) {

		WebElement check_box = driver.findElement(By.xpath("//*[@id = 'container']/form/label/input"));

		if (checked == true) {

			boolean state = check_box.isSelected();
			if (state == false) {

				check_box.click();
			}
		}

		if (checked == false) {

			boolean state = check_box.isSelected();
			if (state == true) {

				check_box.click();
			}
		}
	}
}