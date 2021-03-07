package br.com.schumaker.musashi.search.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MsFileDTO {

    private String name;
    private String ext;
    private String path;
    private String content;
}
