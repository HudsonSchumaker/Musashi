package br.com.schumaker.musashi.crawler.model.files;

import br.com.schumaker.musashi.crawler.model.MsFile;
import br.com.schumaker.musashi.crawler.model.MsReadable;
import br.com.schumaker.musashi.crawler.model.readers.impl.MsRtfReaderFile;

/**
 *
 * @author Hudson Schumaker
 */
public class MsRtf extends MsFile implements MsReadable {

    public MsRtf() {}

    private MsRtf(String path, String name, String ext) {
        super(path, name, ext);
    }

    @Override
    public MsFile process() {
        super.setContent(read());
        return this;
    }

    @Override
    public String read() {
        return new MsRtfReaderFile().read(getPath());
    }

    @Override
    public MsReadable newOne(String path, String name, String ext) {
        return new MsRtf(path, name, ext);
    }
}
