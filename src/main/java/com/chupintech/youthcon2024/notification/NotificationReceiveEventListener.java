package com.chupintech.youthcon2024.notification;

import com.chupintech.youthcon2024.document.domain.ReceiveEvent;
import com.chupintech.youthcon2024.event.AbstractEventListener;
import com.chupintech.youthcon2024.event.EventPublisher;
import com.chupintech.youthcon2024.notification.event.NotificationEvent;
import com.chupintech.youthcon2024.notification.service.NotificationService;

import java.util.Optional;

public class NotificationReceiveEventListener extends AbstractEventListener<ReceiveEvent> {

    private final NotificationService service;

    public NotificationReceiveEventListener(final EventPublisher publisher,
                                            final NotificationService service) {
        super(publisher);
        this.service = service;
    }

    @Override
    protected Optional<Object> handleEvent(final ReceiveEvent event) {
        service.notify(event.userId(), event.documentId());
        return Optional.of(new NotificationEvent(1));
    }

    @Override
    public boolean canListen(final Class<?> clazz) {
        return ReceiveEvent.class.isAssignableFrom(clazz);
    }
}
