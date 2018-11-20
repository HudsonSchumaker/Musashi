package de.com.schumaker.core.reader.impl;

import de.com.schumaker.core.reader.HsReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

/**
 *
 * @author hudson schumaker
 */
public class HsDocxReaderFile implements HsReader {

    @Override
    public String read(Path arq) {
        return readDocxFile(arq.normalize().toString());
    }

    private String readDocxFile(String filePath) {
        File file = new File(filePath);
        StringBuilder strBuilder = new StringBuilder();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file.getAbsolutePath());
            XWPFDocument document = new XWPFDocument(fis);
            List<XWPFParagraph> paragraphs = document.getParagraphs();
            //List<XWPFParagraph> paragraphs = Arrays.asList(document.getParagraphs());
            for (XWPFParagraph para : paragraphs) {
                if (para.getText().trim().length() > 10) {
                    strBuilder.append(para.getText().trim());
                }
            }
        } catch (IOException ex) {
            System.err.println("readWordFile::HsDocxFile: " + ex.getMessage());
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException ex) {
                System.err.println("readWordFile::HsDocxFile: " + ex.getMessage());
            }
        }
        file = null;
        String content = strBuilder.toString();
        return content;
    }
}
