package br.com.schumaker.musashi.crawler.service.mappers;

import br.com.schumaker.musashi.crawler.model.MsFile;
import br.com.schumaker.musashi.crawler.model.db.MsDbFile;
import org.springframework.stereotype.Component;

/**
 *
 * @author Hudson Schumaker
 */
@Component
public class MsFile2MsDbFile implements Mapper<MsFile, MsDbFile> {

    @Override
    public MsDbFile from(MsFile source) {
        MsDbFile target = new MsDbFile();
        map(source, target);
        return target;
    }

    @Override
    public void map(MsFile source, MsDbFile target) {
        target.setName(source.getName());
        target.setPath(source.getPath());
        target.setContent(source.getContent());
        target.setExt(source.getExt());
        target.setRank(0L);
    }
}
