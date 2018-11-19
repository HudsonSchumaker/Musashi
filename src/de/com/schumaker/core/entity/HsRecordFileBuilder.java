package de.com.schumaker.core.entity;

/**
 *
 * @author hudson schumaker
 */
public class HsRecordFileBuilder {
    
    private String name;
    private String ext;
    private String path;
    private String content;
    
    public HsRecordFile build(){
        return new HsRecordFile(name, ext, path, content);
    }
        
    public HsRecordFileBuilder withName(String name){
       this.name = name;
       return this;
    }
   
    public HsRecordFileBuilder withExt(String ext){
       this.ext = ext;
       return this;
    }
   
    public HsRecordFileBuilder withPath(String path){
       this.path = path;
       return this;
    }
   
    public HsRecordFileBuilder withContent(String content){
       this.content = content;
       return this;
    }
}
