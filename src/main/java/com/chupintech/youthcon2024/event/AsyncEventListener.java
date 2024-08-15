package com.chupintech.youthcon2024.event;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class AsyncEventListener<E> implements EventListener<E> {

    private final EventListener<E> delegatedListener;

    private final Executor executor;

    public AsyncEventListener(final EventListener<E> delegatedListener, final Executor executor) {
        this.delegatedListener = delegatedListener;
        this.executor = executor;
    }

    @Override
    public void onEvent(final E event) {
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
