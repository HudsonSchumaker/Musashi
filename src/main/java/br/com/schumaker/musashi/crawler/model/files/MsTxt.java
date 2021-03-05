package br.com.schumaker.musashi.crawler.model.files;

import br.com.schumaker.musashi.crawler.model.MsFile;
import br.com.schumaker.musashi.crawler.model.MsReadable;
import br.com.schumaker.musashi.crawler.model.readers.impl.MsBasicReaderFile;

/**
 *
 * @author Hudson Schumaker
 */
public class MsTxt extends MsFile implements MsReadable {

    public MsTxt() {}

    private MsTxt(String path, String name, String ext) {
        super(path, name, ext);
    }

    @Override
    public void process() {
        super.setContent(read());
    }

    @Override
    public String read() {
        return new MsBasicReaderFile().read(getPath());
    }

    @Override
    public MsReadable newOne(String path, String name, String ext) {
        return null;
    }
}
