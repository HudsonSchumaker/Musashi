package br.com.schumaker.musashi.search.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Hudson Schumaker
 */
@Data
@NoArgsConstructor
public class MsSearchDTO {

    private String query;
    private int page = 0;
    private int pageSize = 10;
}
