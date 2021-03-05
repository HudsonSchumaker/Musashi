package br.com.schumaker.musashi.crawler.model.readers.impl;

import br.com.schumaker.musashi.crawler.model.readers.MsReader;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

/**
 *
 * @author Hudson Schumaker
 */
@Component
public class MsDocxReaderFile implements MsReader {

    @Override
    public String read(String filePath) {
        return readDocFile(filePath);
    }

    private String readDocFile(String filePath) {
        StringBuilder strBuilder = new StringBuilder();
        File file = new File(filePath);
        FileInputStream fis = null;
        XWPFDocument doc = null;
        try {
            fis = new FileInputStream(file.getAbsolutePath());
            doc = new XWPFDocument(fis);
            List<XWPFParagraph> paragraphs = doc.getParagraphs();
            for (XWPFParagraph para : paragraphs) {
                if (para.getText().trim().length() > 10) {
                    strBuilder.append(para.getText().trim());
                }
            }
        } catch (Exception ex) {
            System.err.println("HsDocxReaderFile.readDocxFile: Exception " + filePath + "\n" + ex.getMessage());
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (doc != null) {
                    doc.close();
                }
            } catch (Exception ex) {
                System.err.println("HsDocxReaderFile.readDocxFile: Exception " + filePath + "\n" + ex.getMessage());
            }
        }
        return strBuilder.toString();
    }
}
