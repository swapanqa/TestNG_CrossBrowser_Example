package com.testNGMultiBrowser.com.testNGMultiBrowserTest;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGMultiBrowserDemo {
	
	WebDriver driver = null;
	
	@BeforeTest
	@Parameters("browserName")
	public void setUp(String browserName) {
		
		
		System.out.println("Browser name is " + browserName);
		
		System.out.println("Browser name is " +browserName + Thread.currentThread().getId());
		
		if(browserName.equalsIgnoreCase("chrome")) {
			 System.setProperty("webdriver.chrome.driver", "/Users/mamun79/Downloads/chromedriver");
			
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			 System.setProperty("webdriver.gecko.driver", "/Users/mamun79/Downloads/geckodriver");
				
				driver = new FirefoxDriver();
			
		}
		
		
     
		
	}
	@Test
	public void  test1() {
		driver.get("https://www.google.com");
		String title = driver.getTitle();
		System.out.println("Google title is " + title);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
		System.out.println("Test completed successfully");
	}

}
