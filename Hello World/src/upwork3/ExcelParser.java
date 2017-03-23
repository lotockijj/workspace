package upwork3;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelParser {

	public static void main(String[] args) {
		/*
		 * To change this template, choose Tools | Templates
		 * and open the template in the editor.
		 */

		try {
			FileInputStream file = new FileInputStream(new File("C:\\Documents and Settings\\admin\\Desktop\\imp data\\howtodoinjava_demo.xlsx"));

			//Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			//Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);

			//Iterate through each rows one by one
//			Iterator rowIterator = sheet.iterator();
//			while (rowIterator.hasNext()){
//				Row row = rowIterator.next();
//				//For each row, iterate through all the columns
//				Iterator<Cell> cellIterator = row.cellIterator();
//
//				while (cellIterator.hasNext()) {
//					Cell cell = cellIterator.next();
//					//Check the cell type and format accordingly
//					switch (cell.getCellType()) {
//					case Cell.CELL_TYPE_NUMERIC:
//						System.out.print(cell.getNumericCellValue() + "\t");
//						break;
//					case Cell.CELL_TYPE_STRING:
//						System.out.print(cell.getStringCellValue() + "\t");
//						break;
//					}
//				}
//				System.out.println("");
//			}
//			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
