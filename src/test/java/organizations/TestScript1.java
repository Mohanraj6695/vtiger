package organizations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

import com.crm.vtiger.GenericUtils.FileUtility;
import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class TestScript1
{
	public static void main(String[] args) throws Throwable
	{
		FileUtility fu=new FileUtility();
		WebDriverUtility wu=new WebDriverUtility();
		String BROWSER = fu.getPropertyKeyValue("browser");
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if (BROWSER.equalsIgnoreCase("IE"))
		{
			driver=new InternetExplorerDriver();
		}
		
		
		//WebDriver driver=new ChromeDriver();
	    wu.maximizeWindow(driver);
		wu.waitUntilPageLoad(driver);
		String URL = fu.getPropertyKeyValue("url");
		driver.get(URL);
		String USERNAME = fu.getPropertyKeyValue("username");
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		String PASSWORD = fu.getPropertyKeyValue("password");
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		String organizationName = fu.getPropertyKeyValue("OrganizationName");
		driver.findElement(By.name("accountname")).sendKeys(organizationName);
		String WEBSITE = fu.getPropertyKeyValue("Website");
		driver.findElement(By.name("website")).sendKeys(WEBSITE);
		String PHONE = fu.getPropertyKeyValue("Phone");
		driver.findElement(By.id("phone")).sendKeys(PHONE);
		driver.findElement(By.name("button")).click();
		String TITLE1 = fu.getPropertyKeyValue("title1");
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title,TITLE1);
		driver.close();
	}
}
 