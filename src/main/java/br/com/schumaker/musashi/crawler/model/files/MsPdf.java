package br.com.schumaker.musashi.crawler.model.files;

import br.com.schumaker.musashi.crawler.model.MsFile;
import br.com.schumaker.musashi.crawler.model.MsReadable;
import br.com.schumaker.musashi.crawler.model.readers.impl.MsPdfReaderFile;

/**
 *
 * @author Hudson Schumaker
 */
public class MsPdf extends MsFile implements MsReadable {

    public MsPdf() {}

    private MsPdf(String path, String name, String ext) {
        super(path, name, ext);
    }

    @Override
    public MsFile process() {
        super.setContent(read());
        return this;
    }

    @Override
    public String read() {
        return new MsPdfReaderFile().read(getPath());
    }

    @Override
    public MsReadable newOne(String path, String name, String ext) {
        return new MsPdf(path, name, ext);
    }
}
