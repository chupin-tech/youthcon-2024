package com.chupintech.youthcon2024.event;

import java.util.Optional;

public abstract class AbstractEventListener<E> implements EventListener<E> {

    private final EventPublisher publisher;

    protected AbstractEventListener(final EventPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public final void onEvent(final E event) {
        handleEvent(event)
                .ifPresent(publisher::publish);
    }

    protected abstract Optional<Object> handleEvent(final E event);
}
