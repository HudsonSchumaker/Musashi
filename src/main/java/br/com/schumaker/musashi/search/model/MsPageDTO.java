package br.com.schumaker.musashi.search.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 *
 * @author Hudson Schumaker
 */
@Data
@NoArgsConstructor
public class MsPageDTO {

    private int page;
    private int pageSize;
    private int totalPages;
    private long totalElements;
    private List<MsFileDTO> data;
}
