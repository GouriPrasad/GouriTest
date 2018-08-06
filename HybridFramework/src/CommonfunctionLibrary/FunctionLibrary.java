package CommonfunctionLibrary;

 



import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.PropertyFileUtil;

public class FunctionLibrary {
	
	public static WebDriver startBrowser(WebDriver driver) throws Exception, Exception
	{
		if(PropertyFileUtil.getValueForkey("Browser").equalsIgnoreCase("Firefox"))
       {
			ProfilesIni ffProfiles = new ProfilesIni();
			FirefoxProfile profile = ffProfiles.getProfile("customfirefox");
			  driver = new FirefoxDriver(profile);
	     
       }
		else
			if(PropertyFileUtil.getValueForkey("Browser").equalsIgnoreCase("Chrome"))
      {
	System.setProperty("webdriver.chrome.driver",  "CommonJarFiles/chromedriver.exe");
	 driver= new ChromeDriver();
       }
			else
				if(PropertyFileUtil.getValueForkey("Browser").equalsIgnoreCase("IE"))
				{
					System.setProperty("webdriver.ie.driver", "CommonJarFiles/IEDriverServer.exe");
					 driver= new InternetExplorerDriver();
				}
		return driver;
	}
	public static void openApplication(WebDriver driver) throws Exception, Exception
	{
		driver.manage().window().maximize();
		driver.get(PropertyFileUtil.getValueForkey("URL"));
		
	}
	public static void clickAction(WebDriver driver, String locatorType,String locatorValue)
	{
		if(locatorType.equalsIgnoreCase("id"))
		{
			driver.findElement(By.id(locatorValue)).click();
		}
		else if(locatorType.equalsIgnoreCase("name"))
		{
			driver.findElement(By.name(locatorValue)).click();
		}
		else if(locatorType.equalsIgnoreCase("xpath"))
		{
			driver.findElement(By.xpath(locatorValue)).click();
		}
		else if(locatorType.equalsIgnoreCase("linkText"))
		{
			driver.findElement(By.linkText(locatorValue)).click();}
	}
public static void typeAction(WebDriver driver,String locatorType,String locatorValue,String data)
{
	if(locatorType.equalsIgnoreCase("id"))
	{
		driver.findElement(By.id(locatorValue)).clear();
		driver.findElement(By.id(locatorValue)).sendKeys(data);
	}
	else if(locatorType.equalsIgnoreCase("name"))
	{
		driver.findElement(By.name(locatorValue)).clear();
		driver.findElement(By.name(locatorValue)).sendKeys(data);
	}
	else if(locatorType.equalsIgnoreCase("xpath"))
	{
		driver.findElement(By.xpath(locatorValue)).clear();
		driver.findElement(By.xpath(locatorValue)).sendKeys(data);
	}
}
public static void closeBrowser(WebDriver driver)
{
	driver.close();
}

public static void waitForElement(WebDriver driver,String locatorType,String locatorValue,String waittime)
{
	WebDriverWait wait=new WebDriverWait(driver,Integer.parseInt(waittime));
	if(locatorType.equalsIgnoreCase("id"))
	{
		 
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
					
	}
	else
		if(locatorType.equalsIgnoreCase("name"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorValue)));
			
		}
		else
			if(locatorType.equalsIgnoreCase("xpath"))
			{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
				
			}
}
	

public static void MouseAction(WebDriver driver,String locatorType,String locatorValue)
{
	Actions builder = new Actions(driver);
	if(locatorType.equalsIgnoreCase("xpath"))
	{
		WebElement element = driver.findElement(By.id(locatorValue));
		builder.doubleClick(element).perform();
		 
		 
	}
	
	 
	}
public static void alert(WebDriver driver)
{
 

 

	driver.switchTo().alert().dismiss();
	 
	}
 




}


