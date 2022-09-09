package com.amazon.stepdefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class MobilePurchase {
	public static WebDriver driver;

	@BeforeClass
	public static void launchbrowser() throws InterruptedException{
    	System.out.println("Task Start");
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\NEELA CHELLAMUTHU\\eclipse-workspace\\SeleniumSample\\drivers\\chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
    	driver.get("https://www.flipkart.com/");
    	driver.manage().window().maximize();
    }
	@Before				
	public void before()
	{
		System.out.println("Start Time");
		System.out.println(java.time.LocalTime.now());
	} 
	
    @Test
    public void Method1()
	{
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		}
		
    public void Method2() throws Exception 
	{
	System.out.println("SEARCH MOBILE");
	driver.findElement(By.name("q")).sendKeys("Xiomi Phones", Keys.ENTER);
	driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
	List<String> al = new ArrayList<String>();
	List<WebElement> products = driver.findElements(By.xpath("(//a//div//div//div[contains(text(),'Xiomi Phones')])"));
	for (WebElement x : products){
	String text = x.getText();
	al.add(text);
    
    
	}
	}
    public void Method3()
    {
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
 	driver.findElement(By.xpath("//span[text()='Filters']")).click();
 	System.out.println("SWITCHING TAB");
 	driver.findElement(By.xpath("(//a//div//div//div[contains(text(),'Xiomi Phones')])[2]")).click();
 	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);		
 	Set<String> windowHandling = driver.getWindowHandles();
 	List<String> listWindow = new ArrayList<String>(windowHandling);
 	driver.switchTo().window(listWindow.get(1));
    }
    
    @After
   	public void after()
   	{
   	 	System.out.println("End Time");
   	 	System.out.println(java.time.LocalTime.now());
   	}
   @AfterClass
   	public static void quitb()
   	{
   		System.out.println("BROWSER CLOSED");
   		driver.quit();
   		}
   }
    	
	
	
	
	
	
	
	
   