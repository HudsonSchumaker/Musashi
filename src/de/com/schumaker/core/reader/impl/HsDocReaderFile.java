package de.com.schumaker.core.reader.impl;

import de.com.schumaker.core.reader.HsReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;

/**
 *
 * @author hudson schumaker
 */
public class HsDocReaderFile implements HsReader {

    @Override
    public String read(Path arq) {
        return readDocFile(arq.normalize().toString());
    }

    private String readDocFile(String filePath) {
        StringBuilder strBuilder = new StringBuilder();
        File file = new File(filePath);
        FileInputStream fis = null;
        HWPFDocument doc = null;
        WordExtractor extractor = null;
        try {
            fis = new FileInputStream(file.getAbsolutePath());
            doc = new HWPFDocument(fis);
            extractor = new WordExtractor(doc);
            for (String rawText : extractor.getParagraphText()) {
                String text = WordExtractor.stripFields(rawText);
                if (text.length() > 10) {
                    strBuilder.append(text.trim());
                }
            }
        } catch (IOException ex) { 
            System.err.println("HsDocReaderFile.readDocFile: IOException " + filePath + "\n" + ex.getMessage());
        } catch (IllegalArgumentException ex) {
            System.err.println("HsDocReaderFile.readDocFile: IllegalArgumentException " + filePath + "\n" + ex.getMessage());
        } catch (EncryptedDocumentException ex){
            System.err.println("HsDocReaderFile.readDocFile: EncryptedDocumentException " + filePath + "\n" + ex.getMessage());
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (doc != null) {
                    doc.close();
                }
                if (extractor != null) {
                    extractor.close();
                }
            } catch (IOException ex) {
                System.err.println("HsDocReaderFile.readDocFile: IOException " + filePath + "\n" + ex.getMessage());
            }
        }
        return strBuilder.toString();
    }
}
