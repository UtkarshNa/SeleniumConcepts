package com.DataDriver.Test;

import com.excel.utility.Xls_Reader;

public class ExcelOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Xls_Reader reader=new Xls_Reader("C:\\Users\\hp\\eclipse-workspace\\SeleniumSessions\\src\\com\\testData\\halfebaytestdata.xlsx");
		
		
		if(!reader.isSheetExist("HomePage ")) {
			reader.addSheet("HomePage");
		

	}
		
		int c=reader.getColumnCount("TestData");
		System.out.println(c);
		
		int r= reader.getCellRowNum("TestData", "name", "Meena");
		System.out.println(r);
}
}
