package sseleniumDemo.fradeemo;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	public static void main(String[] args) throws IOException
	{
	System.setProperty("webdriver.chrome.driver","C:\\Users\\91978\\Downloads\\Selenium_updatedjars\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("https://opensource-demo.orangehrmlive.com/");
	File f=new File("C:\\Users\\91978\\Desktop\\data.xlsx");
	
	FileInputStream fis=new FileInputStream(f);
	//.xlsx---->xssf
	//.xls--->hssf
	
	XSSFWorkbook workbook=new XSSFWorkbook(fis);
	XSSFSheet sheet=workbook.getSheetAt(0);
	Row row=sheet.getRow(2);
	Cell cell=row.getCell(0);
	String name=cell.getStringCellValue();
Cell cell1=row.getCell(1);
String pass=cell1.getStringCellValue();
System.out.println(driver.getTitle());

	driver.findElement(By.name("txtUsername")).sendKeys(name);
	driver.findElement(By.name("txtPassword")).sendKeys(pass);
	driver.findElement(By.name("Submit")).click();
	
}
}