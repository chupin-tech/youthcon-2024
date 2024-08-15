package com.chupintech.youthcon2024.notification.listener;

import com.chupintech.youthcon2024.document.domain.ReceiveEvent;
import com.chupintech.youthcon2024.event.EventListener;
import com.chupintech.youthcon2024.notification.service.NotificationService;

public class NotificationReceiveEventListener implements EventListener<ReceiveEvent> {

    private final NotificationService service;

    public NotificationReceiveEventListener(final NotificationService service) {
        this.service = service;
    }

    @Override
    public void onEvent(final ReceiveEvent event) {
        service.notify(event.userId(), event.documentId());
    }

    @Override
    public boolean canListen(final Class<?> clazz) {
        return clazz.isAssignableFrom(ReceiveEvent.class);
    }
}
