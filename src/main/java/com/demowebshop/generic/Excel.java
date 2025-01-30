package com.demowebshop.generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel implements FrameworkConstant{
	public String readSingleDataFromExcel(String sheetName,int row, int coloumn) {
		FileInputStream fis=null;
		XSSFWorkbook workbook=null;
		try {
			fis=new FileInputStream(excel_file_path);
			try {
				workbook=new XSSFWorkbook(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}	
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		XSSFCell cell = workbook.getSheet(sheetName).getRow(row).getCell(coloumn);
		String data=new DataFormatter().formatCellValue(cell).toString();
		return data;	
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////
	public Object[][] getMultipleData(String sheetName) {
		FileInputStream fis=null;
		XSSFWorkbook workbook=null;
		try {
			fis=new FileInputStream(excel_file_path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			workbook=new XSSFWorkbook(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		int lastRowNum=workbook.getSheet(sheetName).getLastRowNum();
		int lastCellNum=workbook.getSheet(sheetName).getRow(0).getLastCellNum();
		Object[][]data=new Object[lastRowNum][lastCellNum];
		for(int i=1;i<=lastRowNum;i++) {
			XSSFRow rowdata = workbook.getSheet(sheetName).getRow(i);
			for(int j=0;j<lastCellNum;j++) {
				XSSFCell cellData = rowdata.getCell(j);
				String value=new DataFormatter().formatCellValue(cellData).toString();
				data[i-1][j]=value;
			}
		}
		try {
			workbook.close();
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
}

