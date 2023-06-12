package Package2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Package1.BaseClass;

public class VerifyData extends BaseClass{

	
	@Test (priority=4)
    public void View() throws InterruptedException {
    	
    	//Thread.sleep(2000);
    	//driver.get("https://d-shaon.brokerstar.org/contact");
    	Thread.sleep(6000);
    	driver.findElement(By.xpath(locators.getProperty("viewButton"))).click();
    	driver.findElement(By.xpath(locators.getProperty("ViewSearch"))).click();
    	Thread.sleep(4000);
    	
    	driver.findElement(By.xpath(locators.getProperty("Searchfield"))).sendKeys(values.getProperty("searchfiled"));
    	driver.findElement(By.xpath(locators.getProperty("searchicon"))).click();
    	Thread.sleep(8000);
    	//List <WebElement> filterdata  = driver.findElements(By.xpath("//table[@class=\"table table-border list-table table-condensed initialized-list initialised_sh\"]/tbody//td"));
    	List <WebElement> filterdata  = driver.findElements(By.xpath(locators.getProperty("filterdata")));
    	Thread.sleep(4000);
    	System.out.println(filterdata.size());
    	
    	//System.out.println("Rifat");
    	
    	boolean status = false;
    	
    	for(WebElement Fd:filterdata) 
    	
    	{ 
    		String value =Fd.getText();
    		System.out.println(value);
    		if(value.contains(values.getProperty("filterData"))) 
    		{
    			status = true;
    			break;
    			
    		}
    	}
    		
    Assert.assertTrue(status, "Result not found");
	
	
}

	
	
}
