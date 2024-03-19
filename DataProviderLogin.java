package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderLogin {
public WebDriver driver;
	
	@BeforeMethod
	public void lauchWeb() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/login.html");
		driver.manage().window().maximize();
	}
	
	@DataProvider (name = "Data")
	public Object[][] data() {
		Object[][] obj =new Object[3][2];
		obj[0][0]= "testdata@gmail.com"; obj[0][1]= "testdata@1";
		obj[1][0]= "testdata123@gmail.com"; obj[1][1]= "testdata@2";
		obj[2][0]= "testdata456@gmail.com"; obj[2][1]= "testdata@3";
		return obj;
	}
	@Test(dataProvider= "Data")
	public void login(String uid, String pwd) {
		driver.findElement(By.id("email")).sendKeys(uid);
		driver.findElement(By.id("passwd")).sendKeys(pwd);
		driver.findElement(By.id("SubmitLogin")).click();
	}
	
	@AfterMethod
	public void close() {
		driver.quit();
	}
}