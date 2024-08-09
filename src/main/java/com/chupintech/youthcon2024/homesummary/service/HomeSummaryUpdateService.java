package com.chupintech.youthcon2024.homesummary.service;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public final class HomeSummaryUpdateService {

	public void addDocumentSummary(final DocumentSummaryAddCommand command) {
		log.info("========== UpdateService.addDocumentSummary Command: {} ==========", command);
	}

	public void readDocumentSummary(final DocumentSummaryReadCommand command) {
		log.info("========== UpdateService.readDocumentSummary Command: {} ==========", command);
	}

	public void addNotificationCount(final NotificationAddCommand command) {
		log.info("========== UpdateService.addNotificationCount Command: {} ==========", command);
	}
}
