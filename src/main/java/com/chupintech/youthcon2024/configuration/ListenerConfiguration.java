package com.chupintech.youthcon2024.configuration;

import com.chupintech.youthcon2024.document.domain.ReadEvent;
import com.chupintech.youthcon2024.document.domain.ReceiveEvent;
import com.chupintech.youthcon2024.event.EventListener;
import com.chupintech.youthcon2024.event.EventPublisher;
import com.chupintech.youthcon2024.homesummary.service.HomeSummaryNotificationEventListener;
import com.chupintech.youthcon2024.homesummary.service.HomeSummaryReadEventListener;
import com.chupintech.youthcon2024.homesummary.service.HomeSummaryReceiveEventListener;
import com.chupintech.youthcon2024.homesummary.service.HomeSummaryUpdateService;
import com.chupintech.youthcon2024.notification.NotificationReceiveEventListener;
import com.chupintech.youthcon2024.notification.event.NotificationEvent;
import com.chupintech.youthcon2024.notification.service.NotificationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class ListenerConfiguration {

    @Bean
    public EventListener<ReceiveEvent> notificationReceiveEventListener(
            @Lazy final EventPublisher publisher,
            final NotificationService service) {

        return new NotificationReceiveEventListener(publisher, service);
    }

    @Bean
    public EventListener<ReceiveEvent> homeSummaryReceiveEventListener(
            @Lazy final EventPublisher publisher,
            final HomeSummaryUpdateService service) {

        return new HomeSummaryReceiveEventListener(publisher, service);
    }

    @Bean
    public EventListener<ReadEvent> homeSummaryReadEventListener(
            @Lazy final EventPublisher publisher,
            final HomeSummaryUpdateService service) {

        return new HomeSummaryReadEventListener(publisher, service);
    }

    @Bean
    public EventListener<NotificationEvent> homeSummaryNotificationEventListener(
            @Lazy final EventPublisher publisher,
            final HomeSummaryUpdateService service) {

        return new HomeSummaryNotificationEventListener(publisher, service);
    }
}
