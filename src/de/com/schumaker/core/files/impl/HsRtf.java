package de.com.schumaker.core.files.impl;

import de.com.schumaker.core.files.HsFile;
import de.com.schumaker.core.service.HsReadableService;
import java.nio.file.Path;
import de.com.schumaker.core.files.HsReadable;
import de.com.schumaker.core.reader.impl.HsRtfReaderFile;

/**
 *
 * @author hudson schumaker
 */
public class HsRtf extends HsFile implements HsReadable {
    
    public HsRtf(){
    }
    
    public HsRtf(String path){
        super.setPath(path);
    }
    
    public HsRtf (String path, String name, String ext){
       super(path, name, ext);
    }
    
    @Override
    public void process() {
        super.setContent(read());
        new HsReadableService().persistRecord(this);
    }
    
    @Override
    public String read() {
        return new HsRtfReaderFile().read(getPath());
    }
    
    @Override
    public Path getPath() {
        return super.getPath();
    }

    @Override
    public HsReadable newOne(String path, String name, String ext) {
        return new HsRtf(path, name, ext);
    }
}