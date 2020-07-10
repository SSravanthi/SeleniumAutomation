package Fusion;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;


public class FusionVMC {

	public static void main(String[] args) throws Exception {
		
	 try
	 {
	   System.setProperty("webdriver.gecko.driver","D:\\Drivers\\geckodriver.exe");
	  
	  
	   File pathBinary = new File("D:\\Mozilla Firefox\\firefox.exe");
	   FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);   
	   DesiredCapabilities desired = DesiredCapabilities.firefox();
	   FirefoxOptions options = new FirefoxOptions();
	   desired.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options.setBinary(firefoxBinary));
	   WebDriver driver = new FirefoxDriver(options);
	   driver.get("http://192.168.29.33:5200/login");
	   driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	   driver.findElement(By.xpath("//input[@id='inputEmail']")).sendKeys("test");
	   driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	   driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys("test");
	   driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	   driver.findElement(By.xpath("//button[text()='LOGIN']")).click();
	   
	   
	   
	   
	 }catch(Exception e)
	 {
		 System.out.println(e);
	 }
	
	}

}
