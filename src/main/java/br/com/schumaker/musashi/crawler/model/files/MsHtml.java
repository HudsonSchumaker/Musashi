package br.com.schumaker.musashi.crawler.model.files;

import br.com.schumaker.musashi.crawler.model.MsFile;
import br.com.schumaker.musashi.crawler.model.MsReadable;
import br.com.schumaker.musashi.crawler.model.readers.impl.MsHtmlReaderFile;
import lombok.NoArgsConstructor;

/**
 *
 * @author Hudson Schumaker
 */
@NoArgsConstructor
public class MsHtml extends MsFile implements MsReadable {

    private MsHtml(String path, String name, String ext) {
        super(path, name, ext);
    }

    @Override
    public MsFile process() {
        super.setContent(read());
        return this;
    }

    @Override
    public String read() {
        return new MsHtmlReaderFile().read(getPath());
    }

    @Override
    public MsReadable newOne(String path, String name, String ext) {
        return new MsHtml(path, name, ext);
    }
}
