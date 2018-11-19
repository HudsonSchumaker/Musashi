package de.com.schumaker.core.files;

import java.nio.file.Path;
import java.nio.file.Paths;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author hudsonschumaker
 */
@Getter
@Setter
public abstract class HsFile {
    private String name;
    private String ext;
    private Path path;
    private String content;
    
    public HsFile(){
    }
    
    public HsFile(String path){
        this.path = Paths.get(path);
    }
    
    public HsFile(String path, String name, String ext){
        this.path = Paths.get(path);
        this.name = name;
        this.ext  = ext;
    }

    public void setPath(String path) {
        this.path = Paths.get(path);
    }
}