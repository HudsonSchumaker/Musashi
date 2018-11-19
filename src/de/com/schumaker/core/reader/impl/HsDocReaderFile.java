package de.com.schumaker.core.reader.impl;

import de.com.schumaker.core.reader.HsReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;


/**
 *
 * @author hudson schumaker
 */
public class HsDocReaderFile implements HsReader{

    @Override
    public String read(Path arq) {
        return readDocFile(arq.normalize().toString());
    }
    
    private String readDocFile(String filePath){
        File file = new File(filePath);
        StringBuilder strBuilder = new StringBuilder();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file.getAbsolutePath());
            HWPFDocument doc = new HWPFDocument(fis);
            WordExtractor extractor = new WordExtractor(doc);
            for (String rawText : extractor.getParagraphText()) {
                String text = WordExtractor.stripFields(rawText);
                if (text.length() > 10) {
                    strBuilder.append(text.trim());
                }
            }
        } catch (IOException ex) {
            System.err.println("readWordFile::HsDocFile: " + ex.getMessage());
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException ex) {
                System.err.println("readWordFile::HsDocFile: " + ex.getMessage());
            }
        }
        file = null;
        String content = strBuilder.toString();
        return content;
    }
}
