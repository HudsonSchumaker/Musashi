package de.com.schumaker.core.files.impl;

import java.nio.file.Path;
import de.com.schumaker.core.files.HsFile;
import de.com.schumaker.core.reader.impl.HsBasicReaderFile;
import de.com.schumaker.core.service.HsReadableService;
import de.com.schumaker.core.files.HsReadable;

/**
 *
 * @author hudson schumaker
 */
public class HsCpp extends HsFile implements HsReadable {
    
    public HsCpp(){
    }
    
    public HsCpp(String path){
        super(path);
    }
    
    public HsCpp (String path, String name, String ext){
       super(path, name, ext);
    }
    
    @Override
    public void process() {
        super.setContent(read());
        new HsReadableService().persistRecord(this);
    }
    
    @Override
    public String  read() {
        return new HsBasicReaderFile().read(getPath());
    }
    
    @Override
    public Path getPath() {
        return super.getPath();
    }

    @Override
    public HsReadable newOne(String path, String name, String ext) {
        return new HsCpp(path, name, ext);
    }
}