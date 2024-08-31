package com.chupintech.youthcon2024.event;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class AsyncEventListener<T> implements EventListener<T> {

    private final EventListener<T> delegatedListener;

    private final Executor executor;

    public AsyncEventListener(final EventListener<T> delegatedListener, final Executor executor) {
        this.delegatedListener = delegatedListener;
        this.executor = executor;
    }

    @Override
    public void onEvent(final T event) {
        CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(50L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            delegatedListener.onEvent(event);
        }, executor);
    }

    @Override
    public boolean canListen(final Class<?> clazz) {
        return delegatedListener.canListen(clazz);
    }
}
