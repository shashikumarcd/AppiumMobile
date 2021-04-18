package components;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadWriteExcel {


	public List<String> ReadUserDetails1(int row) throws Exception {
		FileInputStream fis = new FileInputStream(new File("src/test/resources/TestData/UserDetails.xlsx").getAbsolutePath());
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheetAt(0);
		List<String> cellData= new ArrayList<String>();		
		for (int i=0; i<=1; i++)
		{
			if(sheet.getRow(row).getCell(i)== null) {
				cellData.add(null);
			}
			else {
				cellData.add(sheet.getRow(row).getCell(i).getStringCellValue().toString());            
			}

		}  
		wb.close();        
		return cellData;

	}

	public String[] ReadUserDetails(int row) throws Exception {

		FileInputStream fis = new FileInputStream(new File("src/test/resources/TestData/UserDetails.xlsx").getAbsolutePath());
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheetAt(0);	

		XSSFRow r = (XSSFRow) sheet.getRow(0);
		int totalColumn = r.getLastCellNum();
		String[] cellData = new String[totalColumn];
		DataFormatter fmt = new DataFormatter();

		for (int i=0; i<totalColumn; i++)
		{	
			if(sheet.getRow(row).getCell(i)!=null) {
				Cell cell = sheet.getRow(row).getCell(i);
				cellData[i]=fmt.formatCellValue(cell);				
			}else {


				cellData[i]=null;

			}	

		}  
		wb.close();        
		return cellData;

	}

}
