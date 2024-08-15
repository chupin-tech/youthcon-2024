package com.chupintech.youthcon2024.homesummary.listener;

import com.chupintech.youthcon2024.event.EventListener;
import com.chupintech.youthcon2024.homesummary.service.HomeSummaryUpdateService;
import com.chupintech.youthcon2024.notification.event.NotificationEvent;

public class HomeSummaryNotificationEventListener implements EventListener<NotificationEvent> {

    private final HomeSummaryUpdateService service;

    public HomeSummaryNotificationEventListener(final HomeSummaryUpdateService service) {
        this.service = service;
    }

    @Override
    public void onEvent(final NotificationEvent event) {
        service.addNotificationCount(event.count());
    }
}
