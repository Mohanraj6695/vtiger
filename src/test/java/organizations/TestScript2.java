package organizations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;

import com.crm.vtiger.GenericUtils.FileUtility;
import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class TestScript2
{
	public static void main(String[] args) throws Throwable
	{
	FileUtility fu=new FileUtility();
	WebDriverUtility wu=new WebDriverUtility();
	WebDriver driver=new ChromeDriver();
    wu.maximizeWindow(driver);
	wu.waitUntilPageLoad(driver);
	String URL = fu.getPropertyKeyValue("url");
	driver.get(URL);
	String USERNAME = fu.getPropertyKeyValue("username");
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	String PASSWORD = fu.getPropertyKeyValue("password");
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	driver.findElement(By.xpath("//a[text()='Contacts']")).click();
	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	
	driver.findElement(By.name("salutationtype")).click();
	WebElement drpdwn = driver.findElement(By.name("salutationtype"));
	wu.SelectOption(drpdwn,"Mr.");
	String FIRSTNAME = fu.getPropertyKeyValue("FirstName");
	driver.findElement(By.name("firstname")).sendKeys(FIRSTNAME);
	String LASTNAME = fu.getPropertyKeyValue("LastName");
	driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
	driver.findElement(By.xpath("//img[@title='Select']")).click();
	wu.switchToWindow(driver, "Popup&popuptype");
	driver.findElement(By.xpath("//a[text()='Royal Technologies']")).click();
	wu.switchToWindow(driver, "Contacts&action");
	driver.findElement(By.xpath("//input[@type='submit'][1]")).click();
	String title = driver.getTitle();
	System.out.println(title);
	String TITLE2 = fu.getPropertyKeyValue("title2");
	Assert.assertEquals(title,TITLE2);
	driver.close();
}
}