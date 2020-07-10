package Fusion;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.apache.log4j.Logger;

import Fusion.FusionInf;
import Fusion.BrowserDriverPath;
import Fusion.ElementByXPathIdInf;
import Fusion.ExcelDataPojo;
import Fusion.MyPhonePanel;

public class FusionImpl implements FusionInf {

	public Logger Log = Logger.getLogger(Logger.class.getName());
	WebDriver driver = null;
	WebElement validateElement = null;
	/****
	 * Process method defines by step wise
	 */

	@Override
	public void process(WebDriver driver, List<String> cellValue) {
		ExcelDataPojo excelData = null;
		this.driver = driver;
		if (!cellValue.contains("TYPE")) {
			excelData = getValues(cellValue);
			waitTillElementLoad(excelData);
			String status = performAction(excelData);
			cellValue.add(cellValue.size() - 1, status);
		} else {
			excelData = getValues(cellValue);
			String status = performAction(excelData);
			cellValue.add(cellValue.size() - 1, status);
		}
	}

	/**
	 *  
	 * GetElement using this method
	 * 
	 */

	@Override
	public WebElement getElement(String pathType, String pathValue) {
		WebElement element = null;
		switch (pathType.toUpperCase()) {
		case "XPATH":
			element = ElementByXPathIdInf.getByXPath(driver, (String) pathValue);
			break;
		case "ID":
			element = ElementByXPathIdInf.getByID(driver, (String) pathValue);
			break;
		default:
			break;
		}
		return element;

	}


	@Override
	public String getDriverFullPath(String browser) {
		return browser.isEmpty() ? BrowserDriverPath.FIREFOX.getDriver()
				: BrowserDriverPath.valueOf(browser.toUpperCase()).getDriver();
	}

	/**
	 *  
	 * Performing Action based on VMC Application
	 * 
	 */

	@Override
	public String performAction(ExcelDataPojo excelData) {
		String status = "FAIL", compareStatus = "";
		try {
			switch (excelData.getAction().toUpperCase()) {
			case "VERIFY":
				compareStatus = verify(excelData,
						getElement(excelData.getxPathIdType(), excelData.getXpathIdValue()).getText());
				break;
			case "POSITION":
				compareStatus = position(excelData,
						getElement(excelData.getxPathIdType(), excelData.getXpathIdValue()).getLocation());
			case "CLICK":
				try{
				System.out.println("click excelData:" + excelData);
				getElement(excelData.getxPathIdType(), excelData.getXpathIdValue()).click();
				}catch(Exception e){
					 Log.info("Click is not performed");
				}
				break;
			case "CLEAR":
				try{
				getElement(excelData.getxPathIdType(), excelData.getXpathIdValue()).clear();
				//Robot r = new Robot();												
				//r.keyPress(KeyEvent.VK_BACK_SPACE);				
				Thread.sleep(2000);
				}catch(Exception e){
					 Log.info("Clear is not performed");
				}
				break;
			case "KEYS":
				try{
				getElement(excelData.getxPathIdType(), excelData.getXpathIdValue()).sendKeys(excelData.getActionData());
				}catch(Exception e){
					 Log.info("Keys is not performed");
				}
				break;
			case "PAGINATION":
				getElement(excelData.getxPathIdType(), excelData.getXpathIdValue());
				break;
			case "DRAGDROP":
				Thread.sleep(4000);
				dragdrop(excelData);
				Thread.sleep(4000);
				break;
			case "MOVEFOLDER":
				Thread.sleep(4000);
				movefolder(excelData);
				Thread.sleep(4000);
				break;
			case "UNPROVISIONEDPOPUP":
				unprovisionedpopup(excelData);
				Thread.sleep(10000);
				break;
			case "UPLOADAVATAR":
				try{
				getElement(excelData.getxPathIdType(), excelData.getXpathIdValue()).click();
				ConfigRead con = new ConfigRead();
				Robot r = new Robot();
				Thread.sleep(1000);
				StringSelection stringselection = new StringSelection(con.getProperty("ResourcePath"));
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection, null);
				Thread.sleep(2000);
				r.keyPress(KeyEvent.VK_CONTROL);
				r.keyPress(KeyEvent.VK_V);
				r.keyRelease(KeyEvent.VK_CONTROL);
				r.keyRelease(KeyEvent.VK_V);
				Thread.sleep(2000);
				r.keyPress(KeyEvent.VK_ENTER);
				r.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(2000);
				}catch(Exception e){
					  e.printStackTrace();
		              Log.info("Avatar is not uploaded");
				}
				break;
			case "DROPDOWN":
				Select dropdownlist = new Select(getElement(excelData.getxPathIdType(), excelData.getXpathIdValue()));
				dropdownlist.selectByValue(excelData.getActionData());
				break;
			case "CALLTRANSFER":
				Select calltransferlist = new Select(getElement(excelData.getxPathIdType(), excelData.getXpathIdValue()));
				calltransferlist.selectByValue(excelData.getActionData());
				break;
			case "GETIMAGE":
				compareStatus = getimage(excelData,
						getElement(excelData.getxPathIdType(), excelData.getXpathIdValue()).getText());
				break;
			case "GETCOLOR":
				compareStatus = getcolor(excelData,
						getElement(excelData.getxPathIdType(), excelData.getXpathIdValue()).getCssValue("background-color"));
				break;
			case "RESIZE":
				compareStatus = resize(excelData,
						getElement(excelData.getxPathIdType(), excelData.getXpathIdValue()).getText());
				break;
			case "SCREENSHOTCAPT":
				ScreenShotCapt(driver);
				break;
			case "KEYDOWNEVENT":
				keydownevent(driver);
				break;
			case "SENDKEYSEVENT":
				sendkeysevent(driver);
				break;
			case "KEYUPEVENT":
				keyupevent(driver);
				break;
			case "REFRESHBROWSER":
				refreshbrowser(driver);
				break;
			case "EDITGROUP":
				driver.switchTo().activeElement().clear();
				driver.switchTo().activeElement().sendKeys("Tesla"); 
			case "MPLTOPL":
				MyPhonePanel obj = new MyPhonePanel();
				obj.mPlToPl();
				break;
			case "MPLTOCQ":
				MyPhonePanel obj1 = new MyPhonePanel();
				obj1.mPlToCq();
				break;
			case "MPLTOPG":
				MyPhonePanel obj2 = new MyPhonePanel();
				obj2.mplToPg();
				break;
			case "MPLTOPO":
				MyPhonePanel obj3 = new MyPhonePanel();
				obj3.mplToPo();
				break;
			case "PGTOMPL":
				PhoneGroup obj4 = new PhoneGroup();
				obj4.pgToMpl();
				break;
			case "PGTOPO":
				PhoneGroup obj5 = new PhoneGroup();
				obj5.pgToPo();
				break;
			case "PGTOPG":
				PhoneGroup obj6 = new PhoneGroup();
				obj6.pgToPg();
				break;
			case "POTOMPL":
				PhoneObject obj7 = new PhoneObject();
				obj7.poToMpl();
				break;
			case "POTOPO":
				PhoneObject obj8 = new PhoneObject();
				obj8.poToPo();
				break;
			case "POTOPG":
				PhoneObject obj9 = new PhoneObject();
				obj9.poToPg();
				break;
			case "CQTOMPL":
				CallQueues obj10 = new CallQueues();
				obj10.cqToMpl();
				break;
			default:
				break;
			}
			if (compareStatus.isEmpty())
				status = "PASS";
			else
				status = compareStatus;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	/**
	 *  
	 * Waiting for Element to Load
	 * 
	 */

	@Override
	public void waitTillElementLoad(ExcelDataPojo excelData) {
		WebElement element = getElement(excelData.getPreRequestType(), excelData.getPreRequestData());
		if (element != null && element.getText().isEmpty()) {
			System.out.println("text data:" + element.getText());
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 *  
	 * Verification of the text in each modules.
	 * 
	 */
	@Override
	public String verify(ExcelDataPojo excelData, String text) {
        
		String status = "FAIL";
       try{
		List<String> actiontextdata = Arrays.asList(excelData.getActionData().split(","));
		System.out.println("text" + text);
		System.out.println("text of actiontextdata" + actiontextdata.get(0));
		
		if (actiontextdata.get(0).contains(text.trim())) {
                	status = "PASS";
		} else {
			status = "FAIL";
		}
		

		}catch(Exception e){
			  e.printStackTrace();
              Log.info("Element is not verified");
		}return status;
        
	}

	/**
	 *  
	 * To Verify Image display in each modules.
	 * 
	 */

	@Override
	public String getimage(ExcelDataPojo excelData, String imageValue) {

		String status = "FAIL";
		try{

		WebElement getimage = null;
		getimage = getElement(excelData.getxPathIdType(), excelData.getXpathIdValue());
		if (getimage.isDisplayed()) {
			System.out.println("Image displayed");

			status = "PASS";
		} else {
			System.out.println("Image is not displayed");

			status = "FAIL";
		}
		}catch(Exception e){
			  e.printStackTrace();
              Log.info("Getimage is not displayed");
		}
		return status;
	}

	/**
	 *  
	 * To Verify Color display in each modules.
	 * 
	 */

	@Override
	public String getcolor(ExcelDataPojo excelData, String colorValue) {

		String status = "FAIL";
		try
		{

		Actions hover = new Actions(driver);
		WebElement element = getElement(excelData.getxPathIdType(), excelData.getXpathIdValue());
		hover.moveToElement(element).perform();
		String button_color = element.getCssValue("background-color");
		System.out.println("button_color" + button_color);
		String button = excelData.getActionData();
		System.out.println("button" + button);

		if (button.equals(button_color)) {
			status = "PASS";
		} else {
			status = "FAIL";
		}
		}catch(Exception e){
			  e.printStackTrace();
              Log.info("Getcolor is not displayed");
		}
		return status;
	}

	/**
	 *  
	 * To Verify Resize of X&Y Coordinates in each modules.
	 * 
	 */

	@Override
	public String resize(ExcelDataPojo excelData, String sizeValue) {

		String status = "FAIL";
		try
		{

		WebElement xplus = getElement(excelData.getxPathIdType(), excelData.getXpathIdValue());
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", xplus);
		System.out.println("Resize1");

		if (xplus.isEnabled()) {
			status = "PASS";
		} else {
			status = "FAIL";
		}
		}catch(Exception e){
			  e.printStackTrace();
              Log.info("Resize is not occured");
		}
		return status;
	}
	/**
	 *  
	 * Pagination for Call log
	 * 
	 */

	@Override
	public void pagination(ExcelDataPojo excelData) {
		try
		{

		WebElement Pagination = getElement(excelData.getxPathIdType(), excelData.getXpathIdValue());
		
		List<WebElement> elements = Pagination.findElements(By.tagName("button"));
		System.out.println("size:"+elements.size());
		WebElement last = driver.findElement(By.className("next"));
		if(elements.size()>0)
		{
			WebElement ele = elements.get(2);
			System.out.println(ele.getText());
			ele.click();
			System.out.println("Second button is clicked");
		}
		else if(last.isEnabled())
		{
			last.click();
			System.out.println("next button is clicked");
		}
		else
		{
			System.out.println("pagination not exists"); 
		}
		}catch(Exception e){
			  e.printStackTrace();
              Log.info("Pagination is not occured");
		}
	}
	/**
	 *  
	 * To Verify Position of X&Y Coordinates in each modules.
	 * 
	 */

	@Override
	public String position(ExcelDataPojo excelData, Point post) {

		List<String> posttextdata = Arrays.asList(excelData.getActionData().split(";"));
		// String posttextdata = excelData.getActionData();

		System.out.println("***************************************************************************************");
		System.out.println("posttextdata" + excelData.getActionData());
		System.out.println("post" + post);
		System.out.println("***************************************************************************************");

		if (posttextdata.equals(post))
			return "PASS";
		else
			return "FAIL";
	}
	/**
	 *  
	 * To take Screenshot in each modules.
	 * 
	 */

	@Override
	public void ScreenShotCapt(WebDriver driver) {
		try {
			this.driver = driver;
			Date d = new Date();
			System.out.println(d.toString());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
			File scrFile1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile1, new File("D:\\FusionVMC\\Screenshot\\" + sdf.format(d) + ".jpeg"));
		} catch (Exception e) {
			e.printStackTrace();
			Log.info("Screenshot is not Captured");
		} 
	}
	/**
	 *  
	 * To take Update Result.
	 * 
	 */

	@Override
	public String ResultStatus(boolean resultstatus) {
		
		String flag = null;

		if (resultstatus)
			flag = "PASS";
		else
			flag = "FAIL";

		return flag;
	}
	/**
	 *  
	 * To do Drag and drop Action
	 * 
	 */

	@Override
	public void dragdrop(ExcelDataPojo excelData) {
		
		try
		{

        System.out.println("DND - BEGIN");

		List<String> data = Arrays.asList(excelData.getActionData().split(","));

		JavascriptExecutor jsDnD = (JavascriptExecutor) driver;
		String jsString = "!function(t){t.fn.simulateDragDrop=function(a){return this.each(function(){new t.simulateDragDrop(this,a)})},t.simulateDragDrop=function(t,a){this.options=a,this.simulateEvent(t,a)},t.extend(t.simulateDragDrop.prototype,{simulateEvent:function(a,e){var n=\"dragstart\",r=this.createEvent(n);this.dispatchEvent(a,n,r),n=\"drop\";var i=this.createEvent(n,{});i.dataTransfer=r.dataTransfer,this.dispatchEvent(t(e.dropTarget)[0],n,i),n=\"dragend\";var s=this.createEvent(n,{});s.dataTransfer=r.dataTransfer,this.dispatchEvent(a,n,s)},createEvent:function(t){var a=document.createEvent(\"CustomEvent\");return a.initCustomEvent(t,!0,!0,null),a.dataTransfer={data:{},setData:function(t,a){this.data[t]=a},getData:function(t){return this.data[t]}},a},dispatchEvent:function(t,a,e){t.dispatchEvent?t.dispatchEvent(e):t.fireEvent&&t.fireEvent(\"on\"+a,e)}})}(jQuery);";
		System.out.println(
				"DragDrop" + "$(" + data.get(0) + ").simulateDragDrop({ dropTarget: " + data.get(1) + "});");
		jsDnD.executeScript(
				jsString + "$(" + data.get(0) + ").simulateDragDrop({ dropTarget: '" + data.get(1) + "'});");
		System.out.println("DND - END");
		}catch (Exception e) {
			e.printStackTrace();
			Log.info("DragandDrop is not occured");
		} 

	}
	/**
	 *  
	 * To do Call Transfer 
	 * 	 
	 */

	@Override
	public void calltransfer(ExcelDataPojo excelData) {
		
		try{
			
		System.out.println("CallTransfer - BEGIN");
        JavascriptExecutor jsDnDpo0 = (JavascriptExecutor) driver;           
        String jsLibraryString = "!function(t){t.fn.simulateDragDrop=function(a){return this.each(function(){new t.simulateDragDrop(this,a)})},t.simulateDragDrop=function(t,a){this.options=a,this.simulateEvent(t,a)},t.extend(t.simulateDragDrop.prototype,{simulateEvent:function(a,e){var n=\"dragstart\",r=this.createEvent(n);this.dispatchEvent(a,n,r),n=\"drop\";var i=this.createEvent(n,{});i.dataTransfer=r.dataTransfer,this.dispatchEvent(t(e.dropTarget)[0],n,i),n=\"dragend\";var s=this.createEvent(n,{});s.dataTransfer=r.dataTransfer,this.dispatchEvent(a,n,s)},createEvent:function(t){var a=document.createEvent(\"CustomEvent\");return a.initCustomEvent(t,!0,!0,null),a.dataTransfer={data:{},setData:function(t,a){this.data[t]=a},getData:function(t){return this.data[t]}},a},dispatchEvent:function(t,a,e){t.dispatchEvent?t.dispatchEvent(e):t.fireEvent&&t.fireEvent(\"on\"+a,e)}})}(jQuery);";            
        jsDnDpo0.executeScript(
                            jsLibraryString
                            + "function dndPhoneList(fromParam, iParam) {setTimeout(function(){fromParam.simulateDragDrop({ dropTarget: '#avpContainer tr.th2-exceeded.th1-exceeded.nobottomborder'});}, iParam*5000);}"
                            + " "
                            + "var hc = 0;"
                            + "var r = 0;"
                            + "var counter = 0;"
                            + "$('.top-section tbody tr.th2-exceeded.th1-exceeded').each(function(i, v){"
                            + "  if($(this).find('.call-hold-call').length > 0) {"
                            + "    if(hc < 2) {"
                            + "      dndPhoneList($(this), counter);"
                            + "      counter++;"
                            + "    }"
                            + "    hc++;"
                            + "  }"
                            + "  else if($(this).find('.call-ringing').length > 0) {"
                            + "    if(r < 2) {"
                            + "      dndPhoneList($(this), counter);"      
                            + "      counter++;"
                            + "    }"
                            + "    r++;"
                            + "  }"
                            + "});"
                     );

        System.out.println("CallTransfer - END");
		}catch (Exception e) {
			e.printStackTrace();
			Log.info("CallTransfer is not occured");
		} 
	}
	/**
	 *  
	 * Move folder in voicemail
	 * 
	 */

	@Override
	public void movefolder(ExcelDataPojo excelData) {
		
		try{
			
		System.out.println("voicemail - BEGIN");

		List<String> data = Arrays.asList(excelData.getActionData().split(","));

		JavascriptExecutor jsDnD = (JavascriptExecutor) driver;
		String jsString = "!function(t){t.fn.simulateDragDrop=function(a){return this.each(function(){new t.simulateDragDrop(this,a)})},t.simulateDragDrop=function(t,a){this.options=a,this.simulateEvent(t,a)},t.extend(t.simulateDragDrop.prototype,{simulateEvent:function(a,e){var n=\"dragstart\",r=this.createEvent(n);this.dispatchEvent(a,n,r),n=\"drop\";var i=this.createEvent(n,{});i.dataTransfer=r.dataTransfer,this.dispatchEvent(t(e.dropTarget)[0],n,i),n=\"dragend\";var s=this.createEvent(n,{});s.dataTransfer=r.dataTransfer,this.dispatchEvent(a,n,s)},createEvent:function(t){var a=document.createEvent(\"CustomEvent\");return a.initCustomEvent(t,!0,!0,null),a.dataTransfer={data:{},setData:function(t,a){this.data[t]=a},getData:function(t){return this.data[t]}},a},dispatchEvent:function(t,a,e){t.dispatchEvent?t.dispatchEvent(e):t.fireEvent&&t.fireEvent(\"on\"+a,e)}})}(jQuery);";
		System.out.println(
				"DragDrop" + "$(" + data.get(0) + ").simulateDragDrop({ dropTarget: " + data.get(1) + "});");
		jsDnD.executeScript(jsString + "$(" + data.get(0) + ").simulateDragDrop({ dropTarget: " + data.get(1) + "});");
		System.out.println("voicemail - END");
		}catch (Exception e) {
			e.printStackTrace();
			Log.info("MoveFolder is not occured");
		} 

	}
	/**
	 *  
	 * KeyDownEvent
	 * 
	 */

	@Override
	public void keydownevent(WebDriver driver) {

		try
		{

		Actions builder = new Actions(driver);
		builder.keyDown(Keys.CONTROL).build().perform();
		System.out.println("KeyDown Event performed ");
		}catch (Exception e) {
			e.printStackTrace();
			Log.info("KeydownEvent is not occured");
		} 
		
		}
	/**
	 *  
	 * SendKeys Event
	 * 
	 */
	@Override
	public void sendkeysevent(WebDriver driver) {
		try
		{

		Actions builder = new Actions(driver);
		builder.sendKeys(Keys.DELETE).build().perform();
		System.out.println("voicemail select to be deleted ");
		}catch (Exception e) {
			e.printStackTrace();
			Log.info("sendkeysevent is not occured");
		} 
		
		}
	/**
	 *  
	 * KeyUp Event
	 * 
	 */
	@Override
	public void keyupevent(WebDriver driver) {
		try
		{

		Actions builder = new Actions(driver);
		builder.keyUp(Keys.CONTROL).build().perform();
		System.out.println("voicemail not deleted ");
		}catch (Exception e) {
			e.printStackTrace();
			Log.info("keyupevent is not occured");
		} 
		
		}
	/**
	 *  
	 * Refresh Browser
	 * 
	 */
	@Override
	public void refreshbrowser(WebDriver driver) {
		
       try{
		driver.navigate().refresh();
		System.out.println("Browser is refreshed ");
       }catch (Exception e) {
			e.printStackTrace();
			Log.info("Refreshbrowser is not occured");
		} 
		
		}
	/**
	 *  
	 * To check UnAuthorized Users 
	 * @throws  
	 * 
	 */
	@Override
	public String unprovisionedpopup(ExcelDataPojo excelData)  {
		
			
		String status = "FAIL";
		try{
		WebElement popup = getElement(excelData.getxPathIdType(), excelData.getXpathIdValue());
	
		if(!popup.isEnabled()){
			System.out.println("Unprovisioned pop up is not displayed");
			status = "PASS";
		}
		else {
			popup.click(); 
			System.out.println("Unprovisioned pop up is displayed");
			status = "PASS";
		} 
		}catch (Exception e) {
			e.printStackTrace();
			Log.info("UnprovisionedPopup is not occured");
		} 
		return status;
	}
	/**
	 *  
	 * Getting list of values
	 * 
	 */

	@Override
	public ExcelDataPojo getValues(List<String> cellValue) {
		return new ExcelDataPojo(cellValue.get(1), cellValue.get(2), cellValue.get(3), cellValue.get(4),
				cellValue.get(5), cellValue.get(6), cellValue.get(7), cellValue.get(8),cellValue.get(9),cellValue.get(10));
	}

	


	

}
