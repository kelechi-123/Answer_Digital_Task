package testCases;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Infinite_Scrolling {
	
	@Test(description="Scroll twice to page button and back to top and assert")
	public void scroll() {
	WebDriverManager.chromedriver().setup();
	System.out.println("Test is now starting");
	WebDriver driver = new ChromeDriver();
	driver.get("http://the-internet.herokuapp.com/");
	driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[26]/a")).click();
	
	try { 
			//displays the heihgt of the loaded page
	    	((JavascriptExecutor)driver).executeScript("return document.body.scrollHeight");
	    	Thread.sleep(2000);
	    	
	    	//Scroll once
	        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
	        Thread.sleep(2000);
	        
	        //Scrolls the 2nd time
	        ((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
	        Thread.sleep(2000);
	        
	        //Scrolls back up
	        ((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight, 0)");
	        
	        // asserts infinite scrolls
	        System.out.println("infinite scroll");
	        
	 }catch (InterruptedException e) {
		 	e.printStackTrace();
	}
			driver.close();
			System.out.println("Test is now completed");
	}
	}
