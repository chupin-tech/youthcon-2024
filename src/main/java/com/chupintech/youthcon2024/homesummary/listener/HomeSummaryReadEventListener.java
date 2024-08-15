package com.chupintech.youthcon2024.homesummary.listener;

import com.chupintech.youthcon2024.document.domain.ReadEvent;
import com.chupintech.youthcon2024.event.AbstractEventListener;
import com.chupintech.youthcon2024.event.EventPublisher;
import com.chupintech.youthcon2024.homesummary.service.HomeSummaryUpdateService;

import java.util.Optional;

public class HomeSummaryReadEventListener extends AbstractEventListener<ReadEvent> {

    private final HomeSummaryUpdateService service;

    public HomeSummaryReadEventListener(final EventPublisher publisher, final HomeSummaryUpdateService service) {
        super(publisher);
        this.service = service;
    }

    @Override
    protected Optional<Object> handleEvent(final ReadEvent event) {
        service.readDocumentSummary(event.userId(), event.documentId());
        return Optional.empty();
    }

    @Override
    public boolean canListen(final Class<?> clazz) {
        return clazz.isAssignableFrom(ReadEvent.class);
    }
}
