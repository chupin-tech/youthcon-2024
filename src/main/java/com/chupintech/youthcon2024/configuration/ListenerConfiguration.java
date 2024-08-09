package com.chupintech.youthcon2024.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.chupintech.youthcon2024.document.domain.ReadEvent;
import com.chupintech.youthcon2024.document.domain.ReceiveEvent;
import com.chupintech.youthcon2024.event.EventListener;
import com.chupintech.youthcon2024.homesummary.listener.HomeSummaryNotificationEventListener;
import com.chupintech.youthcon2024.homesummary.listener.HomeSummaryReadEventEventListener;
import com.chupintech.youthcon2024.homesummary.listener.HomeSummaryReceiveEventEventListener;
import com.chupintech.youthcon2024.homesummary.service.HomeSummaryUpdateService;
import com.chupintech.youthcon2024.notification.event.NotificationEvent;
import com.chupintech.youthcon2024.notification.listener.NotificationReceiveEventEventListener;
import com.chupintech.youthcon2024.notification.service.NotificationService;

@Configuration
public class ListenerConfiguration {

	@Bean
	public EventListener<ReceiveEvent> notificationReceiveEventEventListener(final NotificationService service) {
		return new NotificationReceiveEventEventListener(service);
	}

	@Bean
	public EventListener<NotificationEvent> homeSummaryNotificationEventListener(
		final HomeSummaryUpdateService service) {
		return new HomeSummaryNotificationEventListener(service);
	}

	@Bean
	public EventListener<ReceiveEvent> homeSummaryReceiveEventEventListener(final HomeSummaryUpdateService service) {
		return new HomeSummaryReceiveEventEventListener(service);
	}

	@Bean
	public EventListener<ReadEvent> homeSummaryReadEventEventListener(final HomeSummaryUpdateService service) {
		return new HomeSummaryReadEventEventListener(service);
	}
}
