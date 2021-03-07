package br.com.schumaker.musashi.search.service;

import br.com.schumaker.musashi.crawler.model.db.MsDbFile;
import br.com.schumaker.musashi.search.model.MsSearchDTO;

import java.util.List;

public interface MsSearchService {
    List<MsDbFile> search(MsSearchDTO msSearchDTO);
}
