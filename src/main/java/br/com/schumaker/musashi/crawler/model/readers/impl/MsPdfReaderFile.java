package br.com.schumaker.musashi.crawler.model.readers.impl;

import br.com.schumaker.musashi.crawler.model.readers.MsReader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 *
 * @author Hudson Schumaker
 */
@Component
public class MsPdfReaderFile implements MsReader {

    @Override
    public String read(String filePath) {
        return readPdfFile(filePath);
    }

    private String readPdfFile(String filePath) {
        String content = "";
        PDDocument document = null;
        try {
            document = PDDocument.load(new File(filePath));
            if (!document.isEncrypted()) {
                PDFTextStripper stripper = new PDFTextStripper();
                content = stripper.getText(document);
                stripper = null;
            }
        } catch (Exception ex) {
            System.err.println("HsPdfReaderFile.readPdfFile: Exception " + ex.getMessage());
        } finally {
            try {
                if (document != null) {
                    document.close();
                }
            } catch (Exception ex) {
                System.err.println("readerPdfFile::HsReadPdfFile: " + ex.getMessage());
            }
        }
        return content;
    }
}
