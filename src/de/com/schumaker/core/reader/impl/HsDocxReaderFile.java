package de.com.schumaker.core.reader.impl;

import de.com.schumaker.core.reader.HsReader;
import java.io.File;

import java.nio.file.Path;

/**
 *
 * @author hudson schumaker
 */
public class HsDocxReaderFile implements HsReader {

    @Override
    public String read(Path arq) {
        return readDocxFile(arq.normalize().toString());
    }

    private String readDocxFile(String filePath) {
        File file = new File(filePath);
        String content = "";
        //TODO implementação
        return content;
    }
}
