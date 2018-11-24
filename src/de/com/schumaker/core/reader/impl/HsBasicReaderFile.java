package de.com.schumaker.core.reader.impl;

import de.com.schumaker.core.reader.HsReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 *
 * @author hudson schumaker
 */
public class HsBasicReaderFile implements HsReader{

    @Override
    public String read(Path arq) {
        byte [] buffer = null;
        try {
            buffer = Files.readAllBytes(arq);
        } catch (IOException | RuntimeException e) {
            System.err.println(e);
        }
        return new String(buffer);
    }
}
