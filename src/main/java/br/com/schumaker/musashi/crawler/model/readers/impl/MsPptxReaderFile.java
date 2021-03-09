package br.com.schumaker.musashi.crawler.model.readers.impl;

import br.com.schumaker.musashi.crawler.model.readers.MsReader;
import org.apache.poi.ooxml.POIXMLProperties;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFShape;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFTextShape;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

/**
 *
 * @author Hudson Schumaker
 */
@Component
public class MsPptxReaderFile implements MsReader {

    @Override
    public String read(String filePath) {
        return readPptxFile(filePath);
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
        } catch (Exception ex) {
            System.err.println("HsPptxReaderFile.readPptxFile: Exception " + filePath + "\n" + ex.getMessage());
        }finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (pptx != null) {
                    pptx.close();
                }
            } catch (Exception ex) {
                System.err.println("HsPptxReaderFile.readPptxFile: Exception " + filePath + "\n" + ex.getMessage());
            }
        }
        return strBuilder.toString().trim();
    }
}
