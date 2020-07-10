package Fusion;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelSheet {

	public List<ArrayList<String>> sheet;
	List<String> row;
	final String EXCELFILEPATH = "D:\\FusionVMC\\FusionVMCchromeProd.xlsx"; //Input file
	public Integer numberOfSheets = 15;
	

	/**
	 *  
	 * Reading Excel sheet
	 * 
	 */


	public List<ArrayList<String>> getExcelData(String sheetName) {

		sheet = new ArrayList<ArrayList<String>>();
		try (FileInputStream inputStream = new FileInputStream(new File(EXCELFILEPATH));
				Workbook workbook = new XSSFWorkbook(inputStream);) {
			workbook.getSheet(sheetName).forEach(rowValue -> addToList(rowValue));
			
			numberOfSheets = workbook.getNumberOfSheets();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sheet; 
	}


	public void addToList(Row nextRow) {
		row = new ArrayList<String>();
		nextRow.forEach(cell -> {
			switch (cell.getCellTypeEnum()) {
			case STRING:
				row.add(cell.getStringCellValue());
				break;
			case NUMERIC:
				row.add(String.valueOf(cell.getNumericCellValue() + ""));
				break;
			case BLANK:
				row.add("");
			default:
				break;
			}
		});
		sheet.add((ArrayList<String>) row);
	}
}

