package com.bumptech.glide.util;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public final class Executors {
    private static final Executor DIRECT_EXECUTOR = new Executor() {
        public void execute(Runnable runnable) {
            runnable.run();
        }
    };
    private static final Executor MAIN_THREAD_EXECUTOR = new Executor() {
        public void execute(Runnable runnable) {
            C0957Util.postOnUiThread(runnable);
        }
    };

    private Executors() {
    }

    public static Executor mainThreadExecutor() {
        return MAIN_THREAD_EXECUTOR;
    }

    public static Executor directExecutor() {
        return DIRECT_EXECUTOR;
    }

    public static void shutdownAndAwaitTermination(ExecutorService executorService) {
        executorService.shutdownNow();
        try {
            if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
                if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                    throw new RuntimeException("Failed to shutdown");
                }
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
