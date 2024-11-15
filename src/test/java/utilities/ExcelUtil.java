package utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtil {

    private static Workbook workbook;
    private static Sheet sheet;

    public static void loadExcel(String filePath, int sheetIndex) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(fileInputStream);
        sheet = workbook.getSheetAt(sheetIndex);
        fileInputStream.close();
    }

    public static String getCellData(int row, int col) {
        return sheet.getRow(row).getCell(col).toString();
    }

    public static Integer getRowTotal(String path) {
        int filledRowCount = 0;
        try (FileInputStream fis = new FileInputStream(path);
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                boolean isEmptyRow = true;
                for (Cell cell : row) {
                    if (cell.getCellType() != CellType.BLANK) {
                        isEmptyRow = false;
                        break;
                    }
                }
                if (!isEmptyRow) {
                    filledRowCount++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filledRowCount;
    }

}
