package br.com.schumaker.musashi.crawler.model.files;

import br.com.schumaker.musashi.crawler.model.MsFile;
import br.com.schumaker.musashi.crawler.model.MsReadable;
import br.com.schumaker.musashi.crawler.model.readers.impl.MsDocReaderFile;
import lombok.NoArgsConstructor;

/**
 *
 * @author Hudson Schumaker
 */
@NoArgsConstructor
public class MsDoc extends MsFile implements MsReadable {

    private MsDoc(String path, String name, String ext) {
        super(path, name, ext);
    }

    @Override
    public MsFile process() {
        super.setContent(read());
        return this;
    }

    @Override
    public String read() {
        return new MsDocReaderFile().read(getPath());
    }

    @Override
    public MsReadable newOne(String path, String name, String ext) {
        return new MsDoc(path, name, ext);
    }
}
