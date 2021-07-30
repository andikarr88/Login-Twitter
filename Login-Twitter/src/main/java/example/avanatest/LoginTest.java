package example.avanatest;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;		

public class LoginTest {
	private WebDriver driver;
	  @Test(priority=1)
	  public void login() throws Exception {
		  //open twitter web
		  driver.get("https://twitter.com/");  
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		  //tap login
		  WebElement a=driver.findElement(By.linkText("Log in"));
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  a.click();
		  Thread.sleep(1000);
		  
		  //input email
		  WebElement email = driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div[2]/form/div/div[1]/label/div/div[2]/div/input"));
		  email.sendKeys("bigorrella@lephamtuki.com");
		  //input password
		  WebElement password = driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div[2]/form/div/div[2]/label/div/div[2]/div/input"));
		  password.sendKeys("test12345678");
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		  //tap button login
		  WebElement b=driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div[2]/form/div/div[3]/div/div/span/span"));
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  b.click();
		  Thread.sleep(1000);
			/*String title = driver.getTitle();				 
			Assert.assertTrue(title.contains("Demo Guru99 Page"));*/ 		
	  }
	  
	  @Test(priority=2)
	  public void postingimage() throws Exception {
		  //Input Text
		  WebElement input = driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div[1]/div/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div[1]/div/div/div/div/div/div/div/div/div/label/div[1]/div/div/div/div/div[2]/div/div/div/div"));
		  input.sendKeys("test12345678");	
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		  //tap button image
		  WebElement c=driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div[1]/div/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div[3]/div/div/div[1]/div[1]"));
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  c.click();
		  //search data gambar
		  String arr[] = {"\"D:\\QUALITY ASSURANCE\\Project\\AUTOMATION\\eclipse-workspace\\Login-Twitter\\download.png\""};
		  StringSelection photo = new StringSelection(arr[0]); //Putting the path of the image to upload
		  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(photo, null);
		  
		  //Pasting the contents of clipboard in the field "File name" of the Window Pop-up
		  Thread.sleep(5000); //Some sleep time to detect the window popup
		  Robot robot = new Robot();
		  robot.keyPress(KeyEvent.VK_CONTROL);
		  robot.keyPress(KeyEvent.VK_V);
		  robot.keyRelease(KeyEvent.VK_V);
		  robot.keyRelease(KeyEvent.VK_CONTROL);

		  //To Click on the "Open" button to upload files
		  robot.keyPress(KeyEvent.VK_ENTER);
		  robot.keyRelease(KeyEvent.VK_ENTER);
		  
		  //tap button Tweet
		  WebElement d=driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div[1]/div/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div[3]/div/div/div[2]/div[3]/div/span/span"));
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  Thread.sleep(5000);
		  d.click();
		  
	  }
	  @BeforeTest
	  public void beforeTest() {
		  System.setProperty("webdriver.chrome.driver", "D:\\QUALITY ASSURANCE\\Project\\AUTOMATION\\eclipse-workspace\\Login-Twitter\\chromedriver.exe");
		  driver = new ChromeDriver(); 
	  }
	
	  @AfterTest
	  public void afterTest() {
		  
	  }

}
