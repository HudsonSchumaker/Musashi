package de.com.schumaker.core.reader.impl;

import de.com.schumaker.core.reader.HsReader;
import java.io.File;
import java.nio.file.Path;

/**
 *
 * @author hudson schumaker
 */
public class HsXlsxReaderFile implements HsReader{

    @Override
    public String read(Path arq) {
        return readXlsxFile(arq.normalize().toString());
    }
    
    private String readXlsxFile(String filePath){
        File file = new File(filePath);
        String content = "";
        //TODO implementação
        return content;
    }
}
