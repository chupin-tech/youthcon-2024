package com.chupintech.youthcon2024.homesummary.service;

import com.chupintech.youthcon2024.event.AbstractEventListener;
import com.chupintech.youthcon2024.event.EventPublisher;
import com.chupintech.youthcon2024.notification.event.NotificationEvent;

import java.util.Optional;

public class HomeSummaryNotificationEventListener extends AbstractEventListener<NotificationEvent> {

    private final HomeSummaryUpdateService service;

    public HomeSummaryNotificationEventListener(final EventPublisher publisher,
                                                final HomeSummaryUpdateService service) {
        super(publisher);
        this.service = service;
    }

    @Override
    protected Optional<Object> handleEvent(final NotificationEvent event) {
        service.addNotificationCount(event.count());
        return Optional.empty();
    }

    @Override
    public boolean canListen(final Class<?> clazz) {
        return NotificationEvent.class.isAssignableFrom(clazz);
    }
}
