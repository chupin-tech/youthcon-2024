package com.chupintech.youthcon2024.event;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EventMulticaster implements EventPublisher {

    private final List<EventListener<?>> listeners;

    public EventMulticaster(final List<EventListener<?>> listeners) {
        this.listeners = listeners;
    }

    @Override
    public void publish(final Object event) {
        final Class<?> clazz = event.getClass();

        listeners.stream()
                .filter(listener -> listener.canListen(clazz))
                .forEach(listener -> onEvent(listener, event));
    }

    private void onEvent(final EventListener listener, final Object event) {
        listener.onEvent(event);
    }
}
