package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Checkbox_Dropdown_Registration {
public WebDriver driver;
	
	@BeforeTest
	public void login() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/radio.html");
		driver.manage().window().maximize();
	}
	
	@Test
	public void launcWeb() {
		boolean option1 = driver.findElement(By.id("vfb-7-1")).isDisplayed();
		System.out.println(option1);
		
		driver.findElement(By.id("vfb-7-1")).click();

		boolean checkbox2 = driver.findElement(By.id("vfb-6-1")).isDisplayed();
		System.out.println(checkbox2);
		
		driver.findElement(By.id("vfb-6-1")).click();
		
		boolean checkbox3 = driver.findElement(By.id("vfb-6-2")).isDisplayed();
		System.out.println(checkbox3);
		
		driver.findElement(By.id("vfb-6-2")).click();
		
		driver.navigate().to("https://demo.guru99.com/test/newtours/register.php");
		
		driver.findElement(By.name("firstName")).sendKeys("Ibrahim");
		driver.findElement(By.name("lastName")).sendKeys("Shaikh");
		driver.findElement(By.name("phone")).sendKeys("1234567891");
		driver.findElement(By.id("userName")).sendKeys("test123@gmail.com");
		driver.findElement(By.name("address1")).sendKeys("Check");
		driver.findElement(By.name("city")).sendKeys("Jeddah");
		driver.findElement(By.name("state")).sendKeys("Jeddah");
		driver.findElement(By.name("postalCode")).sendKeys("123456");
		
		
		boolean cdropdown = driver.findElement(By.name("country")).isDisplayed();
		System.out.println(cdropdown);
		
		driver.findElement(By.name("country")).click();
		
		WebElement country = driver.findElement(By.name("country"));
		Select object = new Select(country);
		object.selectByVisibleText("KUWAIT");
		
		driver.findElement(By.id("email")).sendKeys("test123@gmail.com");
		driver.findElement(By.name("password")).sendKeys("test123!");
		driver.findElement(By.name("confirmPassword")).sendKeys("test123!");
		driver.findElement(By.name("submit")).click();
		
	}
	
	@AfterTest
	public void close() {
		driver.quit();
	}
}
