package util;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutils {

	public static void main(String[] args) {
		getRowcount();
		getCelldata();
	}
	
	
	public static void getRowcount() {
		
		String filePath="./data/testData.xlsx";
		
		try {
			XSSFWorkbook workbook= new XSSFWorkbook(filePath);
			XSSFSheet sheet=workbook.getSheet("Sheet1");
			int totalrows=sheet.getPhysicalNumberOfRows();
			System.out.println("number of rows " +totalrows);
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}
	public static void getCelldata() {
		
String filePath="./data/testData.xlsx";
		
		try {
			XSSFWorkbook workbook= new XSSFWorkbook(filePath);
			XSSFSheet sheet=workbook.getSheet("Sheet1");
			DataFormatter formatter=new DataFormatter();
		
			Object value=formatter.formatCellValue(sheet.getRow(1).getCell(1));
			System.out.println(value);
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}
	
}
