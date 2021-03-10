package br.com.schumaker.musashi.crawler.web;

import br.com.schumaker.musashi.crawler.service.MsCrawlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.HttpStatus.OK;

/**
 *
 * @author Hudson Schumaker
 */
@RestController
@RequestMapping("/crawler")
public class MsCrawlerController {

    @Autowired
    private MsCrawlerService service;

    @ResponseStatus(ACCEPTED)
    @PostMapping
    public void startCrawler() {
        setRoot();
    }

    @ResponseStatus(OK)
    @GetMapping()
    public void start() {
        service.startCrawler("\\\\192.168.1.250\\Data2");
    }

    private void setRoot() {
        service.startCrawler("\\\\192.168.1.250\\Data2");
    }
}
