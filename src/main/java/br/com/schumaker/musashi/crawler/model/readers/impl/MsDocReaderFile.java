package br.com.schumaker.musashi.crawler.model.readers.impl;

import br.com.schumaker.musashi.crawler.model.readers.MsReader;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author Hudson Schumaker
 */
@Component
public class MsDocReaderFile implements MsReader {

    @Override
    public String read(String filePath) {
        return readDocFile(filePath);
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
        } catch (Exception ex) {
            System.err.println("HsDocReaderFile.readDocFile: Exception " + filePath + "\n" + ex.getMessage());
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
                System.err.println("HsDocReaderFile.readDocFile: Exception " + filePath + "\n" + ex.getMessage());
            }
        }
        return strBuilder.toString();
    }
}
