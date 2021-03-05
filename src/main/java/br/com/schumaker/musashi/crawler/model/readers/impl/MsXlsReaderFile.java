package br.com.schumaker.musashi.crawler.model.readers.impl;

import br.com.schumaker.musashi.crawler.model.readers.MsReader;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

/**
 *
 * @author Hudson Schumaker
 */
@Component
public class MsXlsReaderFile implements MsReader {

    @Override
    public String read(String filePath) {
        return readXlsFile(filePath);
    }

    private String readXlsFile(String filePath) {
        StringBuilder strBuilder = new StringBuilder();
        File file = new File(filePath);
        FileInputStream fis = null;
        HSSFWorkbook workbook = null;

        try {
            fis = new FileInputStream(file.getAbsolutePath());
            workbook = new HSSFWorkbook(fis);

            int numberOfSheets = workbook.getNumberOfSheets();
            for (int k = 0; k < numberOfSheets; k++) {
                HSSFSheet spreadsheet = workbook.getSheetAt(k);
                for (Row row : spreadsheet) {
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
            System.err.println("HsXlsReaderFile.readXlsFile: Exception " + filePath + "\n" + ex.getMessage());
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (workbook != null) {
                    workbook.close();
                }
            } catch (Exception ex) {
                System.err.println("HsXlsReaderFile.readXlsFile: Exception " + filePath + "\n" + ex.getMessage());
            }
        }
        return strBuilder.toString();
    }
}
