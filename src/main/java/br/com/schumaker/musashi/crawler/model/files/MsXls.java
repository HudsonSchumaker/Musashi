package br.com.schumaker.musashi.crawler.model.files;

import br.com.schumaker.musashi.crawler.model.MsFile;
import br.com.schumaker.musashi.crawler.model.MsReadable;
import br.com.schumaker.musashi.crawler.model.readers.impl.MsXlsReaderFile;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Hudson Schumaker
 */
public class MsXls extends MsFile implements MsReadable {

    @Autowired
    private MsXlsReaderFile reader;

    public MsXls() {}

    private MsXls(String path, String name, String ext) {
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
        return new MsXls(path, name, ext);
    }
}
