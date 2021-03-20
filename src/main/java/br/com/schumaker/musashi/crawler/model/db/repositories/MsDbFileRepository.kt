package br.com.schumaker.musashi.crawler.model.db.repositories

import br.com.schumaker.musashi.crawler.model.db.MsDbFile
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

/**
 *
 * @author Hudson Schumaker
 */
@Repository
interface MsDbFileRepository : MongoRepository<MsDbFile?, String?> {

    fun findByNameLike(query: String?, pageable: Pageable?): Page<MsDbFile?>?
    fun findByContentLike(query: String?, pageable: Pageable?): Page<MsDbFile?>?
}