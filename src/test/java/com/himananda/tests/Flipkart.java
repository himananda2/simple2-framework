package com.himananda.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Flipkart {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Hreddy\\eclipse-workspace\\sample-framework\\src\\main\\resources\\chromedriver.exe");
		// log.info("About to Instantiate Driver");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");

		driver.findElement(By.xpath("/html/body/div[2]/div/div/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[1]/div/header/div[1]/div/div/div/div[1]/form/div/div[1]/div/input"))
				.sendKeys("Mobiles");
		driver.findElement(By.xpath("/html/body/div[1]/div/header/div[1]/div/div/div/div[1]/form/div/div[2]/button"))
				.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div[1]/div/div[2]/div/div[1]/div/div/div[5]/section/div[2]/div[1]/div[1]/input"))
				.sendKeys("Gionee");
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div[1]/div/div[2]/div/div[1]/div/div/div[5]/section/div[2]/div[1]/div[2]/div/div/label/div[1]"))
				.click();

		Thread.sleep(3000);
		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div[1]/div/div[2]/div/div[1]/div/div/div[4]/section/div[2]/div/div[4]/div/div/label/div[1]"))
				.click();

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, 250)");

		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@title='3 GB']/div/div/label/div[1]")).click();

		Thread.sleep(3000);
		String mobileName = driver.findElement(By.xpath(
				"/html/body/div[1]/div/div[1]/div/div[2]/div/div[2]/div/div[3]/div[1]/div/div[1]/div/a/div[2]/div[1]/div[1]"))
				.getText();
		String ramSize = driver.findElement(By.xpath(
				"/html/body/div[1]/div/div[1]/div/div[2]/div/div[2]/div/div[3]/div[1]/div/div[1]/div/a/div[2]/div[1]/div[2]"))
				.getText();
		System.out.println("Mobile Name : =" + mobileName);
		System.out.println("Ram Size : =" + ramSize);

		Assert.assertTrue(mobileName.contains("Gionee"));
		Assert.assertTrue(mobileName.contains("3 GB") || mobileName.contains("2 GB"));

	}
	// div[@title='3 GB']/div/div/label/div[1]
}
