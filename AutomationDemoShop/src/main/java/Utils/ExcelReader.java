package Utils;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Context.Constants;

public class ExcelReader {
	
	public static String getCellValue(int rowNumber, int cellNumber) throws IOException {

		FileInputStream fis = new FileInputStream(Constants.EXCELFILE);
        XSSFWorkbook xs = new XSSFWorkbook(fis);
        Sheet sh = xs.getSheet("Sheet1");
        Row row = sh.getRow(rowNumber);
        Cell cell=row.getCell(cellNumber);
        return cell.toString();
            
	}

}
