package com.chupintech.youthcon2024.notification.service;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public final class NotificationService {

	public void notify(final NotificationCommand command) {
		log.info("========== NotificationService.notify Command: {} ==========", command);
	}
}
