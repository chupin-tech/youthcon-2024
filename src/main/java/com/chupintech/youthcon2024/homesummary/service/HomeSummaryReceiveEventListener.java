package com.chupintech.youthcon2024.homesummary.service;

import com.chupintech.youthcon2024.document.domain.ReceiveEvent;
import com.chupintech.youthcon2024.event.EventListener;

public class HomeSummaryReceiveEventListener implements EventListener<ReceiveEvent> {

    private final HomeSummaryUpdateService service;

    public HomeSummaryReceiveEventListener(final HomeSummaryUpdateService service) {
        this.service = service;
    }

    @Override
    public void onEvent(final ReceiveEvent event) {
        service.addDocumentSummary(event.userId(), event.documentId(), event.title());
    }
}
