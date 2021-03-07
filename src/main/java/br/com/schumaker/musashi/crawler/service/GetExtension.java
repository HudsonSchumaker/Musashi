package br.com.schumaker.musashi.crawler.service;

import java.io.File;

/**
 *
 * @author Hudson Schumaker
 */
public class GetExtension {
    public static String getExt(String path) {
        File f = new File(path);
        String extension = "";
        String fileName = f.getName();
        String []extensions = fileName.split("\\.");
        int i = extensions.length;
        if (i > 1) {
            extension = extensions[i - 1];
        }
        return extension;
    }

    public static String getExt(File f) {
        String extension = "";
        String fileName = f.getName();
        String []extensions = fileName.split("\\.");
        int i = extensions.length;
        if (i > 1) {
            extension = extensions[i - 1];
        }
        return extension;
    }
}
