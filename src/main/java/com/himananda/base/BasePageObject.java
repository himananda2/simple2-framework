package com.himananda.base;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject<T> {

	protected WebDriver driver;
	protected WebDriverWait wait;

	protected BasePageObject(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 40);
	}

	@SuppressWarnings("unchecked")
	protected T getPage(String url) {

		driver.get(url);
		return (T) this;

	}

	protected void type(String text, By element) {
		driver.findElement(element).sendKeys(text);

	}

	protected void click(By signInButton2) {
		driver.findElement(signInButton2).click();
		driver.getTitle();

	}

	protected void waitforVisibilityOf(By locator, Integer... timeoutSeconds) {
		int attempts = 0;
		while (attempts < 2) {
			try {
				waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
						(timeoutSeconds.length) > 0 ? timeoutSeconds[0] : null);
			} catch (StaleElementReferenceException e) {

			}
			attempts++;

		}

	}

	@SuppressWarnings("unused")
	private void waitFor(ExpectedCondition<WebElement> condition, Integer timeoutSeconds) {

		timeoutSeconds = timeoutSeconds != null ? timeoutSeconds : 30;
		wait = new WebDriverWait(driver, timeoutSeconds);
		wait.until(condition);

	}

	public String getTitle() {
		return driver.getTitle();
	}

	public String getText(By element) {
		return driver.findElement(element).getText();
	}

}