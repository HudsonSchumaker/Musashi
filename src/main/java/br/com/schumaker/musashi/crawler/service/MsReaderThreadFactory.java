package br.com.schumaker.musashi.crawler.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadFactory;

/**
 *
 * @author Hudson Schumaker
 */
@Component
public class MsReaderThreadFactory implements ThreadFactory {

    public static long number = 0L;

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r, "reader " + number);
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.setUncaughtExceptionHandler(new MsExceptionHandler());
        number++;
        return thread;
    }
}
