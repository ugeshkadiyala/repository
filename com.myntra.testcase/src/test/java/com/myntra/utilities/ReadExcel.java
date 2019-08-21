package com.myntra.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	XSSFWorkbook ws;
	XSSFSheet ss;
	
	public ReadExcel(String filepath){
		try {
			File src = new File(filepath);
			FileInputStream fis = new FileInputStream(src);
				ws = new XSSFWorkbook(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	public String getData(int sheetnumber, int row, int column) {
		ss = ws.getSheetAt(sheetnumber);
		String data = ss.getRow(row).getCell(column).getStringCellValue();
		return data;
	}
	
	public int getRowCount(int sheetnumber) {
		int row = ws.getSheetAt(sheetnumber).getLastRowNum();
		row = row+1;
		return row;
		
	}

}