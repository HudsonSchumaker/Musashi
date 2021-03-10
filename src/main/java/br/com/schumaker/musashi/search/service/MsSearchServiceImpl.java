package br.com.schumaker.musashi.search.service;

import br.com.schumaker.musashi.crawler.model.db.MsDbFile;
import br.com.schumaker.musashi.crawler.model.db.repositories.MsDbFileRepository;
import br.com.schumaker.musashi.search.model.MsPageDTO;
import br.com.schumaker.musashi.search.model.MsSearchDTO;
import br.com.schumaker.musashi.search.service.mappers.MsDbFile2MsFileDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 *
 * @author Hudson Schumaker
 */
@Service
public class MsSearchServiceImpl implements MsSearchService {

    @Autowired
    private MsDbFile2MsFileDTO mapper;

    @Autowired
    private MsDbFileRepository repository;

    public MsPageDTO search(MsSearchDTO msSearchDTO) {
        Pageable pageable = PageRequest.of(msSearchDTO.getPage(), msSearchDTO.getPageSize(),
                Sort.by(Sort.Direction.DESC, "rank"));

        Page<MsDbFile> page = repository.findByContentLike(msSearchDTO.getQuery(), pageable);

        MsPageDTO pageDTO = buildMsPageDTO(msSearchDTO, page);
        pageDTO.setData(mapper.from(page.getContent()));
        return pageDTO;
    }

    public MsPageDTO searchByName(MsSearchDTO msSearchDTO) {
        Pageable pageable = PageRequest.of(msSearchDTO.getPage(), msSearchDTO.getPageSize());
        Page<MsDbFile> page = repository.findByNameLike(msSearchDTO.getQuery(), pageable);

        MsPageDTO pageDTO = buildMsPageDTO(msSearchDTO, page);
        pageDTO.setData(mapper.from(page.getContent()));
        return pageDTO;
    }

    private MsPageDTO buildMsPageDTO(MsSearchDTO msSearchDTO, Page<MsDbFile> page) {
        MsPageDTO pageDTO = new MsPageDTO();
        pageDTO.setPage(page.getNumber());
        pageDTO.setPageSize(msSearchDTO.getPageSize());
        pageDTO.setTotalPages(page.getTotalPages());
        pageDTO.setTotalElements(page.getTotalElements());
        return pageDTO;
    }
}
