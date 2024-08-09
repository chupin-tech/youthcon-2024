package com.chupintech.youthcon2024.homesummary.listener;

import com.chupintech.youthcon2024.document.domain.ReadEvent;
import com.chupintech.youthcon2024.event.EventListener;
import com.chupintech.youthcon2024.homesummary.service.DocumentSummaryReadCommand;
import com.chupintech.youthcon2024.homesummary.service.HomeSummaryUpdateService;

public class HomeSummaryReadEventEventListener implements EventListener<ReadEvent> {

	private final HomeSummaryUpdateService service;

	public HomeSummaryReadEventEventListener(final HomeSummaryUpdateService service) {
		this.service = service;
	}

	@Override
	public void onEvent(final ReadEvent event) {
		final DocumentSummaryReadCommand command = new DocumentSummaryReadCommand(event.userId(), event.documentId());

		service.readDocumentSummary(command);
	}
}
