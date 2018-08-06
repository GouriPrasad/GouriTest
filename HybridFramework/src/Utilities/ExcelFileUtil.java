package Utilities;




import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

 

public class ExcelFileUtil {
 
    	Workbook wb ;
	//It will load all the Excel sheet
	
public ExcelFileUtil() throws Exception, InvalidFormatException, IOException
{
	
	
		FileInputStream fis = new FileInputStream( "./TestInput/InputSheet.xlsx");
	    wb=WorkbookFactory.create(fis);
	    
	
	
	
}

public int rowcount(String sheetname)
{
	return wb.getSheet(sheetname).getLastRowNum();
}
public int colcount(String sheetname,int rownum)
{
	return wb.getSheet(sheetname).getRow(rownum).getLastCellNum();
}
public String getData(String sheetname,int row,int column)
{
	String data=" ";
	if(wb.getSheet(sheetname).getRow(row).getCell(column).getCellType()==Cell.CELL_TYPE_NUMERIC)
	{
		int celldata=(int)wb.getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();
		data=String.valueOf(celldata);
	}
	else
	{
		data=wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
	}
	return data;
}
	public void setData(String sheetname,int row,int column,String data) throws Exception
	{
		
		Sheet sh=wb.getSheet(sheetname);
		Row rownum=sh.getRow(row);
		Cell cell=rownum.createCell(column);
		cell.setCellValue(data);
		if(data.equalsIgnoreCase("PASS"))
		{
			CellStyle style=wb.createCellStyle();
			Font font=wb.createFont();
			//Apply color
			font.setColor(IndexedColors.GREEN.getIndex());
			font.setBoldweight(Font.BOLDWEIGHT_BOLD);
			style.setFont(font);
			rownum.getCell(column).setCellStyle(style);
		}else
		if(data.equalsIgnoreCase("FAIL"))
		{
			CellStyle style=wb.createCellStyle();
			Font font=wb.createFont();
			//Apply color
			font.setColor(IndexedColors.RED.getIndex());
			font.setBoldweight(Font.BOLDWEIGHT_BOLD);
			style.setFont(font);
			rownum.getCell(column).setCellStyle(style);
		}
		FileOutputStream fos=new FileOutputStream("./TestOutput/OutputSheet.xlsx");
		wb.write(fos);
		fos.close();
	}
}

