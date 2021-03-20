package br.com.schumaker.musashi.crawler.model.db

import lombok.Data
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

/**
 *
 * @author Hudson Schumaker
 */
@Data
@Document
class MsDbFile {
    @Id
    private val id: ObjectId? = null

    @Indexed(unique = true)
    private val name: String? = null
    private val ext: String? = null

    @Indexed(unique = true)
    private val path: String? = null
    private val content: String? = null
    private val rank: Long = 0
}