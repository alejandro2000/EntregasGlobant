package com.automation.training;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyDriver {
	
	private WebDriver driver;
	
	public MyDriver(String browser) {
		if ("firefox".equals(browser)) {
			driver = new FirefoxDriver();
		} else if ("chrome".equals(browser)) {
			System.setProperty("webdriver.chrome.driver", "chromedriver");
			driver = new ChromeDriver();
		}
	}
	
	public WebDriver getDriver() {
		return this.driver;
	}
}
