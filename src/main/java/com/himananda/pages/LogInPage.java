package com.himananda.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.himananda.base.BasePageObject;


public class LogInPage extends BasePageObject<LogInPage> {

	final Logger log = Logger.getLogger(BasePageObject.class);

	private static final String URL = "https://www.dice.com/dashboard/login";
	protected By emailField = By.xpath("//input[@id='email']");
	protected By pwdField = By.xpath("//input[@id='password']");
	protected By signInButton = By.xpath("//button[@type='submit']");
	protected By errorMessage = By.xpath("//*[@id=\"loginDataSubmit\"]/div[2]/div[1]/div/div/span[1]/strong");

	public LogInPage(WebDriver driver) {
		super(driver);
	}

	public void openLogInPage() {
		getPage(URL);
	}

	public void fillUpEmailAndPassword(String email, String pwd) {
		log.info("Fillingup email & password");
		type(email, emailField);
		type(pwd, pwdField);
	}

	public ProfilePage clickOnSignIn() {
		log.info("Clicking on sognIn button");
		click(signInButton);
		return new ProfilePage(driver);
	}
	public String getLogInErrorMessage() {
		waitforVisibilityOf(errorMessage, 10);
		return getText(errorMessage);
	}
}
