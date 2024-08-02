package com.chupintech.youthcon2024.notification.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public final class NotificationService {

    public void notify(final String userId, final long documentId) {
        log.warn("###### NotificationService.notify 호출 ######");
    }
}
