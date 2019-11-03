package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Key_Presses_on_Menu {
	
	@Test(description="click 4 buttons and assert button text for each click")
	public void scroll() {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.get("http://the-internet.herokuapp.com/");
	
	driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[31]/a")).click();
	driver.findElement(By.xpath("//*[@id=\"target\"]")).sendKeys(Keys.BACK_SPACE);
	String displayPressedKey1 = driver.findElement(By.xpath("//*[@id=\"result\"]")).getText();
	System.out.println(displayPressedKey1);
	
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//*[@id=\"target\"]")).sendKeys(Keys.TAB);
	String displayPressedKey2 = driver.findElement(By.xpath("//*[@id=\"result\"]")).getText();
	System.out.println(displayPressedKey2);
	
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//*[@id=\"target\"]")).sendKeys(Keys.DELETE);
	String displayPressedKey3 = driver.findElement(By.xpath("//*[@id=\"result\"]")).getText();
	System.out.println(displayPressedKey3);
	
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//*[@id=\"target\"]")).sendKeys(Keys.F10);
	String displayPressedKey4 = driver.findElement(By.xpath("//*[@id=\"result\"]")).getText();
	System.out.println(displayPressedKey4);
	driver.close();
	
}
}