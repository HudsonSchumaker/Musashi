package br.com.schumaker.musashi.crawler.model.db;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Hudson Schumaker
 */
@Data
@Document
public class MsDbFile {

    @Id
    private ObjectId id;

    @Indexed(unique = true)
    private String name;
    private String ext;
    @Indexed(unique = true)
    private String path;
    private String content;
    private long rank;
}
