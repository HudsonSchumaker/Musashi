package de.com.schumaker.core.reader.impl;

import de.com.schumaker.core.reader.HsReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ooxml.POIXMLProperties;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFShape;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFTextShape;

/**
 *
 * @author hudson schumaker
 */
public class HsPptxReaderFile implements HsReader{

    @Override
    public String read(Path arq) {
        return readPptxFile(arq.normalize().toString());
    }
    
    private String readPptxFile(String filePath){
        StringBuilder strBuilder = new StringBuilder();
        File file = new File(filePath);
        FileInputStream fis = null;
        XMLSlideShow pptx = null;
        try {
            fis = new FileInputStream(file.getAbsolutePath());
            pptx = new XMLSlideShow(fis);

            POIXMLProperties.CoreProperties props = pptx.getProperties().getCoreProperties();
            strBuilder.append(props.getTitle().trim());

            for (XSLFSlide slide : pptx.getSlides()) {
                List<XSLFShape> shapes = slide.getShapes();
                for (XSLFShape shape : shapes) {
                    if (shape instanceof XSLFTextShape) {
                        XSLFTextShape textShape = (XSLFTextShape) shape;
                        strBuilder.append(textShape.getText().trim());
                    }
                }
            }
        } catch (IllegalArgumentException ex) {
            System.err.println("HsPptxReaderFile.readPptxFile: IllegalArgumentException " + filePath + "\n" + ex.getMessage());
        } catch (FileNotFoundException ex) {
            System.err.println("HsPptxReaderFile.readPptxFile: FileNotFoundException " + filePath + "\n" + ex.getMessage());
        } catch (IOException ex) {
            System.err.println("HsPptxReaderFile.readPptxFile: IOException " + filePath + "\n" + ex.getMessage());
        } catch (EncryptedDocumentException ex){
            System.err.println("HsPptxReaderFile.readPptxFile: EncryptedDocumentException " + filePath + "\n" + ex.getMessage());
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (pptx != null) {
                    pptx.close();
                }
            } catch (IOException ex) {
                System.err.println("HsPptxReaderFile.readPptxFile: IOException " + filePath + "\n" + ex.getMessage());
            }
        }
        return strBuilder.toString();
    }
}
