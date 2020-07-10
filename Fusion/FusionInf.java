package Fusion;

import java.util.List;
/**
 *  
 * List of methods
 * 
 */

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Fusion.ExcelDataPojo;

public interface FusionInf {

	void process(WebDriver driver, List<String> cellValue); 

	WebElement getElement(String pathType, String pathValue);

	String getDriverFullPath(String browser);

	String performAction(ExcelDataPojo excelData);

	void waitTillElementLoad(ExcelDataPojo excelData);

	String verify(ExcelDataPojo excelData, String text);
		
	String position(ExcelDataPojo excelData, Point post);
	
	String getimage(ExcelDataPojo excelData,String imageValue);
	
	String getcolor(ExcelDataPojo excelData,String colorValue);
	
	String resize(ExcelDataPojo excelData,String sizeValue);

	void pagination(ExcelDataPojo excelData);
	
	void dragdrop(ExcelDataPojo excelData);
	
	void calltransfer(ExcelDataPojo excelData);
	
	void movefolder(ExcelDataPojo excelData);
	
	void keydownevent(WebDriver driver);
	
	void sendkeysevent(WebDriver driver);
	
	void keyupevent(WebDriver driver);
	
	void refreshbrowser(WebDriver driver);
	
	String unprovisionedpopup(ExcelDataPojo excelData);
	
	void ScreenShotCapt(WebDriver driver);

	ExcelDataPojo getValues(List<String> cellValue);
	
	String ResultStatus(boolean flag);
	
   
}



