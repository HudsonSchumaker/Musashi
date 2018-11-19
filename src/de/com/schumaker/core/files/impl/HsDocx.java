package de.com.schumaker.core.files.impl;

import java.nio.file.Path;
import de.com.schumaker.core.files.HsFile;
import de.com.schumaker.core.service.HsReadableService;
import de.com.schumaker.core.files.HsReadable;
import de.com.schumaker.core.reader.impl.HsDocxReaderFile;

/**
 *
 * @author hudson schumaker
 */
public class HsDocx extends HsFile implements HsReadable {
    
    public HsDocx(){
    }
    
    public HsDocx(String path){
        super.setPath(path);
    }
    
    public HsDocx (String path, String name, String ext){
       super(path, name, ext);
    }
    
    @Override
    public void process() {
        super.setContent(read());
        new HsReadableService().persistRecord(this);
    }
    
    @Override
    public String read() {
        return new HsDocxReaderFile().read(getPath());
    }
    
    @Override
    public Path getPath() {
        return super.getPath();
    }

    @Override
    public HsReadable newOne(String path, String name, String ext) {
        return new HsDocx(path, name, ext);
    }
}