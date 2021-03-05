package br.com.schumaker.musashi.crawler.model.files;

import br.com.schumaker.musashi.crawler.model.MsFile;
import br.com.schumaker.musashi.crawler.model.MsReadable;
import br.com.schumaker.musashi.crawler.model.readers.impl.MsXlsxReaderFile;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Hudson Schumaker
 */
public class MsXlsx extends MsFile implements MsReadable {

    @Autowired
    private MsXlsxReaderFile reader;

    public MsXlsx() {}

    private MsXlsx(String path, String name, String ext) {
        super(path, name, ext);
    }

    @Override
    public void process() {
        super.setContent(read());
    }

    @Override
    public String read() {
        return reader.read(getPath());
    }

    @Override
    public MsReadable newOne(String path, String name, String ext) {
        return new MsXlsx(path, name, ext);
    }
}
