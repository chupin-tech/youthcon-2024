package com.chupintech.youthcon2024.homesummary.service;

import com.chupintech.youthcon2024.document.domain.ReceiveEvent;
import com.chupintech.youthcon2024.event.AbstractEventListener;
import com.chupintech.youthcon2024.event.EventPublisher;

import java.util.Optional;

public class HomeSummaryReceiveEventListener extends AbstractEventListener<ReceiveEvent> {

    private final HomeSummaryUpdateService service;

    public HomeSummaryReceiveEventListener(final EventPublisher publisher,
                                           final HomeSummaryUpdateService service) {
        super(publisher);
        this.service = service;
    }

    @Override
    protected Optional<Object> handleEvent(final ReceiveEvent event) {
        service.addDocumentSummary(event.userId(), event.documentId(), event.title());
        return Optional.empty();
    }

    @Override
    public boolean canListen(final Class<?> clazz) {
        return ReceiveEvent.class.isAssignableFrom(clazz);
    }
}
