package br.com.schumaker.musashi.crawler.model.files;

import br.com.schumaker.musashi.crawler.model.MsFile;
import br.com.schumaker.musashi.crawler.model.MsReadable;
import lombok.NoArgsConstructor;

/**
 *
 * @author Hudson Schumaker
 */
@NoArgsConstructor
public class MsVoid extends MsFile implements MsReadable {

    private MsVoid(String path, String name, String ext) {
        super(path, name, ext);
    }

    @Override
    public MsFile process() {
        super.setContent(read());
        return this;
    }

    @Override
    public String read() {
        return "";
    }

    @Override
    public MsReadable newOne(String path, String name, String ext) {
        return new MsVoid(path, name, ext);
    }
}
