package br.com.schumaker.musashi.crawler.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 *
 * @author Hudson Schumaker
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class MsFile {

    private String name;
    private String ext;
    private String path;
    private String content;

    public MsFile(String path, String name, String ext) {
        this.path = path;
        this.name = name;
        this.ext  = ext;
    }
}
