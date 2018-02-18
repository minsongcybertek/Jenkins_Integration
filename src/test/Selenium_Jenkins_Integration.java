package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Selenium_Jenkins_Integration {
	WebDriver driver;
	
	@Test
	public void test01() throws InterruptedException{
		WebElement searchBox=driver.findElement(By.name("q"));
		//Thread.sleep(2000);
		searchBox.sendKeys("porsche" +Keys.ENTER);
		//Thread.sleep(2000);
		Assert.assertTrue(driver.getTitle().contains("porsche"));
		System.out.println("--------------------------------------------------------------------------------------------");
	}
	
	
	@BeforeMethod
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "C:/Java_WorkSpace/selenium_dependencies/drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.navigate().to("http://www.google.com");
		//driver.manage().window().maximize();
		System.out.println("-- System test initiated --");
		System.out.println("--------------------------------------------------------------------------------------------");

	}
	
	
	@AfterMethod
	public  void tearDown() throws InterruptedException{
		System.out.println("-- test completed and tear down completed --");
		System.out.println("--------------------------------------------------------------------------------------------");

		Thread.sleep(3000);
		driver.close();
	}

}
