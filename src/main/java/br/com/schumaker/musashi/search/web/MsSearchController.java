package br.com.schumaker.musashi.search.web;

import br.com.schumaker.musashi.search.model.MsPageDTO;
import br.com.schumaker.musashi.search.model.MsSearchDTO;
import br.com.schumaker.musashi.search.service.MsSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.ACCEPTED;

/**
 *
 * @author Hudson Schumaker
 */
@RestController
@RequestMapping("/search")
public class MsSearchController {

    @Autowired
    private MsSearchService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MsPageDTO> search(@RequestBody MsSearchDTO msSearchDTO) {
        return ResponseEntity.status(ACCEPTED).body(service.search(msSearchDTO));
    }

    @PostMapping(value = "/name", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MsPageDTO> searchByName(@RequestBody MsSearchDTO msSearchDTO) {
        return ResponseEntity.status(ACCEPTED).body(service.searchByName(msSearchDTO));
    }
}
