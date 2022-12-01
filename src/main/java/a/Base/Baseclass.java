package a.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {

	public static WebDriver driver;

	public static void browserOpen() throws IOException {

		if ((excelGetdata("ENV &LOGIN", 3, 1)).equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if ((excelGetdata("ENV &LOGIN", 3, 1)).equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if ((excelGetdata("ENV &LOGIN", 3, 1)).equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			System.out.println("Check the Browse Name");
		}
		
		
		
		
		
		

		driver.manage().window().maximize();
		driver.get(excelGetdata("ENV &LOGIN", 0, 1));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}

	public static void browserClose() throws IOException {
		driver.close();

	}

	public static void waitForElement(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
//		wait.until(Excepte)
	}

	public static void takesScreenShot(WebElement element) throws IOException {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
		LocalDateTime ldt = LocalDateTime.now();
		String TimeStamp = dtf.format(ldt);

		File srcFile = element.getScreenshotAs(OutputType.FILE);
		File destFile = new File("C:\\Users\\Admin\\Pictures\\Saved Pictures\\" + TimeStamp + ".png");
		FileUtils.copyFile(srcFile, destFile);
	}
	public static void takesScreenShotfull() throws IOException {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
		LocalDateTime ldt = LocalDateTime.now();
		String TimeStamp = dtf.format(ldt);
		TakesScreenshot element = (TakesScreenshot) driver;
		File srcFile = element.getScreenshotAs(OutputType.FILE);
		File destFile = new File("C:\\Users\\Admin\\Pictures\\Saved Pictures\\" + TimeStamp + ".png");
		FileUtils.copyFile(srcFile, destFile);
	}


	public static void failedMethodTakesscreenshot(ITestResult result) throws Exception {

		TakesScreenshot scr = (TakesScreenshot) driver;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
		LocalDateTime ldt = LocalDateTime.now();
		String TimeStamp = dtf.format(ldt);

		File srcFile = scr.getScreenshotAs(OutputType.FILE);

		if (result.FAILURE == result.getStatus()) {

			File destFile = new File("C:\\Users\\Admin\\Pictures\\Saved Pictures\\" + TimeStamp + "-" + result.getName() + ".png");
			FileUtils.copyFile(srcFile, destFile);
		}

		else if (result.SKIP == result.getStatus()) {
			File destFile = new File(
					"C:\\Users\\Admin\\Pictures\\Saved Pictures\\" + TimeStamp + " " + result.getName() + ".png");
			FileUtils.copyFile(srcFile, destFile);
		} else if (result.SUCCESS == result.getStatus()) {
			File destFile = new File(
					"C:\\Users\\Admin\\Pictures\\Saved Pictures\\" + TimeStamp + " " + result.getName() + ".png");
			FileUtils.copyFile(srcFile, destFile);
		}

	}

	public static String excelGetdata(String sheetName, int rowNum, int cellNum) throws IOException {

		File file = new File("C:\\Users\\Admin\\eclipse-workspace\\SMS\\ExcelSheet\\sms.xlsx");

		FileInputStream inputStream = new FileInputStream(file);

		Workbook book = new XSSFWorkbook(inputStream);
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		try {
			String stringCellValue = cell.getStringCellValue();
			System.out.println(stringCellValue);
			String value = stringCellValue;
			return value;

		} catch (Exception e) {
			double numericCellValue1 = cell.getNumericCellValue();
			String numericCellValue = String.valueOf((long) numericCellValue1);
			System.out.println(numericCellValue);
			String value1 = numericCellValue;
			return value1;
		}

	}

	public static void excelPutdata(String sheetName, int rowNum, int cellNum, String value) throws IOException {
		File file = new File("C:\\Users\\Admin\\eclipse-workspace\\SMS\\ExcelSheet\\sms.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook book = new XSSFWorkbook(stream);
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		cell.setCellValue(value);
		FileOutputStream opstream = new FileOutputStream(file);
		book.write(opstream);

	}

	public static void mouseoveractions(WebElement target) {
		try {
			Actions a = new Actions(driver);
			a.click(target).perform();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void newTabhandle() {
		Set<String> par = driver.getWindowHandles();
		Set<String> newwindow = driver.getWindowHandles();
		for (String x : newwindow) {
			if (!par.equals(x)) {
				driver.switchTo().window(x);
			}
		}
	}

	public static void parentTabhandle() {
		driver.close();
		Set<String> par = driver.getWindowHandles();

		for (String x : par) {
			driver.switchTo().window(x);
		}

	}

	public static void newWindowhandle() {

//		Set<String> par = driver.getWindowHandles();
//		System.out.println(par);
//		Set<String> newwindow = driver.getWindowHandles();
//		System.out.println(newwindow);
//		for (String x : newwindow) {
//			if (!par.equals(x)) {
//				driver.switchTo().window(x);
//			}
//
//		}

	}

	public static void Scrolljavascriptexecutor(String scroll, WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		if ("up".equalsIgnoreCase(scroll)) {
			js.executeScript("arguments[0].scrollIntoView(false)", element);

		}
		if ("down".equalsIgnoreCase(scroll)) {
			js.executeScript("arguments[0].scrollIntoView(true)", element);

		}

	}

	public static void Javascriptexecutor(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Object executeScript = js.executeScript("return arguments[0].getAtteibute('value')", "textusename");

	}

}