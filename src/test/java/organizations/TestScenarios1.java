package organizations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.JavaUtility;


public class TestScenarios1 
{
// public static void main(String[] args)
 @Test
 public void testScenarios1()
	{
	 
	WebDriver driver=new ChromeDriver();
	driver.get("http://localhost:8888/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();
	
	driver.findElement(By.xpath("//a[text()='Organizations']")).click();
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	driver.findElement(By.name("accountname")).sendKeys("Raj Technologies"+JavaUtility.getRandomData());
	driver.findElement(By.name("website")).sendKeys("rajtechnologies.com");
	driver.findElement(By.id("phone")).sendKeys("7019705135");
	driver.findElement(By.name("button")).click();
	String title = driver.getTitle();
	System.out.println(title);
	
	Assert.assertEquals(title,"Administrator - Organizations - vtiger CRM 5 - Commercial Open Source CRM");
	driver.close();
}
}
