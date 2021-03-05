package br.com.schumaker.musashi.crawler.model.readers.impl;

import br.com.schumaker.musashi.crawler.model.readers.MsReader;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

/**
 *
 * @author Hudson Schumaker
 */
@Component
public class MsXlsxReaderFile implements MsReader {

    @Override
    public String read(String filePath) {
        return readXlsxFile(filePath);
    }

    private String readXlsxFile(String filePath) {
        StringBuilder strBuilder = new StringBuilder();
        File file = new File(filePath);
        FileInputStream fis = null;
        XSSFWorkbook workbook = null;
        try {
            fis = new FileInputStream(file.getAbsolutePath());
            workbook = new XSSFWorkbook(fis);

            int numberOfSheets = workbook.getNumberOfSheets();
            for (int k = 0; k < numberOfSheets; k++) {
                XSSFSheet spreadsheet = workbook.getSheetAt(k);
                for (Row cells : spreadsheet) {
                    XSSFRow row = (XSSFRow) cells;
                    Iterator<Cell> cellIterator = row.cellIterator();
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        if (cell.getCellType() == CellType.STRING) {
                            strBuilder.append(cell.getStringCellValue().trim());
                            continue;
                        }

                        if (cell.getCellType() == CellType.NUMERIC) {
                            strBuilder.append(cell.getNumericCellValue());
                            continue;
                        }

                        if (cell.getCellType() == CellType.FORMULA) {
                            strBuilder.append(cell.getCellFormula());
                        }
                    }
                }
            }
        } catch (Exception ex) {
            System.err.println("HsXlsxReaderFile.readXlsxFile: Exception " + filePath + "\n" + ex.getMessage());
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (workbook != null) {
                    workbook.close();
                }
            } catch (Exception ex) {
                System.err.println("HsXlsxReaderFile.readXlsxFile: Exception " + filePath + "\n" + ex.getMessage());
            }
        }
        return strBuilder.toString();
    }
}
