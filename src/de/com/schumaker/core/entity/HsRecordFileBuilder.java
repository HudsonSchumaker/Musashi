package de.com.schumaker.core.entity;

import de.com.schumaker.core.util.HsUtil;
import java.nio.file.Path;
import org.bson.Document;
/**
 *
 * @author hudson schumaker
 */
public class HsRecordFileBuilder {
    
    private String name;
    private String ext;
    private String path;
    private String content;
    private String size;
    private String date;
    
    public Document build(){
       
        return new Document()
                .append("Name", name)
                .append("Extension", ext)
                .append("Path", path)
                .append("Content", content)
                .append("Size", size)
                .append("Date", date);
    }
        
    public HsRecordFileBuilder withName(String name){
       this.name = name;
       return this;
    }
   
    public HsRecordFileBuilder withExt(String ext){
       this.ext = ext;
       return this;
    }
   
    public HsRecordFileBuilder withPath(Path path){
       this.path = path.normalize().toString();
       this.size = HsUtil.formatSize(path.toFile().length());
       this.date = HsUtil.formatFileLastModified(path.toFile().lastModified());
       return this;
    }
   
    public HsRecordFileBuilder withContent(String content){
       this.content = content;
       return this;
    }
}
