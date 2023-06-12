package Package2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Package1.BaseClass;

public class contactForm extends BaseClass {
	
	
@Test (priority=2)
	
	public void Newcontact() throws InterruptedException {
		
		//clcik on newcontcat button
		Thread.sleep(7000);
		
	    //driver.findElement(By.xpath("//div[@class='page-title-item  sparks-info subheader-block d-lg-flex align-items-center']//a[@class='btn btn-default ajaxify-initialised']")).click();
		driver.findElement(By.xpath(locators.getProperty("newcontactButton"))).click();
	    
	    
	    Thread.sleep(6000);
	    
	    //save the form
	    
	    
	    
	    
	}
	
@Test (priority=3)
public void AddressBookInfo() throws InterruptedException {
	
	
	//driver.get("https://d-shaon.brokerstar.org/contact/create");
	
	
	//contac no;
	//Thread.sleep(6000);
	//driver.findElement(By.xpath("//i[@class=\"fa fa-save pull-left\"]")).click();
	driver.navigate().refresh();
	//JavascriptExecutor js =(JavascriptExecutor) driver;
	driver.findElement(By.xpath(locators.getProperty("contactNo"))).clear();
	driver.findElement(By.xpath(locators.getProperty("contactNo"))).sendKeys(values.getProperty("ContactNo"));
	//js.executeScript("window.scrollBy(0,400)");
	
	Thread.sleep(5000);
	//type of contact

	driver.findElement(By.xpath(locators.getProperty("typeofContact"))).click();
	
	
	List <WebElement> EC  = driver.findElements(By.xpath(locators.getProperty("typeofcontactList")));
	
	for(WebElement Company:EC ) {
		
		if(Company.getText().contains(values.getProperty("contactListValue"))) {
			
			Company.click();
			break;
		}
		
	}
	
	//Salutations
	driver.findElement(By.xpath(locators.getProperty("salutation"))).click();
	driver.findElement(By.xpath(locators.getProperty("salutationSearchBox"))).sendKeys(values.getProperty("searchvalue"));
	List <WebElement>  Salutations = driver.findElements(By.xpath(locators.getProperty("salutationList")));
	
	for(WebElement  S : Salutations) {
		if(S.getText().contains(values.getProperty("searchResult"))) {
			
			S.click();
			break;
		}
		
	}
	
	//last name
	//JavascriptExecutor js =(JavascriptExecutor) driver;
	WebElement  ln  =  driver.findElement(By.xpath(locators.getProperty("lastName")));
	//js.executeScript("window.scrollBy(0,200)");
	
	ln.sendKeys(values.getProperty("Lastname"));
	//firstname
	//JavascriptExecutor js =(JavascriptExecutor) driver;
	WebElement  fn =  driver.findElement(By.xpath(locators.getProperty("lastname")));
	//js.executeScript("arguments[0].scrollIntoView(true)", fn);
	fn.sendKeys(values.getProperty("Firstname"));
	
	//birthday
	
	//JavascriptExecutor js1 =(JavascriptExecutor) driver;
	WebElement  Bd   =   driver.findElement(By.xpath(locators.getProperty("birthday")));
	//js1.executeScript("arguments[0].scrollIntoView(true)", Bd);
	Bd.click();

	
	while(true) {
		String MY  =  driver.findElement(By.xpath(locators.getProperty("birthdayList"))).getText();
		if(MY.equals(values.getProperty("BirthMonth"))) {
			break;
		}
		else {
			
			driver.findElement(By.xpath(locators.getProperty("Datepickerarrow"))).click();
			
			
		}
	}
	
	Thread.sleep(2000);
	List <WebElement> d  =  driver.findElements(By.xpath(locators.getProperty("DateList")));
	

    for( WebElement day : d ) {
    	
    	if(day.getText().equals(values.getProperty("Date")))   {
    		
    		day.click();
    		break;
    	}
    	
    }
	
	//category
    Thread.sleep(3000);
    driver.findElement(By.xpath(locators.getProperty("Categories"))).click();
    List <WebElement>  Catagories  =   driver.findElements(By.xpath(locators.getProperty("categoryList")));
    
    
    
    for (WebElement catagory : Catagories) {
    	
    	if(catagory.getText().contains(values.getProperty("category"))) {
    		catagory.click();
    		break;
    		
    	}
    	
    }
    
   
    
    //js.executeScript("window.scrollBy(0,-400)");
    
    //js2.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    
    WebElement Savebutton = driver.findElement(By.xpath(locators.getProperty("Savebutton")));
    
    //js.executeScript("arguments[0].scrollIntoView()", Savebutton);
    Savebutton.click();
    Thread.sleep(4000);


}


}
