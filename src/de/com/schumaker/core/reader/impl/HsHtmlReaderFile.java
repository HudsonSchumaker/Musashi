package de.com.schumaker.core.reader.impl;

import de.com.schumaker.core.reader.HsReader;
import de.com.schumaker.core.util.HsFileCommons;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import javax.swing.Action;
import javax.swing.text.DefaultEditorKit;

/**
 *
 * @author hudson schumaker
 */
public class HsHtmlReaderFile implements HsReader{

    @Override
    public String read(Path arq) {
        return readXHtmlFile(arq.normalize().toString());
    }
    
    private String readXHtmlFile(String filePath){
        File file = new File(filePath);
        String content = "";
        FileInputStream fis = null;
        int i = 0;
        try {
            fis = new FileInputStream(file);
            int len = fis.available() < HsFileCommons.READ_SIZE ? fis.available() : HsFileCommons.READ_SIZE;
            byte[] buffer = new byte[len];
            i = fis.read(buffer, 0, len);
            String aux = new String(buffer);
            javax.swing.JEditorPane taText = new javax.swing.JEditorPane();

            // remove beep ------------------------------------------------------
            Action action = taText.getActionMap().get(DefaultEditorKit.insertContentAction);
            action.setEnabled(false);
            //  ------------------------------------------------------------------
            taText.setContentType("text/html");
            taText.setText(aux.trim());
            taText.selectAll();
            content = taText.getSelectedText();
            if (content == null) {
                content = "";
            }
            content = content.trim();
        } catch (IOException | RuntimeException ex) {
            System.err.println("readFile::HsReadFile: " + ex.getMessage());
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException ex) {
                System.err.println("readFile::HsReadFile: " + ex.getMessage());
            }
        }
        return content;
    }
}
