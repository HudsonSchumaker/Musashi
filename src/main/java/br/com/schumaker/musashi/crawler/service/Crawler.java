package br.com.schumaker.musashi.crawler.service;

import br.com.schumaker.musashi.crawler.model.MsFile;
import br.com.schumaker.musashi.crawler.model.MsSupportedFile;
import br.com.schumaker.musashi.crawler.model.db.MsDbFile;
import br.com.schumaker.musashi.crawler.model.db.repositories.MsDbFileRepository;
import br.com.schumaker.musashi.crawler.service.mappers.MsFile2MsDbFile;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.concurrent.ExecutorService;

/**
 *
 * @author Hudson Schumaker
 */
@Component
@NoArgsConstructor
public class Crawler implements Runnable {

    private String root;
    private ExecutorService threadPool;
    private MsDbFileRepository repository;

    public Crawler(String root, ExecutorService threadPool, MsDbFileRepository repository) {
        this.root = root;
        this.threadPool = threadPool;
        this.repository = repository;
    }

    @Override
    public void run() {
        crawlFiles(new File(root));
    }

    private void crawlFiles(File file) {
        if (!file.isHidden()) {
            if (file.isDirectory()) {
                File[] list = file.listFiles();
                for (File f : list) {
                    if (f.isDirectory()) {
                        crawlFiles(f);
                    } else {
                        Crawler c = new Crawler(f.getAbsolutePath(), threadPool, repository);
                        threadPool.execute(c);
                    }
                }
            } else {
                if ((file.length() / 1024) / 1024 > 50) {
                       System.out.println(file.getName() + " > que 8mb " + (file.length() / 1024) / 1024);
                } else {
                    String ext = GetExtension.getExt(file);
                    if (MsSupportedFile.getInstance().isSupported(ext)) {

                        MsFile r = MsSupportedFile.getInstance().getType(ext)
                                .newOne(file.getAbsolutePath(), file.getName(), ext).process();

                       repository.save(map(r));
                    }
                }
            }
        }
    }

    private MsDbFile map(MsFile file) {
        MsFile2MsDbFile mapper = new MsFile2MsDbFile();
        return mapper.from(file);
    }
}
