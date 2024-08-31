package com.chupintech.youthcon2024.event;

import java.util.Optional;

public abstract class AbstractEventListener<T> implements EventListener<T> {

    private final EventPublisher publisher;

    protected AbstractEventListener(final EventPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public final void onEvent(final T event) {
        handleEvent(event)
                .ifPresent(resultEvent -> publisher.publish(resultEvent));
    }

    protected abstract Optional<Object> handleEvent(final T event);
}
