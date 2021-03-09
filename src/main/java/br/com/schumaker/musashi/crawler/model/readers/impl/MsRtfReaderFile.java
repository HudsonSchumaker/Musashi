package br.com.schumaker.musashi.crawler.model.readers.impl;

import br.com.schumaker.musashi.crawler.model.readers.MsReader;
import org.springframework.stereotype.Component;

import javax.swing.text.Document;
import javax.swing.text.rtf.RTFEditorKit;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author Hudson Schumaker
 */
@Component
public class MsRtfReaderFile implements MsReader {

    @Override
    public String read(String filePath) {
        return readRtfFile(filePath);
    }

    private String readRtfFile(String filePath) {
        File file = new File(filePath);
        StringBuilder strBuilder = new StringBuilder();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file.getAbsolutePath());
            RTFEditorKit kit = new RTFEditorKit();
            Document doc = kit.createDefaultDocument();
            kit.read(fis, doc, 0);
            strBuilder.append(doc.getText(0, doc.getLength()));
        } catch (Exception ex) {
            System.err.println("readRtfFile::HsReaderRtf: " + ex.getMessage());
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException ex) {
                System.err.println("readRtfFile::HsReaderRtf: " + ex.getMessage());
            }
        }
        return strBuilder.toString().trim();
    }
}
