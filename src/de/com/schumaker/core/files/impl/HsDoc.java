package de.com.schumaker.core.files.impl;

import java.nio.file.Path;
import de.com.schumaker.core.files.HsFile;
import de.com.schumaker.core.service.HsReadableService;
import de.com.schumaker.core.files.HsReadable;
import de.com.schumaker.core.reader.impl.HsDocReaderFile;

/**
 *
 * @author Hudson Schumaker
 */
public class HsDoc extends HsFile implements HsReadable {
    
    public HsDoc(){
    }
    
    public HsDoc(String path){
        super.setPath(path);
    }
    
    public HsDoc (String path, String name, String ext){
       super(path, name, ext);
    }
    
    @Override
    public void process() {
        super.setContent(read());
        new HsReadableService().persistRecord(this);
    }
    
    @Override
    public String read() {
        return new HsDocReaderFile().read(getPath());
    }
    
    @Override
    public Path getPath() {
        return super.getPath();
    }

    @Override
    public HsReadable newOne(String path, String name, String ext) {
        return new HsDoc(path, name, ext);
    }
}
