package br.com.schumaker.musashi.crawler.model.db.repositories;

import br.com.schumaker.musashi.crawler.model.db.MsDbFile;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MsDbFileRepository extends MongoRepository<MsDbFile, String> {

    List<MsDbFile> findByContentLike(String query, Pageable pageable);
}
