package br.com.schumaker.musashi.crawler.service;

import br.com.schumaker.musashi.crawler.model.db.repositories.MsDbFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Hudson Schumaker
 */
@Service
public class MsCrawlerServiceImpl implements MsCrawlerService {

    @Autowired
    private MsDbFileRepository repository;

    private final ExecutorService directories;
    private final ExecutorService files;

    public MsCrawlerServiceImpl() {
        this.directories = Executors.newFixedThreadPool(256, new MsThreadFactory());
        this.files = Executors.newFixedThreadPool(128, new MsReaderThreadFactory());
    }

    @Override
    public void startCrawler(String path) {
        File file = new File(path);
        File []roots = file.listFiles();

        for (File f : roots) {
            if(!f.isHidden()) {
                if (f.isDirectory()) {
                    Crawler c = new Crawler(f.getAbsolutePath(), files, repository);
                    this.directories.execute(c);
                } else {
                    Crawler c = new Crawler(f.getAbsolutePath(), files, repository);
                    this.files.execute(c);
                }
            }
        }
    }
}
