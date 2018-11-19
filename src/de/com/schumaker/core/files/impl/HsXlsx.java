package de.com.schumaker.core.files.impl;

import java.nio.file.Path;
import de.com.schumaker.core.files.HsFile;
import de.com.schumaker.core.service.HsReadableService;
import de.com.schumaker.core.files.HsReadable;
import de.com.schumaker.core.reader.impl.HsXlsxReaderFile;

/**
 *
 * @author hudson schumaker
 */
public class HsXlsx extends HsFile implements HsReadable {
    
    public HsXlsx(){
    }
    
    public HsXlsx(String path){
        super.setPath(path);
    }
    
    public HsXlsx (String path, String name, String ext){
       super(path, name, ext);
    }
    
    @Override
    public void process() {
        super.setContent(read());
        new HsReadableService().persistRecord(this);
    }
    
    @Override
    public String read() {
        return new HsXlsxReaderFile().read(getPath());
    }
    
    @Override
    public Path getPath() {
        return super.getPath();
    }

    @Override
    public HsReadable newOne(String path, String name, String ext) {
        return new HsXlsx(path, name, ext);
    }
}