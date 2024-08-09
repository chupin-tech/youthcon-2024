package com.chupintech.youthcon2024.homesummary.listener;

import com.chupintech.youthcon2024.document.domain.ReceiveEvent;
import com.chupintech.youthcon2024.event.EventListener;
import com.chupintech.youthcon2024.homesummary.service.DocumentSummaryAddCommand;
import com.chupintech.youthcon2024.homesummary.service.HomeSummaryUpdateService;

public class HomeSummaryReceiveEventEventListener implements EventListener<ReceiveEvent> {

	private final HomeSummaryUpdateService service;

	public HomeSummaryReceiveEventEventListener(final HomeSummaryUpdateService service) {
		this.service = service;
	}

	@Override
	public void onEvent(final ReceiveEvent event) {
		final DocumentSummaryAddCommand command
			= new DocumentSummaryAddCommand(event.userId(), event.documentId(), event.title());

		service.addDocumentSummary(command);
	}
}
