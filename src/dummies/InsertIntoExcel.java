package dummies;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class InsertIntoExcel {
	
	public static void main(String[] args) throws IOException {
		
//		//creating and inserting
		String excelFile="E:/exp.xlsx";
		String sheetName="EmpData";
		
		XSSFWorkbook wb=new XSSFWorkbook();
		XSSFSheet sheet=wb.createSheet(sheetName);
		
		for(int i=0;i<5;i++){
			XSSFRow row=sheet.createRow(i);
			
			for(int c=0;c<5;c++){
				XSSFCell cell=row.createCell(c);
				
				cell.setCellValue("Cell "+i+" "+c);
			}
		}
		FileOutputStream fileOut = new FileOutputStream(excelFile);
		wb.write(fileOut);
		fileOut.flush();
		fileOut.close();
		wb.close();
	}
	}
	

