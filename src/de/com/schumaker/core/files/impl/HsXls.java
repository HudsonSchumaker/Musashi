package de.com.schumaker.core.files.impl;

import java.nio.file.Path;
import de.com.schumaker.core.files.HsFile;
import de.com.schumaker.core.service.HsReadableService;
import de.com.schumaker.core.files.HsReadable;
import de.com.schumaker.core.reader.impl.HsXlsReaderFile;

/**
 *
 * @author hudson schumaker
 */
public class HsXls extends HsFile implements HsReadable {
    
    public HsXls(){
    }
    
    public HsXls(String path){
        super.setPath(path);
    }
    
    public HsXls (String path, String name, String ext){
       super(path, name, ext);
    }
    
    @Override
    public void process() {
        super.setContent(read());
        new HsReadableService().persistRecord(this);
    }
    
    @Override
    public String read() {
        return new HsXlsReaderFile().read(getPath());
    }
    
    @Override
    public Path getPath() {
        return super.getPath();
    }

    @Override
    public HsReadable newOne(String path, String name, String ext) {
        return new HsXls(path, name, ext);
    }
}