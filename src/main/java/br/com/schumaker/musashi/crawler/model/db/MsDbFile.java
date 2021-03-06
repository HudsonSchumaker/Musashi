package br.com.schumaker.musashi.crawler.model.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MsDbFile {

    @Id
    private String id;
    private String name;
    private String ext;
    private String path;
    private String content;
}
