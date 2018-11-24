package de.com.schumaker.core.reader.impl;

import de.com.schumaker.core.reader.HsReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Iterator;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author hudson schumaker
 */
public class HsXlsReaderFile implements HsReader{

    @Override
    public String read(Path arq) {
        return readXlsFile(arq.normalize().toString());
    }
    
    private String readXlsFile(String filePath){
        StringBuilder strBuilder = new StringBuilder();
        File file = new File(filePath);
        FileInputStream fis = null;
        HSSFWorkbook workbook = null;
        try {
            fis = new FileInputStream(file.getAbsolutePath());
            workbook = new HSSFWorkbook(fis);
            HSSFSheet spreadsheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = spreadsheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
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
            System.err.println("HsXlsReaderFile.readXlsFile: IllegalArgumentException " + filePath + "\n" + ex.getMessage());
        } catch (FileNotFoundException ex) {
            System.err.println("HsXlsReaderFile.readXlsFile: FileNotFoundException " + filePath + "\n" + ex.getMessage());
        } catch (IOException ex) {
            System.err.println("HsXlsReaderFile.readXlsFile: IOException " + filePath + "\n" + ex.getMessage());
        } catch (EncryptedDocumentException ex){
            System.err.println("HsXlsReaderFile.readXlsFile: EncryptedDocumentException " + filePath + "\n" + ex.getMessage());
        } catch (RuntimeException ex){
            System.err.println("HsXlsReaderFile.readXlsFile: RuntimeException " + filePath + "\n" + ex.getMessage());
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (workbook != null) {
                    workbook.close();
                }
            } catch (IOException ex) {
                System.err.println("HsXlsReaderFile.readXlsFile: IOException " + filePath + "\n" + ex.getMessage());
            }
        }
        return strBuilder.toString();
    }
}
