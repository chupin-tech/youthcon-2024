package com.chupintech.youthcon2024.event;

import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;

public class TransactionalEventListener<E> implements EventListener<E> {

    private final EventListener<E> delegatedListener;

    public TransactionalEventListener(final EventListener<E> delegatedListener) {
        this.delegatedListener = delegatedListener;
    }

    @Override
    public void onEvent(final E event) {
        final TransactionSynchronization synchronization = new TransactionSynchronization() {
            @Override
            public void afterCommit() {
                delegatedListener.onEvent(event);
            }
        };

        TransactionSynchronizationManager.registerSynchronization(synchronization);
    }

    @Override
    public boolean canListen(final Class<?> clazz) {
        return delegatedListener.canListen(clazz);
    }
}
