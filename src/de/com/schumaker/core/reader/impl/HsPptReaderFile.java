package de.com.schumaker.core.reader.impl;

import de.com.schumaker.core.reader.HsReader;
import java.io.File;
import java.nio.file.Path;

/**
 *
 * @author hudson schumaker
 */
public class HsPptReaderFile implements HsReader{

    @Override
    public String read(Path arq) {
        return readPptFile(arq.normalize().toString());
    }
    
    private String readPptFile(String filePath){
        File file = new File(filePath);
        String content = "";
        //TODO implementação
        return content;
    }
}
