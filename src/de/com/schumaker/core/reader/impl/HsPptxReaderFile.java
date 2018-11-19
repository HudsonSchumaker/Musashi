package de.com.schumaker.core.reader.impl;

import de.com.schumaker.core.reader.HsReader;
import java.io.File;
import java.nio.file.Path;

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
        File file = new File(filePath);
        String content = "";
        //TODO implementação
        return content;
    }
}
