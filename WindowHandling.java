package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandling {
public WebDriver driver;
	
	@BeforeTest
	public void login() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/popup.php");
		driver.manage().window().maximize();
	}
	
	@Test
	public void launcWeb() {
		driver.findElement(By.xpath("//*[text()='Click Here']")).click();
		//Handling Tab		
		for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
		
		driver.findElement(By.name("emailid")).sendKeys("test123@gmail.com");
		driver.findElement(By.name("btnLogin")).click();
		
	}
	
	@AfterTest
	public void close() {
		driver.quit();
	}
}