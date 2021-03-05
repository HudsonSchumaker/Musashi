package br.com.schumaker.musashi.crawler.model.readers.impl;

import br.com.schumaker.musashi.crawler.model.readers.MsReader;
import org.apache.poi.hslf.extractor.QuickButCruddyTextExtractor;

import java.io.File;
import java.io.FileInputStream;

public class MsPptReaderFile implements MsReader{

    @Override
    public String read(String filePath) {
        return readPptFile(filePath);
    }

    private String readPptFile(String filePath){
        StringBuilder strBuilder = new StringBuilder();
        File file = new File(filePath);
        FileInputStream fis = null;
        QuickButCruddyTextExtractor extractor = null;
        try {
            fis = new FileInputStream(file.getAbsolutePath());
            extractor = new QuickButCruddyTextExtractor(fis);
            strBuilder.append(extractor.getTextAsString().trim());
        } catch (Exception ex) {
            System.err.println("HsPptReaderFile.readPptFile: Exception " + filePath + "\n" + ex.getMessage());
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (extractor != null) {
                    extractor.close();
                }
            } catch (Exception ex) {
                System.err.println("HsPptReaderFile.readPptFile: Exception " + filePath + "\n" + ex.getMessage());
            }
        }
        return strBuilder.toString();
    }
}
