package br.com.schumaker.musashi.crawler.model;

/**
 *
 * @author Hudson Schumaker
 */
public interface MsReadable {
    MsFile process();
    String read();
    MsReadable newOne(String path, String name, String ext);
}
