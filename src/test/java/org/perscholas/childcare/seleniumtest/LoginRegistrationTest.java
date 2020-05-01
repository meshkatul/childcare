package org.perscholas.childcare.seleniumtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginRegistrationTest {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\workspace\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://localhost:8080/");
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("username")).sendKeys("admin@hma.com");
		driver.findElement(By.id("password")).sendKeys("admin");
		driver.findElement(By.cssSelector(".btn.btn-primary.mt-3")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.cssSelector("input[id='firstname']")).sendKeys("Jane");
		driver.findElement(By.cssSelector("input[id='lastname']")).sendKeys("Doe");
		driver.findElement(By.cssSelector("input[id='email']")).sendKeys("jane@gmail.com");
		driver.findElement(By.cssSelector("input[id='password']")).sendKeys("Password123");
		driver.findElement(By.cssSelector("input[id='confirm_password']")).sendKeys("Password123");
		driver.findElement(By.cssSelector(".btn.btn-primary.mt-3")).click();
		driver.findElement(By.cssSelector("input[id='firstname']")).sendKeys("Jill");
		driver.findElement(By.cssSelector("input[id='lastname']")).sendKeys("Doe");
		driver.findElement(By.cssSelector("input[id='class_id']")).sendKeys("200");
		driver.findElement(By.cssSelector(".btn.btn-primary.mt-3")).click();
		
	}
}
