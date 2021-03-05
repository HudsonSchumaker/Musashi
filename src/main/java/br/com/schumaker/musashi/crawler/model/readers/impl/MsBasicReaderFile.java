package br.com.schumaker.musashi.crawler.model.readers.impl;

import br.com.schumaker.musashi.crawler.model.readers.MsReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 *
 * @author Hudson Schumaker
 */
public class MsBasicReaderFile implements MsReader {

    @Override
    public String read(String filePath) {
        byte [] buffer = null;
        try {
            buffer = Files.readAllBytes(Path.of(filePath));
        } catch (IOException | RuntimeException e) {
            System.err.println(e);
        }
        return new String(buffer);
    }
}
