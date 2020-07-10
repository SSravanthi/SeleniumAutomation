package Fusion;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import Fusion.FusionImpl;
import Fusion.FusionInf;
import Fusion.ElementByXPathIdInf;

public class Fusionmain implements ElementByXPathIdInf {

	static WebDriver driver = null;
	static WebDriverWait wait = null;
	static List<ArrayList<String>> excelData = null;
	static String SITEURL;
	static final String EXCELFILEPATH = "D:\\FusionVMC\\FusionVMCchromeProd.xlsx"; //Input sheet

	/**
	 * @param args
	 * @throws InterruptedException
	 * Main method to run automation across all browsers.
	 */
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.gecko.driver", "D:\\Drivers\\geckodriver.exe");

		try {


			FusionInf Fusionmain = new FusionImpl();
			ReadExcelSheet readExcelsheet = new ReadExcelSheet();
			
			List<List<ArrayList<String>>> excelappend = new ArrayList<>();

			List<ArrayList<String>> scenarioList = readExcelsheet.getExcelData("Scenarios");
			SITEURL = scenarioList.get(0).get(0);
			
			scenarioList.remove(0);
			System.out.println("scenarioList"+scenarioList);
			
			List<String> arrList = new ArrayList<String>();
			scenarioList.forEach(list -> arrList.addAll(list));
			for (String sheetName: arrList) {
				excelData = readExcelsheet.getExcelData(sheetName);
				System.out.println("****Sheet name ****"+sheetName);
				System.out.println("excelData:" + excelData);

				if ("firefox".equalsIgnoreCase(excelData.get(1).get(0))) {

					File pathBinary = new File("D:\\Mozilla Firefox\\firefox.exe");
					FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
					DesiredCapabilities desired = DesiredCapabilities.firefox();
					FirefoxOptions options = new FirefoxOptions();
					desired.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options.setBinary(firefoxBinary));
					desired.setCapability("marionette", true);
					desired.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
					driver = new FirefoxDriver(options);
					driver.manage().window().maximize();
				} else if ("Chrome".equalsIgnoreCase(excelData.get(1).get(0))) {
					System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sravanthi Somalaraju\\Documents\\Selenium\\chromedriver\\chromedriver.exe");

					driver = (WebDriver) Class.forName(Fusionmain.getDriverFullPath(excelData.get(1).get(0))).newInstance();
				} else if ("IE".equalsIgnoreCase(excelData.get(1).get(0))) {
					System.setProperty("webdriver.ie.driver", "D:\\Drivers\\IEDriverServer.exe");

					driver = (WebDriver) Class.forName(Fusionmain.getDriverFullPath(excelData.get(1).get(0))).newInstance();
				} 
				driver.get(SITEURL);
				driver.manage().deleteAllCookies();
				driver.manage().window().maximize();
				excelData.stream().forEach(cellValue -> {
					Fusionmain.process(driver, cellValue);
				});
				driver.close();
				Thread.sleep(1000);
				System.out.println("excelData:" + excelData);
				excelappend.add(excelData);

			}


			/**
			 *  
			 * To Generate a Consolidated Report across browsers.
			 * 
			 */
			List<ArrayList<String>> combineSheets = new ArrayList<>();
			for (int i = 0; i < excelappend.size(); i++) {
				excelData = excelappend.get(i);
				excelData.remove(0);
				combineSheets.addAll(excelData);
			}
			ReportGenerator.writeReport(combineSheets);
			System.out.println("combineSheets" + combineSheets);
			System.out.println("output file written");

		} catch (UnhandledAlertException f) {
			try {
				Alert alert = driver.switchTo().alert();
				String alertText = alert.getText();
				System.out.println("Alert data:" + alertText);
				alert.accept();
			} catch (NoAlertPresentException e) {
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}

	}
}
