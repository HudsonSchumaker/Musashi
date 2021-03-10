package br.com.schumaker.musashi.search.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Hudson Schumaker
 */
@Data
@NoArgsConstructor
public class MsFileDTO {

    private String name;
    private String ext;
    private String path;
    private String content;
}
