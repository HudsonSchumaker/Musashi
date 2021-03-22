package br.com.schumaker.musashi.search.model;

import br.com.schumaker.musashi.search.validations.Ext;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Hudson Schumaker
 */
@Data
@NoArgsConstructor
public class MsSearchExtDTO {

    @Ext
    private String query;
    private int page = 0;
    private int pageSize = 10;
}
