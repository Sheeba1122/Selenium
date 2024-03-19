package assignments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CompanyList_Login {

public WebDriver driver;
	
	@BeforeTest
	public void login() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/web-table-element.php");
		driver.manage().window().maximize(); 
		}
	
	@Test
	public void companylists() {
		List<WebElement> company= driver.findElements(By.xpath("//*[@href='http://demo.guru99.com/']"));
		System.out.println("Company count is: " + company.size());
		for (int i=0;i<company.size(); i++) {
			System.out.println(company.get(i).getText());
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Diverted to Login page
		driver.navigate().to("https://demo.guru99.com/test/login.html");
		driver.findElement(By.id("email")).sendKeys("abc@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("abc@123");
		driver.findElement(By.id("SubmitLogin")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterTest
	public void close() {
		driver.quit();
	}
}
