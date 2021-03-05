package br.com.schumaker.musashi.crawler.service;

import java.lang.Thread.UncaughtExceptionHandler;

public class MsExceptionHandler implements UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("Exception on thread " + t.getName() + ": " + e.getMessage());
    }
}
