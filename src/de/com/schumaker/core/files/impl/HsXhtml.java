package de.com.schumaker.core.files.impl;

import java.nio.file.Path;
import de.com.schumaker.core.files.HsFile;
import de.com.schumaker.core.service.HsReadableService;
import de.com.schumaker.core.files.HsReadable;
import de.com.schumaker.core.reader.impl.HsXHtmlReaderFile;

/**
 *
 * @author hudson schumaker
 */
public class HsXhtml extends HsFile implements HsReadable {
    
    public HsXhtml(){
    }
    
    public HsXhtml(String path){
        super.setPath(path);
    }
    
    public HsXhtml (String path, String name, String ext){
       super(path, name, ext);
    }
    
    @Override
    public void process() {
        super.setContent(read());
        new HsReadableService().persistRecord(this);
    }
    
    @Override
    public String read() {
        return new HsXHtmlReaderFile().read(getPath());
    }
    
    @Override
    public Path getPath() {
        return super.getPath();
    }

    @Override
    public HsReadable newOne(String path, String name, String ext) {
        return new HsXhtml(path, name, ext);
    }
}