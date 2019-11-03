package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Form_Authentication{
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);}
	
	@Test(description="Login with correct username and wrong password and assert login validation")
	public void scenario1() {
		driver.findElement(By.cssSelector("div.row:nth-child(2) div.large-12.columns:nth-child(2) ul:nth-child(4) li:nth-child(21) > a:nth-child(1)")).click();
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/form[1]/button[1]/i[1]")).click();
}
	@Test(description="Login with correct incorrect username and password and assert loigin validation")
	public void scenario2() {
		driver.findElement(By.cssSelector("div.row:nth-child(2) div.large-12.columns:nth-child(2) ul:nth-child(4) li:nth-child(21) > a:nth-child(1)")).click();
		driver.findElement(By.id("username")).sendKeys("tomshith");
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/form[1]/button[1]/i[1]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String i = driver.findElement(By.cssSelector(".flash.error")).getText();
		System.out.println("You can't login because" + i);
	}
	
	@Test(description="Login with correct username and password and then logout")
	public void scenario3() {
		driver.findElement(By.cssSelector("div.row:nth-child(2) div.large-12.columns:nth-child(2) ul:nth-child(4) li:nth-child(21) > a:nth-child(1)")).click();
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/form[1]/button[1]/i[1]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/a/i")).click();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}