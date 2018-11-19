package de.com.schumaker.core.files.impl;

import de.com.schumaker.core.files.HsFile;
import de.com.schumaker.core.reader.impl.HsBasicReaderFile;
import de.com.schumaker.core.service.HsReadableService;
import java.nio.file.Path;
import de.com.schumaker.core.files.HsReadable;

/**
 *
 * @author hudson schumaker
 */
public class HsHtml extends HsFile implements HsReadable {
    
    public HsHtml(){
    }
    
    public HsHtml(String path){
        super.setPath(path);
    }
    
    public HsHtml (String path, String name, String ext){
       super(path, name, ext);
    }
    
    @Override
    public void process() {
        super.setContent(read());
        new HsReadableService().persistRecord(this);
    }
    
    @Override
    public String read() {
        return new HsBasicReaderFile().read(getPath());
    }
    
    @Override
    public Path getPath() {
        return super.getPath();
    }

    @Override
    public HsReadable newOne(String path, String name, String ext) {
        return new HsHtml(path, name, ext);
    }
}