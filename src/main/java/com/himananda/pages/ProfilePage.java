package com.himananda.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.himananda.base.BasePageObject;

public class ProfilePage extends BasePageObject<ProfilePage> {

	final Logger log = Logger.getLogger(ProfilePage.class);

	private By editProfileButton = By.xpath("//button[@id='editProfile']");
	private By advanceSearchButton = By.xpath("//a[@id='advanced-search-link']");
	private By profileContentNameText = By.xpath("//h1[@class='profile-contact-name']");

	public ProfilePage(WebDriver driver) {
		super(driver);
	}

	public void waitForProfilePageToLoad() {

		log.info("Waiting for profile page to load");
		waitforVisibilityOf(editProfileButton);
		waitforVisibilityOf(advanceSearchButton, 10);
	}

	public boolean isCorrectProfileLoaded(String profileName) {

		if (getText(profileContentNameText).equals(profileName)) {
			return true;
		}
		return false;

	}

}
