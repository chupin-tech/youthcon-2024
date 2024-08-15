package com.chupintech.youthcon2024.configuration;

import com.chupintech.youthcon2024.document.domain.ReadEvent;
import com.chupintech.youthcon2024.document.domain.ReceiveEvent;
import com.chupintech.youthcon2024.event.AsyncEventListener;
import com.chupintech.youthcon2024.event.EventListener;
import com.chupintech.youthcon2024.event.EventPublisher;
import com.chupintech.youthcon2024.homesummary.listener.HomeSummaryNotificationEventListener;
import com.chupintech.youthcon2024.homesummary.listener.HomeSummaryReadEventListener;
import com.chupintech.youthcon2024.homesummary.listener.HomeSummaryReceiveEventListener;
import com.chupintech.youthcon2024.homesummary.service.HomeSummaryUpdateService;
import com.chupintech.youthcon2024.notification.event.NotificationEvent;
import com.chupintech.youthcon2024.notification.listener.NotificationReceiveEventListener;
import com.chupintech.youthcon2024.notification.service.NotificationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.util.concurrent.Executor;

@Configuration
public class ListenerConfiguration {

    @Bean
    public EventListener<ReceiveEvent> notificationReceiveEventListener(@Lazy final EventPublisher publisher,
                                                                        final NotificationService service,
                                                                        final Executor executor) {

        final NotificationReceiveEventListener listener = new NotificationReceiveEventListener(publisher, service);
        return new AsyncEventListener<>(listener, executor);
    }

    @Bean
    public EventListener<ReceiveEvent> homeSummaryReceiveEventListener(@Lazy final EventPublisher publisher,
                                                                       final HomeSummaryUpdateService service) {
        return new HomeSummaryReceiveEventListener(publisher, service);
    }

    @Bean
    public EventListener<ReadEvent> homeSummaryReadEventListener(@Lazy final EventPublisher publisher,
                                                                 final HomeSummaryUpdateService service) {
        return new HomeSummaryReadEventListener(publisher, service);
    }

    @Bean
    public EventListener<NotificationEvent> homeSummaryNotificationEventListener(@Lazy final EventPublisher publisher,
                                                                                 final HomeSummaryUpdateService service) {
        return new HomeSummaryNotificationEventListener(publisher, service);
    }
}
