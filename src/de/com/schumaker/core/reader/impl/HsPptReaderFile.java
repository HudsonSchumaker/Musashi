package de.com.schumaker.core.reader.impl;

import de.com.schumaker.core.reader.HsReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hslf.extractor.PowerPointExtractor;

/**
 *
 * @author hudson schumaker
 */
public class HsPptReaderFile implements HsReader{

    @Override
    public String read(Path arq) {
        return readPptFile(arq.normalize().toString());
    }
    
    private String readPptFile(String filePath){
        StringBuilder strBuilder = new StringBuilder();
        File file = new File(filePath);
        FileInputStream fis = null;
        PowerPointExtractor extractor = null;
        try {
            fis = new FileInputStream(file.getAbsolutePath());
            extractor = new PowerPointExtractor(fis);
            strBuilder.append(extractor.getText().trim());
        } catch (IllegalArgumentException ex) {
            System.err.println("HsPptReaderFile.readPptFile: IllegalArgumentException " + filePath + "\n" + ex.getMessage());
        } catch (FileNotFoundException ex) {
            System.err.println("HsPptReaderFile.readPptFile: FileNotFoundException " + filePath + "\n" + ex.getMessage());
        } catch (IOException ex) {
            System.err.println("HsPptReaderFile.readPptFile: IOException " + filePath + "\n" + ex.getMessage());
        } catch (EncryptedDocumentException ex){
            System.err.println("HsPptReaderFile.readPptFile: EncryptedDocumentException " + filePath + "\n" + ex.getMessage());
        } catch (RuntimeException ex){
            System.err.println("HsPptReaderFile.readPptFile: RuntimeException " + filePath + "\n" + ex.getMessage());
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (extractor != null) {
                    extractor.close();
                }
            } catch (IOException ex) {
                System.err.println("HsPptReaderFile.readPptFile: IOException " + filePath + "\n" + ex.getMessage());
            }
        }
        return strBuilder.toString();
    }
}