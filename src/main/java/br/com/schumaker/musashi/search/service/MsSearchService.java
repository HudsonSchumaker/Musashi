package br.com.schumaker.musashi.search.service;

import br.com.schumaker.musashi.search.model.MsPageDTO;
import br.com.schumaker.musashi.search.model.MsSearchDTO;
import br.com.schumaker.musashi.search.model.MsSearchExtDTO;

/**
 *
 * @author Hudson Schumaker
 */
public interface MsSearchService {
    MsPageDTO search(MsSearchDTO msSearchDTO);
    MsPageDTO searchByName(MsSearchDTO msSearchDTO);
    MsPageDTO searchByExt(MsSearchExtDTO msSearchExtDTO);
}
