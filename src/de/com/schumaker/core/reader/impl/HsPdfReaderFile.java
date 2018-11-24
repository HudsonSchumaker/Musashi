package de.com.schumaker.core.reader.impl;

import de.com.schumaker.core.reader.HsReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

/**
 *
 * @author hudson schumaker
 */
public class HsPdfReaderFile implements HsReader{

    @Override
    public String read(Path arq) {
        return readPdfFile(arq.normalize().toString());
    }
    
    private String readPdfFile(String filePath){
        String content = "";
        PDDocument document = null;
        try {
            document = PDDocument.load(filePath);
            if (!document.isEncrypted()) {
                PDFTextStripper Tstripper = new PDFTextStripper();
                content = Tstripper.getText(document);
                Tstripper = null; // Não remover
            }
        } catch (IOException ex) {
            System.err.println("HsPdfReaderFile.readPdfFile: IOException " + ex.getMessage());
        } catch (RuntimeException ex){
            System.err.println("HsPdfReaderFile.readPdfFile: RuntimeException " + filePath + "\n" + ex.getMessage());
        } finally {
            try {
                if (document != null) {
                    document.close();
                }
            } catch (IOException ex) {
                System.err.println("readerPdfFile::HsReadPdfFile: " + ex.getMessage());
            }
        }
        return content;
    }
}
