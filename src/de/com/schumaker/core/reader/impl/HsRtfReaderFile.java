package de.com.schumaker.core.reader.impl;

import de.com.schumaker.core.reader.HsReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.rtf.RTFEditorKit;

/**
 *
 * @author hudson schumaker
 */
public class HsRtfReaderFile implements HsReader{

    @Override
    public String read(Path arq) {
        return readRtfFile(arq.normalize().toString());
    }
    
    private String readRtfFile(String filePath){
        File file = new File(filePath);
        StringBuilder strBuilder = new StringBuilder();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file.getAbsolutePath());
            RTFEditorKit kit = new RTFEditorKit();
            Document doc = kit.createDefaultDocument();
            kit.read(fis, doc, 0);
            strBuilder.append(doc.getText(0, doc.getLength()));
        } catch (FileNotFoundException ex) {
            System.err.println("readRtfFile::HsReaderRtf: " + ex.getMessage());
        } catch ( IOException | BadLocationException ex) {
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
        String aux = strBuilder.toString();
        return aux;
    }
}
