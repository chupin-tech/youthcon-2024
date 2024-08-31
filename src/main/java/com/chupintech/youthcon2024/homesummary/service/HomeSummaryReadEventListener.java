package com.chupintech.youthcon2024.homesummary.service;

import com.chupintech.youthcon2024.document.domain.ReadEvent;
import com.chupintech.youthcon2024.event.EventListener;

public class HomeSummaryReadEventListener implements EventListener<ReadEvent> {

    private final HomeSummaryUpdateService service;

    public HomeSummaryReadEventListener(final HomeSummaryUpdateService service) {
        this.service = service;
    }

    @Override
    public void onEvent(final ReadEvent event) {
        service.readDocumentSummary(event.userId(), event.documentId());
    }
}
