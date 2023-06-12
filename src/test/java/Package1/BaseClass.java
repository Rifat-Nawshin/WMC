package Package1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Driver;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import javax.activation.DataSource;
import javax.management.StringValueExp;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.netty.handler.codec.http.HttpHeaders.Values;
import net.bytebuddy.matcher.LatentMatcher.ForSelfDeclaredMethod;

public class BaseClass {

	
	public static WebDriver driver;
	public ChromeOptions options = new ChromeOptions();
	//public String date = "17";
    public static Properties locators = new Properties();
	
	public static FileInputStream fis1;
	
	public static Properties values = new Properties();
	
	public static FileInputStream fis2; 
	
	
	@BeforeSuite
	
	public void geturl() throws IOException {
		
		
		if (driver==null) {
			
			
			fis1 = new FileInputStream("D:\\Eclipse\\JAVA PROJECTS\\WMC\\src\\test\\resources\\Resources\\locators.properties");
			locators.load(fis1);
			
			fis2 = new FileInputStream("D:\\Eclipse\\JAVA PROJECTS\\WMC\\src\\test\\resources\\Resources\\values.properties");
			values.load(fis2);
			
			}
		
		
		
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://d-shaon.brokerstar.org/login");
		
		
		
		
	}
	
	@AfterSuite
	
	public void close() {
		
		driver.quit();
		
	}
	
	
	/*@Test (priority=1)
	
	public void Login() throws InterruptedException
	
	{
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("pw4admin");
		driver.findElement(By.xpath("//input[@id='_submit']")).click();
		Thread.sleep(4000);
		//clcik on addressbook
		driver.findElement(By.xpath("//span[@class='nav-link-image']//i[@class='wmc-icon wmc-address-book']")).click();
	}*/
	
	
	/*@Test (priority=2)
	
	public void Newcontact() throws InterruptedException {
		
		//clcik on newcontcat button
		Thread.sleep(7000);
		
	    driver.findElement(By.xpath("//div[@class='page-title-item  sparks-info subheader-block d-lg-flex align-items-center']//a[@class='btn btn-default ajaxify-initialised']")).click();
	    
	    
	    Thread.sleep(6000);
	    
	    //save the form
	    
	    
	    
	    
	}*/
	
	/*@Test (priority=3)
	public void AddressBookInfo() throws InterruptedException {
		
		
		driver.get("https://d-shaon.brokerstar.org/contact/create");
		
		
		//contac no;
		Thread.sleep(6000);
		//driver.findElement(By.xpath("//i[@class=\"fa fa-save pull-left\"]")).click();
		driver.navigate().refresh();
		//JavascriptExecutor js =(JavascriptExecutor) driver;
		driver.findElement(By.xpath("//input[@id=\"broker_star_contact_form_nr\"]")).clear();
		driver.findElement(By.xpath("//input[@id=\"broker_star_contact_form_nr\"]")).sendKeys("345556");
		//js.executeScript("window.scrollBy(0,400)");
		
		Thread.sleep(5000);
		//type of contact
	
		driver.findElement(By.xpath("//*[@id=\"1c869eee8aab8237bc0bd9c66cf39494\"]/div[2]/div[2]/div/span/span[1]/span/span[2]")).click();
		
		
		List <WebElement> EC  = driver.findElements(By.xpath("//*[@id=\"select2-broker_star_contact_form_contactType-results\"]"));
		
		for(WebElement Company:EC ) {
			
			if(Company.getText().contains("Person")) {
				
				Company.click();
				break;
			}
			
		}
		
		//Salutations
		driver.findElement(By.xpath("//span[@id=\"select2-broker_star_contact_form_salutation-container\"]")).click();
		driver.findElement(By.xpath("//span[@class=\"select2-search select2-search--dropdown\"]//input[@class=\"select2-search__field\"]")).sendKeys("S");
		List <WebElement>  Salutations = driver.findElements(By.xpath("//*[@id=\"select2-broker_star_contact_form_salutation-results\"]"));
		
		for(WebElement  S : Salutations) {
			if(S.getText().contains("Signor")) {
				
				S.click();
				break;
			}
			
		}
		
		//last name
		//JavascriptExecutor js =(JavascriptExecutor) driver;
		WebElement  ln  =  driver.findElement(By.xpath("//input[@name=\"broker_star_contact_form[name1]\"]"));
		//js.executeScript("window.scrollBy(0,200)");
		
		ln.sendKeys("Test");
		//firstname
		//JavascriptExecutor js =(JavascriptExecutor) driver;
		WebElement  fn =  driver.findElement(By.xpath("//input[@name=\"broker_star_contact_form[name2]\"]"));
		//js.executeScript("arguments[0].scrollIntoView(true)", fn);
		fn.sendKeys("Naw");
		
		//birthday
		
		//JavascriptExecutor js1 =(JavascriptExecutor) driver;
		WebElement  Bd   =   driver.findElement(By.xpath("//input[@id=\"broker_star_contact_form_birthday\"]"));
		//js1.executeScript("arguments[0].scrollIntoView(true)", Bd);
		Bd.click();
	
		
		while(true) {
			String MY  =  driver.findElement(By.xpath("/html/body/div[6]/div[1]/table/thead/tr[2]/th[2]")).getText();
			if(MY.equals("June 2017")) {
				break;
			}
			else {
				
				driver.findElement(By.xpath("/html/body/div[6]/div[1]/table/thead/tr[2]/th[1]/i")).click();
				
				
			}
		}
		
		Thread.sleep(2000);
		List <WebElement> d  =  driver.findElements(By.xpath("/html/body/div[6]/div[1]/table/tbody/tr/td"));
		
	
	    for( WebElement day : d ) {
	    	
	    	if(day.getText().equals(date))   {
	    		
	    		day.click();
	    		break;
	    	}
	    	
	    }
		
		//category
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//*[@id=\"df149d973fefbe7f9ba02a4e416a5e97\"]/div[2]/div[1]/div/span/span[1]/span/ul/li/input")).click();
	    List <WebElement>  Catagories  =   driver.findElements(By.xpath("//ul[@class=\"select2-results__options\"]//li"));
	    
	    
	    
	    for (WebElement catagory : Catagories) {
	    	
	    	if(catagory.getText().contains("Others")) {
	    		catagory.click();
	    		break;
	    		
	    	}
	    	
	    }
	    
	    //driver.findElement(By.xpath("//span[@id=\"select2-broker_star_contact_form_language-container\"]")).click();
		//List <WebElement>  Lang = driver.findElements(By.xpath("//ul[@class=\"select2-results__options\"]//li"));
		
		//for(  WebElement l : Lang  ) {
			
			//if(l.getText().equals("English")) {
				
				//l.click();
				//break;
			//}
			
		//}
	    
	  
	    
	    //js.executeScript("window.scrollBy(0,-400)");
	    
	    //js2.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	    
	    WebElement Savebutton = driver.findElement(By.xpath("//i[@class=\"fa fa-save pull-left\"]"));
	    
	    //js.executeScript("arguments[0].scrollIntoView()", Savebutton);
	    Savebutton.click();
	    Thread.sleep(4000);
	

	}*/


       /* @Test (priority=4)
        public void View() throws InterruptedException {
        	
        	//Thread.sleep(2000);
        	//driver.get("https://d-shaon.brokerstar.org/contact");
        	Thread.sleep(6000);
        	driver.findElement(By.xpath("//*[@id=\"contact\"]/div[1]/div/div[2]/a")).click();
        	driver.findElement(By.xpath("//input[@id=\"broker_star_contact_filter_standard_searchString\"]")).click();
        	Thread.sleep(4000);
        	
        	driver.findElement(By.xpath("//input[@class=\"form-control field_searchString\"]")).sendKeys("Test");
        	driver.findElement(By.xpath("//*[@id=\"filters-widget\"]/div[2]/div[2]/form/div[1]/div/div/div[2]/a/i")).click();
        	Thread.sleep(8000);
        	List <WebElement> filterdata  = driver.findElements(By.xpath("//table[@class=\"table table-border list-table table-condensed initialized-list initialised_sh\"]/tbody//td"));
        	Thread.sleep(4000);
        	//System.out.println(filterdata.size());
        	
        	//System.out.println("Rifat");
        	
        	boolean status = false;
        	
        	for(WebElement Fd:filterdata) 
        	
        	{ 
        		String value =Fd.getText();
        		//System.out.println(value);
        		if(value.contains("Bd")) 
        		{
        			status = true;
        			break;
        			
        		}
        	}
        		
        Assert.assertTrue(status, "Result not found");
           
       // driver.quit();
        		
        	
        }*/

    
		
}
		

  





