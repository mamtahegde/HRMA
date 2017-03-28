package dummies;

import generics.Utility;

public class DatabaseExcel {
	
	public static void main(String[] args) {
		int rowCount=Utility.getExcelRowCount("./data/DataBase.xlsx", "hs_hr_employee");
		System.out.println(rowCount);
		for(int i=1;i<=rowCount;i++){
			System.out.println(Utility.getExcelCellValue("./data/DataBase.xlsx", "hs_hr_employee", i, 0));
		}
		System.out.println(Utility.getExcelCellValue("./data/DataBase.xlsx", "hs_hr_employee", 1, 1));
		
	}

}
