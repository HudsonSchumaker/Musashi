package br.com.schumaker.musashi.crawler.model.readers.impl;

import br.com.schumaker.musashi.crawler.model.readers.MsFileCommons;
import br.com.schumaker.musashi.crawler.model.readers.MsReader;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.text.DefaultEditorKit;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author Hudson Schumaker
 */
@Component
public class MsHtmlReaderFile implements MsReader {

    @Override
    public String read(String filePath) {
        return readXHtmlFile(filePath).trim();
    }

    private String readXHtmlFile(String filePath) {
        File file = new File(filePath);
        String content = "";
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            int len = fis.available() < MsFileCommons.READ_SIZE ? fis.available() : MsFileCommons.READ_SIZE;
            byte[] buffer = new byte[len];
            fis.read(buffer, 0, len);
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
