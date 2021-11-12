package organizations;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestScenarios2 extends TestScenarios1
{
	@Test
	public void TestScenarios2()
	//public static void main(String[] args)
	 {
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
	    
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("salutationtype")).click();
		Select s=new Select(driver.findElement(By.name("salutationtype")));
		s.selectByValue("Mr.");
		driver.findElement(By.name("firstname")).sendKeys("Mohanraj");
		driver.findElement(By.name("lastname")).sendKeys("Sekar");
		driver.findElement(By.xpath("//img[@title='Select']")).click();
		String parentWindow = driver.getWindowHandle();
		Set<String> allWindow = driver.getWindowHandles();
		for(String orgWindow : allWindow)
		{
			driver.switchTo().window(orgWindow);
		}
		
		driver.findElement(By.xpath("//a[text()='Raj Technologies']")).click();
		driver.switchTo().window(parentWindow);
		driver.findElement(By.xpath("//input[@type='submit'][1]")).click();
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title,"Administrator - Contacts - vtiger CRM 5 - Commercial Open Source CRM");
		driver.close();
		
		
		
	 }		
}
