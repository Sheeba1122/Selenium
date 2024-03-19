package assignments;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragNDrop_Screenshot {
	public class test {	
	public WebDriver driver;
			
			@BeforeMethod
			public void lauchWeb() {
				
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.get("https://jqueryui.com/");
				driver.manage().window().maximize();
			}
			
			
			@Test
			public void task() throws IOException {
				
				//Clicking on Draggable option
					driver.findElement(By.xpath("//*[@href='https://jqueryui.com/draggable/']")).click();
					
					
					//Scroll down		
					driver.switchTo().defaultContent();
					JavascriptExecutor je = (JavascriptExecutor) driver;
					je.executeScript("window.scrollBy(200, 200);");
					
					//Taking one Screenshot
					File f1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					Files.copy(f1, new File("F:\\AutomationTesting\\Result\\draggable1.png"));
					
					//Performing the drag action  
					Actions a = new Actions(driver);
					driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
					
					WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
					
					a.dragAndDropBy(drag, 300, 150).perform();
					
					//Taking another Screenshot
					File f2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					Files.copy(f2, new File("F:\\AutomationTesting\\Result\\draggable2.png"));
		}
			
			@AfterMethod
			public void close() {
				driver.quit();
			}
	}
}