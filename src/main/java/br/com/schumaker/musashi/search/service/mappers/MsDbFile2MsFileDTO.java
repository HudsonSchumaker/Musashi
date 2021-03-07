package br.com.schumaker.musashi.search.service.mappers;

import br.com.schumaker.musashi.crawler.model.db.MsDbFile;
import br.com.schumaker.musashi.crawler.service.mappers.Mapper;
import br.com.schumaker.musashi.search.model.MsFileDTO;
import org.springframework.stereotype.Component;

@Component
public class MsDbFile2MsFileDTO implements Mapper<MsDbFile, MsFileDTO> {

    @Override
    public MsFileDTO from(MsDbFile source) {
        MsFileDTO target = new MsFileDTO();
        map(source, target);
        return target;
    }

    @Override
    public void map(MsDbFile source, MsFileDTO target) {
        target.setName(source.getName());
        target.setPath(source.getPath());
        target.setContent(source.getContent());
        target.setExt(source.getExt());
    }
}
