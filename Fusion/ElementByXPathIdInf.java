package Fusion;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public interface ElementByXPathIdInf {

	
	public Logger Log = Logger.getLogger(Logger.class.getName());
	static WebElement element = null;

	static WebElement getByXPath(WebDriver driver, String xpathValue) {
		try{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathValue)));

		List<WebElement> elements = driver.findElements(By.xpath(xpathValue));

		if (elements.size() == 1)
			return driver.findElement(By.xpath(xpathValue));

		for (WebElement ele : elements) {
			try {
				if (ele.isDisplayed())
					return ele;
			} catch (StaleElementReferenceException e) {
				System.out.println("Attempting to recover from StaleElementReferenceException ...");
				getByXPath(driver, xpathValue);
			}

		}
		}catch (Exception e) {
			e.printStackTrace();
			Log.info("XPATH is not Found");
		} 

		return element;
	}

	static WebElement getByID(WebDriver driver, String idValue) {
		try{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(idValue)));
		}catch (Exception e) {
			e.printStackTrace();
			Log.info("ID is not Found");
		} 

		return driver.findElement(By.id(idValue));

	}

}



