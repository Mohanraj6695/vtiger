package com.crm.vtiger.GenericUtils;

import java.util.concurrent.TimeUnit;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.crm.vtiger.pomclass.HomePage;
import com.crm.vtiger.pomclass.LoginPage;

public class BaseClass
{
    public WebDriver driver;
    //public static WebDriver staticDriver;
    public ExcelUtility eUtil=new ExcelUtility();
    public FileUtility fUtil=new FileUtility();
    public WebDriverUtility wUtil=new WebDriverUtility();
    public DataBaseUtility dblib=new DataBaseUtility();
    public HomePage homePage;
    @BeforeSuite(groups= {"smokeTest","regressionTest"})
    public void configBS() throws Throwable
    {
    	//connect to db
    	dblib.connectToDB();
    }
    @BeforeTest(groups= {"smokeTest","regressionTest"})
    public void configBT()
    {
    	//launch browser in parallel mode
    }
    //@Parameters("browser")
    @BeforeClass(groups = {"smokeTest","regressionTest"})
    public void configBc() throws Throwable
    {
    	String browserName=fUtil.getPropertyKeyValue("browser");
    	if(browserName.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if (browserName.equalsIgnoreCase("IE"))
		{
			driver=new InternetExplorerDriver();
		}
    	 //staticDriver=driver;
    	 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    	 driver.manage().window().maximize();
    }
    
    @BeforeMethod(groups= {"smokeTest","regressionTest"})
    public void configBM() throws Throwable
    {
    	String url = fUtil.getPropertyKeyValue("url");
    	String username = fUtil.getPropertyKeyValue("username");
    	String password = fUtil.getPropertyKeyValue("password");
    	driver.get(url);
    	/*//login to the application
    	LoginPage loginpage=new LoginPage(driver);
    	homePage=loginpage.login(username, password);
    }
    
    @AfterMethod(groups = {"smoketest","regressionTest"})
     public void configAM()   
    {
    	HomePage homepage=new HomePage(driver);
    	homePage.signOut();  
    }
    
    @AfterClass(groups = {"smoketest","regressionTest"})
    public void configAC()
    {
    	driver.quit();
    }
    {
    	
    */	
    }
    
   

    
}
