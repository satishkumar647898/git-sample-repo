package com.demowebshop.testdev;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.demowebshop.generic.Utility;

public class Practice{
	@Test
	public void test() {
//		Reporter.log("BrowserOpen", true);
//		String data = Utility.excelNlp.readSingleDataFromExcel("Login", 1, 2);
//		System.out.println(data);
		Object[][] data1 = Utility.excelNlp.getMultipleData("MultipleData");
		for(int i=0;i<data1.length;i++) {
			for(int j=0;j<data1.length;j++) {
				System.out.print(data1[i][j]+" ");
			}
			System.out.println();
		}
	}
	@DataProvider(name="excelData")
	public Object[][] getData() {
		return Utility.excelNlp.getMultipleData("MultipleData");
	}
	@Test(dataProvider = "excelData")
	public void dataProvider(String brand, String mobile,String price) {
		System.out.println(brand+" "+mobile+" "+price);
	}
	

}
