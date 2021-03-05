package br.com.schumaker.musashi.crawler.model;

/**
 *
 * @author Hudson Schumaker
 */
public interface MsReadable {
    void process();
    String read();
    MsReadable newOne(String path, String name, String ext);
}
