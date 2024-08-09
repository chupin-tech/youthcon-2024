package com.chupintech.youthcon2024.notification.listener;

import com.chupintech.youthcon2024.document.domain.ReceiveEvent;
import com.chupintech.youthcon2024.event.EventListener;
import com.chupintech.youthcon2024.notification.service.NotificationCommand;
import com.chupintech.youthcon2024.notification.service.NotificationService;

public class NotificationReceiveEventEventListener implements EventListener<ReceiveEvent> {

	private final NotificationService notificationService;

	public NotificationReceiveEventEventListener(final NotificationService notificationService) {
		this.notificationService = notificationService;
	}

	@Override
	public void onEvent(final ReceiveEvent event) {
		final NotificationCommand command = new NotificationCommand(event.userId(), event.documentId());
		notificationService.notify(command);
	}
}
