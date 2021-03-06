package br.com.schumaker.musashi.crawler.model.db.repositories;

import br.com.schumaker.musashi.crawler.model.db.MsDbFile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MsDbFileRepository extends MongoRepository<MsDbFile, String> {
}
