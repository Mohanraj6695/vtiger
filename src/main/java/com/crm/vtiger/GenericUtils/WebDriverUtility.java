package com.crm.vtiger.GenericUtils;


import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility
{
	//this method is used to maximize the window
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	//this method wait for 20 sec for page Loading
    public void waitUntilPageLoad(WebDriver driver)
    {
    	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    }
    
    //this method wait for the element to be visible
    public void waitForElementVisibility(WebDriver driver,WebElement element)
    {
    	WebDriverWait wait=new WebDriverWait(driver,20);
    	wait.until(ExpectedConditions.visibilityOf(element));
    }
    
    
    public void waitAndClick(WebElement element) throws InterruptedException
    {
    	int count=0;
    	while(count<40)
    	{
    		try 
    		{
    			element.click();
    			break;
    		}
    		catch(Throwable e)
    		{
    			Thread.sleep(1000);
    			count++;
    		}
    	}
    }
    //this method enables user to handle drop down using visible text
    public void SelectOption(WebElement element, String option)
    {
    	Select select=new Select(element);
    	select.selectByVisibleText(option);
    }
    
    //this method enables user to handle drop down using index
    public void SelectOption(WebElement element, int index)
    {
    	Select select=new Select(element);
    	select.selectByIndex(index);
    }
    
    //this method will perform mouse hover action
    public void mouseHover(WebDriver driver,WebElement element)
    {
    	Actions act=new Actions(driver);
    	act.moveToElement(element).perform();
    }
    //this method enables us to right click action
    public void rightClick(WebDriver driver,WebElement element)
    {
    	Actions act=new Actions(driver);
    	act.contextClick(element).perform();
    }
    
    //this method helps to switch from one window to another
    public void switchToWindow(WebDriver driver, String partialWinTitle)
    {
    	
    	Set<String> window = driver.getWindowHandles();
    	Iterator<String> it = window.iterator();
    	while(it.hasNext())
    	{
    		String winId = it.next();
    		String title = driver.switchTo().window(winId).getTitle();
    		if(title.contains(partialWinTitle))
    		{
    			break;
    		}
    	}
    }
    //this is used to accept alert
    public void acceptAlert(WebDriver driver)
    {
    	driver.switchTo().alert().accept();
    	
    	}
    //this is used to dismiss alert
    public void cancelAlert(WebDriver driver)
    {
    	driver.switchTo().alert().dismiss();
    }
    
    //this method used for scrolling action in a webpage
    public void scrollToWebElement(WebDriver driver, WebElement element)
    {
    	JavascriptExecutor js=(JavascriptExecutor)driver;
    	int y = element.getLocation().getY();
    	js.executeScript("window.scrollBy(0,"+y+")", element);
    }
    //this is used to switch between frames using index
    public void switchFrame(WebDriver driver, int index)
    {
    	driver.switchTo().frame(index);
    }
    //this is used to switch frame using element
    public void switchFrame(WebDriver driver,WebElement element)
    {
    	driver.switchTo().frame(element);
    }
    //this is used to switch frame using id or name
    public void switchFrame(WebDriver driver, String idOrName)
    {
    	driver.switchTo().frame(idOrName);
    }
    // this method is used to take ScreenShot and store it in file
    public String takeScreenshot(WebDriver driver,String screenshotName) throws Throwable
    {    
    	String screenshotPath = "./screenshot/"+screenshotName+JavaUtility.getCurrentDate()+".PNG";
    	TakesScreenshot ts=(TakesScreenshot)driver;
    	File src = ts.getScreenshotAs(OutputType.FILE);
    	File dest = new File(screenshotPath);
    	Files.copy(src, dest);
    	return screenshotPath;
    }
    //this method is used to do action of enter key
    public void pressEnterKey() throws Throwable 
    {
    	Robot rc=new Robot();
    	rc.keyPress(KeyEvent.VK_ENTER);
    	rc.keyRelease(KeyEvent.VK_ENTER);
    }
    
    
    
    
}
