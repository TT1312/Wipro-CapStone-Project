package utils;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * ExcelReadUtils class provides utility methods to read data from an Excel file.
 */
public class ExcelReadUtils {
    private static FileInputStream fileInputStream;
    private static Workbook workbook;
    private static Sheet sheet;

    /**
     * Opens the specified Excel file and selects the given sheet.
     * @param filePath The path of the Excel file to open.
     * @param sheetName The name of the sheet within the Excel file.
     * @throws IOException If an I/O error occurs while reading the file.
     */
    public static void openExcel(String filePath, String sheetName) throws IOException {
        fileInputStream = new FileInputStream(filePath); // Open file input stream for Excel file
        workbook = WorkbookFactory.create(fileInputStream); // Create Workbook instance from file input stream
        sheet = workbook.getSheet(sheetName); // Get the specified sheet from the workbook
    }

    /**
     * Retrieves the value of a cell in the Excel sheet.
     * @param rowNum The row number (0-based index) of the cell.
     * @param colNum The column number (0-based index) of the cell.
     * @return The string value of the cell.
     */
    public static String getCellValue(int rowNum, int colNum) {
        Row row = sheet.getRow(rowNum); // Get the row based on row number
        Cell cell = row.getCell(colNum); // Get the cell in the row based on column number
        return cell.getStringCellValue(); // Return the string value of the cell
    }

    /**
     * Retrieves the number of rows with data in the Excel sheet.
     * @return The number of rows with data (1-based row count).
     */
    public static int getRowCount() {
        return sheet.getLastRowNum() + 1; // Get the last row number and add 1 to count rows (1-based index)
    }

    /**
     * Closes the workbook and file input stream.
     * @throws IOException If an I/O error occurs while closing the workbook or file input stream.
     */
    public static void closeExcel() throws IOException {
        workbook.close(); // Close the workbook
        fileInputStream.close(); // Close the file input stream
    }
}
