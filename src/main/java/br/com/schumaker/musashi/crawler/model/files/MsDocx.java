package br.com.schumaker.musashi.crawler.model.files;

import br.com.schumaker.musashi.crawler.model.MsFile;
import br.com.schumaker.musashi.crawler.model.MsReadable;
import br.com.schumaker.musashi.crawler.model.readers.impl.MsDocxReaderFile;
import lombok.NoArgsConstructor;

/**
 *
 * @author Hudson Schumaker
 */
@NoArgsConstructor
public class MsDocx extends MsFile implements MsReadable {

    private MsDocx(String path, String name, String ext) {
        super(path, name, ext);
    }

    @Override
    public MsFile process() {
        super.setContent(read());
        return this;
    }

    @Override
    public String read() {
        return new MsDocxReaderFile().read(getPath());
    }

    @Override
    public MsReadable newOne(String path, String name, String ext) {
        return new MsDocx(path, name, ext);
    }
}
