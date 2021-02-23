package de.com.schumaker.core.reader.impl;

import de.com.schumaker.core.reader.HsReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Iterator;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Hudson Schumaker
 */
public class HsXlsxReaderFile implements HsReader {

    @Override
    public String read(Path arq) {
        return readXlsxFile(arq.normalize().toString());
    }
    
    private String readXlsxFile(String filePath){
        StringBuilder strBuilder = new StringBuilder();
        File file = new File(filePath);
        FileInputStream fis = null;
        XSSFWorkbook workbook = null;
        try {
            fis = new FileInputStream(file.getAbsolutePath());
            workbook = new XSSFWorkbook(fis);
            XSSFSheet spreadsheet = workbook.getSheetAt(0);
            Iterator< Row> rowIterator = spreadsheet.iterator();
            while (rowIterator.hasNext()) {
                XSSFRow row = (XSSFRow) rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    if (cell.getCellType() == CellType.STRING) {
                        strBuilder.append(cell.getStringCellValue().trim());
                    }
                    if (cell.getCellType() == CellType.NUMERIC) {
                        strBuilder.append(cell.getNumericCellValue());
                    }
                }
            }
        } catch (IllegalArgumentException ex) {
            System.err.println("HsXlsxReaderFile.readXlsxFile: IllegalArgumentException " + filePath + "\n" + ex.getMessage());
        } catch (FileNotFoundException ex) {
            System.err.println("HsXlsxReaderFile.readXlsxFile: FileNotFoundException " + filePath + "\n" + ex.getMessage());
        } catch (IOException ex) {
            System.err.println("HsXlsxReaderFile.readXlsFxile: IOException " + filePath + "\n" + ex.getMessage());
        } catch (EncryptedDocumentException ex){
            System.err.println("HsXlsxReaderFile.readXlsxFile: EncryptedDocumentException " + filePath + "\n" + ex.getMessage());
        } catch (RuntimeException ex){
            System.err.println("HsXlsxReaderFile.readXlsxFile: RuntimeException " + filePath + "\n" + ex.getMessage());
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (workbook != null) {
                    workbook.close();
                }
            } catch (IOException ex) {
                System.err.println("HsXlsxReaderFile.readXlsxFile: IOException " + filePath + "\n" + ex.getMessage());
            }
        }
        return strBuilder.toString();
    }
}
