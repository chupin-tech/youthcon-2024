package com.chupintech.youthcon2024.configuration;

import com.chupintech.youthcon2024.document.domain.ReadEvent;
import com.chupintech.youthcon2024.document.domain.ReceiveEvent;
import com.chupintech.youthcon2024.event.EventListener;
import com.chupintech.youthcon2024.homesummary.service.HomeSummaryNotificationEventListener;
import com.chupintech.youthcon2024.homesummary.service.HomeSummaryReadEventListener;
import com.chupintech.youthcon2024.homesummary.service.HomeSummaryReceiveEventListener;
import com.chupintech.youthcon2024.homesummary.service.HomeSummaryUpdateService;
import com.chupintech.youthcon2024.notification.event.NotificationEvent;
import com.chupintech.youthcon2024.notification.NotificationReceiveEventListener;
import com.chupintech.youthcon2024.notification.service.NotificationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ListenerConfiguration {

    @Bean
    public EventListener<ReceiveEvent> notificationReceiveEventListener(final NotificationService service) {
        return new NotificationReceiveEventListener(service);
    }

    @Bean
    public EventListener<ReceiveEvent> homeSummaryReceiveEventListener(final HomeSummaryUpdateService service) {
        return new HomeSummaryReceiveEventListener(service);
    }

    @Bean
    public EventListener<ReadEvent> homeSummaryReadEventListener(final HomeSummaryUpdateService service) {
        return new HomeSummaryReadEventListener(service);
    }

    @Bean
    public EventListener<NotificationEvent> homeSummaryNotificationEventListener(final HomeSummaryUpdateService service) {
        return new HomeSummaryNotificationEventListener(service);
    }
}
