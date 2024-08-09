package com.chupintech.youthcon2024.homesummary.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DocumentSummaryUpdateService {

	private static final Logger LOG = LoggerFactory.getLogger(DocumentSummaryUpdateService.class);

	public void addDocumentSummary(final DocumentSummaryAddCommand command) {
		LOG.info("========== UpdateService.addDocumentSummary Command: {} ==========", command);
	}

	public void readDocumentSummary(final DocumentSummaryReadCommand command) {
		LOG.info("========== UpdateService.readDocumentSummary Command: {} ==========", command);
	}
}
