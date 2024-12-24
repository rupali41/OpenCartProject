package baseTest;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class Data_ProviderClass {
	@DataProvider(name="login_Data")
	
	public Object[][] dataProvider_forLoginTest() throws IOException {
	    FileInputStream file = new FileInputStream("C:\\Users\\Admin\\Documents\\Data_provider_File.xlsx");
	    XSSFWorkbook book = new XSSFWorkbook(file);
	    XSSFSheet sheet = book.getSheet("project_sheet");
	    
	    int row_Num = sheet.getLastRowNum(); // Total rows (excluding header)
	    int cell_Num = sheet.getRow(0).getLastCellNum(); // Total columns
	    
	    // Initialize 2D array to hold data
	    String[][] Value_arry = new String[row_Num][cell_Num];
	    
	    // Loop through rows and columns
	    for (int i = 1; i <= row_Num; i++) { // Start from 1 (skip header)
	        XSSFRow row = sheet.getRow(i);
	        for (int j = 0; j < cell_Num; j++) { // Start from 0
	            XSSFCell cell = row.getCell(j);
	            Value_arry[i - 1][j] =  cell.getStringCellValue(); // Handle null cells
	        }
	    }
	    
	    book.close(); // Always close resources
	    file.close();
	    return Value_arry; // Return the 2D array
	}
}
