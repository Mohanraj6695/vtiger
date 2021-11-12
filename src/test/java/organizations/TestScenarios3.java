package organizations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestScenarios3
{
	@Test
	public void testScenarios3()
	//public static void main(String[] args) throws InterruptedException
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
		driver.findElement(By.name("accountname")).sendKeys("SVVM Technologies");
		driver.findElement(By.name("website")).sendKeys("SVVM Technologies");
		driver.findElement(By.id("phone")).sendKeys("7019705135");
		driver.findElement(By.name("industry")).click();
		Select s=new Select(driver.findElement(By.name("industry")));
		s.selectByValue("Government");
		driver.findElement(By.name("rating")).click();
		Select s1=new Select(driver.findElement(By.name("rating")));
		s1.selectByValue("Active");
		driver.findElement(By.xpath("//input[@name='assigntype'][2]")).click();
		driver.findElement(By.xpath("//select[@name='assigned_group_id']")).click();
		Select s2=new Select(driver.findElement(By.xpath("//select[@name='assigned_group_id']")));
		s2.selectByValue("4");
		driver.findElement(By.name("button")).click();
		String title = driver.getTitle();
		System.out.println(title);
		
		Assert.assertEquals(title,"Administrator - Organizations - vtiger CRM 5 - Commercial Open Source CRM");
		driver.close();
	 }		
}
