package br.com.schumaker.musashi.crawler.model.files;

import br.com.schumaker.musashi.crawler.model.MsFile;
import br.com.schumaker.musashi.crawler.model.MsReadable;
import br.com.schumaker.musashi.crawler.model.readers.impl.MsPdfReaderFile;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Hudson Schumaker
 */
public class MsPdf extends MsFile implements MsReadable {

    @Autowired
    private MsPdfReaderFile reader;

    public MsPdf() {}

    private MsPdf(String path, String name, String ext) {
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
        return new MsPdf(path, name, ext);
    }
}
