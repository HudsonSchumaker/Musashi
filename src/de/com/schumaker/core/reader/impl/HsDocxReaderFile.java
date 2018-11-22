package de.com.schumaker.core.reader.impl;

import de.com.schumaker.core.reader.HsReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.nio.file.Path;
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
        } catch (IOException ex) { 
            System.err.println("HsDocxReaderFile.readDocxFile: IOException " + filePath + "\n" + ex.getMessage());
        } catch (IllegalArgumentException ex) {
            System.err.println("HsDocxReaderFile.readDocxFile: IllegalArgumentException " + filePath + "\n" + ex.getMessage());
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (doc != null) {
                    doc.close();
                }
            } catch (IOException ex) {
                System.err.println("HsDocxReaderFile.readDocxFile: IOException " + filePath + "\n" + ex.getMessage());
            }
        }
        return strBuilder.toString();
    }
}