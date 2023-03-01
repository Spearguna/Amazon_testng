package com.google.Amazon_testng;



import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
//import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Amazon {

	public static WebDriver driver;
	@Test(priority = 1)
	private void browserlaunch() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\eclipse-workspace\\Amazon_testng\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.amazon.in");
	}
	
	@Test(priority = 2)
	private void singin() {
		Actions aa = new Actions(driver);
		WebElement findElement = driver.findElement(By.xpath("//span[text()='Account & Lists']"));
		aa.moveToElement(findElement).perform();
		
		driver.findElement(By.xpath("(//span[text()='Sign in'])[1]")).click();
	}
	
	@DataProvider(name="userdata")
	@Test
	private String[][] user_singin() {
		String[][] aa = new String[1][2];
		aa[0][0] = "8778920213";
		aa[0][1] = "tn01bc0444";
	
		return aa;
	}
	
	@Test(priority = 3, dataProvider = "userdata")
	private void userdata(String userid, String pass) {
		
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(userid);
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.name("password")).sendKeys(pass);
		driver.findElement(By.id("signInSubmit")).click();
	}
//	@Test
//	private void userdata() {
//		
//		driver.findElement(By.name("email")).sendKeys("8778920213");
//		driver.findElement(By.id("continue")).click();
//		driver.findElement(By.name("password")).sendKeys("tn01bc0444");
//		driver.findElement(By.id("signInSubmit")).click();
//	}
	
	@Test(priority = 4, parameters = "product")
	private void search_product(String product) throws AWTException {
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(product);
		Robot rr = new Robot();
		rr.keyPress(KeyEvent.VK_DOWN);
		rr.keyPress(KeyEvent.VK_DOWN);
		rr.keyRelease(KeyEvent.VK_DOWN);
		rr.keyPress(KeyEvent.VK_ENTER);
		rr.keyRelease(KeyEvent.VK_ENTER);
		
	}
//	@Test(groups = {"headphones"})
//
//	private void bluetooth1() {
//		driver.findElement(By.xpath("(//h2[@class=\"a-size-mini a-spacing-none a-color-base s-line-clamp-2\"])[1]")).click();
//	}
//	
//	@Test(groups = {"headphones"})
//
//	private void bluetooth2() {
//		driver.findElement(By.xpath("(//h2[@class=\"a-size-mini a-spacing-none a-color-base s-line-clamp-2\"])[2]")).click();
//	}
	
}
