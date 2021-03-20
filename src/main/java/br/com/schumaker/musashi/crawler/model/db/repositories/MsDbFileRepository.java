package br.com.schumaker.musashi.crawler.model.db.repositories;

import br.com.schumaker.musashi.crawler.model.db.MsDbFile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Hudson Schumaker
 */
@Repository
public interface MsDbFileRepository extends MongoRepository<MsDbFile, String> {

    Page<MsDbFile> findByNameLike(String query, Pageable pageable);
    Page<MsDbFile> findByContentLike(String query, Pageable pageable);
}
