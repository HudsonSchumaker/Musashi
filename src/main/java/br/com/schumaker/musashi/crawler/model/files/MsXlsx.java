package br.com.schumaker.musashi.crawler.model.files;

import br.com.schumaker.musashi.crawler.model.MsFile;
import br.com.schumaker.musashi.crawler.model.MsReadable;
import br.com.schumaker.musashi.crawler.model.readers.impl.MsXlsxReaderFile;

/**
 *
 * @author Hudson Schumaker
 */
public class MsXlsx extends MsFile implements MsReadable {

    public MsXlsx() {}

    private MsXlsx(String path, String name, String ext) {
        super(path, name, ext);
    }

    @Override
    public MsFile process() {
        super.setContent(read());
        return this;
    }

    @Override
    public String read() {
        return new MsXlsxReaderFile().read(getPath());
    }

    @Override
    public MsReadable newOne(String path, String name, String ext) {
        return new MsXlsx(path, name, ext);
    }
}
