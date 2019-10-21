package tests;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestUserInterface {
	String imc="";
	WebElement weight,height,submit;
	WebDriver driver;
		@Before
		public void setUp() {
			//initialize webdriver for chrome
			System.setProperty("webdriver.chrome.driver","C:\\Users\\hostname\\Documents\\chromedriver.exe");
			driver = new ChromeDriver();
			String baseUrl = "http://localhost:8080/Project-imc/";
			driver.get(baseUrl);
			weight= driver.findElement(By.name("weight"));
			height=driver.findElement(By.name("height"));
			submit= driver.findElement(By.name("calculer"));
			
		}
		
		@Test
		//test empty field, we give only weight
		public void testFieldEmpty() {
			weight.sendKeys("0");
			submit.submit();
			imc=driver.findElement(By.name("imc")).getAttribute("value");
			assertEquals("bad value", imc);
		}
		
		@Test
		//test zero values
		public void testBadZeroValue() {
			weight.sendKeys("0");
			height.sendKeys("0");
			submit.submit();
			imc=driver.findElement(By.name("imc")).getAttribute("value");
			assertEquals("bad value", imc);
		}
		
		
		
		@Test
		//test negative values of weight and height
		public void testNegativeValues() {
			weight.sendKeys("-1");
			height.sendKeys("-2");
			submit.submit();
			imc=driver.findElement(By.name("imc")).getAttribute("value");
			assertEquals("bad value", imc);
		}
		
		@Test
		//test bad values of weight and height
		public void testBadValues() {
			weight.sendKeys("1");
			height.sendKeys("0.1");
			submit.submit();
			imc=driver.findElement(By.name("imc")).getAttribute("value");
			assertEquals("bad value", imc);
		}
		@Test
		//test strings instead of numbers for weight and height
		public void testStringsNumbers() {
			weight.sendKeys("hello");
			height.sendKeys("hi");
			submit.submit();
			imc=driver.findElement(By.name("imc")).getAttribute("value");
			assertEquals("bad value", imc);
		}
		@Test
		//test comma instead of a point
		public void testCommaPoint() {
			weight.sendKeys("55,00");
			height.sendKeys("1,72");
			submit.submit();
			imc=driver.findElement(By.name("imc")).getAttribute("value");
			assertEquals("18.59", imc);
		}
		@Test
		//test correct values of weight and height
		public void testCorrectValue() {
			weight.sendKeys("55");
			height.sendKeys("1.72");
			submit.submit();
			imc=driver.findElement(By.name("imc")).getAttribute("value");
			assertEquals("18.59", imc);
		} 
		
		
		@After
		public void closeBorwser() {
			driver.close();
		}
	

}
