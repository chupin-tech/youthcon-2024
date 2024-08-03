package com.chupintech.youthcon2024.notification.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

	private static final Logger LOG = LoggerFactory.getLogger(NotificationService.class);

	public void notify(final NotificationCommand command) {
		LOG.info("========== NotificationService.notify Command: {} ==========", command);
	}
}
