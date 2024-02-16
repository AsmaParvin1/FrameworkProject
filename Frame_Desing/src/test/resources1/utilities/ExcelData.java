package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

    public class ExcelData {
    	
	String excelpath="C:\\Users\\amina\\OneDrive\\Desktop\\ExData.xlsx";
     

	public String[] readExcel() throws IOException  {
		
		String[]data=new String[5];
		FileInputStream fis=new FileInputStream(excelpath);
		XSSFWorkbook workbook =new XSSFWorkbook(fis);
		XSSFSheet sheet =workbook.getSheetAt(0);
	    Row row=sheet.getRow(1);
		Cell cell1=row.getCell(0);
		String UserId=cell1.getStringCellValue();
		Cell cell2=row.getCell(1);
		String NewPassword=cell2.getStringCellValue();
		Cell cell3=row.getCell(2);
		String RepeatPassword=	cell3.getStringCellValue();
				
		data[0]=UserId;
		data[1]=NewPassword;
		data[2]=RepeatPassword;

	
		return data;
	}
	
  
}
