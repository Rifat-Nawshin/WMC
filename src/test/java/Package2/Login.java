package Package2;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Package1.BaseClass;

public class Login extends BaseClass {
	
    @Test (priority=1)
	
	public void login() throws InterruptedException
	
	{
		
		driver.findElement(By.xpath(locators.getProperty("username"))).sendKeys(values.getProperty("userEmail"));
		driver.findElement(By.xpath(locators.getProperty("password"))).sendKeys(values.getProperty("password"));
		driver.findElement(By.xpath(locators.getProperty("submitButton"))).click();
		Thread.sleep(4000);
		//clcik on addressbook
		driver.findElement(By.xpath(locators.getProperty("addressbook"))).click();
	}
	
	
	
	

}
