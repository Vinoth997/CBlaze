package org.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Putdata {
	public static void main(String[] args) throws IOException {
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
//		
//		
//		driver.get("https://www.facebook.com/login");
		
		File file =new File("C:\\Users\\Admin\\eclipse-workspace\\SMS\\ExcelSheet\\sers.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook book =new XSSFWorkbook(stream);
		Sheet sheet = book.getSheet("Sheet2");
		
//		Row row = sheet.createRow(1);
		Row row = sheet.getRow(0);
//		sheet.removeRow(row);
//		Cell createCell = row.createCell(2);
		Cell cell = row.getCell(1);
//		cell.removeCellComment();
//		cell.re
		
		
		cell.setCellValue("nonono");
		System.out.println("yes");
		FileOutputStream opstream=new FileOutputStream(file);
		book.write(opstream);
		
	}

}
