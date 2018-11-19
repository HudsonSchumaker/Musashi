package de.com.schumaker.core.entity;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author hudsonschumaker
 */

@Getter
@Setter
public class HsRecordFile {
    
    private Long   id;
    private String name;
    private String ext;
    private String path;
    private String content;
    
    public HsRecordFile(){
    }
    
    public HsRecordFile(Long id){
       this.id = id;
    }

    public HsRecordFile(String name, String ext, String path, String content) {
        this.name = name;
        this.ext = ext;
        this.path = path;
        this.content = content;
    }
}
