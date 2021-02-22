package de.com.schumaker.core.files;

import java.nio.file.Path;

/**
 *
 * @author Hudson Schumaker
 */
public interface HsReadable { 
    void process();
    String read();
    Path getPath();
    HsReadable newOne(String path, String name, String ext);
}
