package com.chupintech.youthcon2024.document.service;

import com.chupintech.youthcon2024.document.domain.Document;
import com.chupintech.youthcon2024.document.domain.DocumentRepository;
import com.chupintech.youthcon2024.document.domain.ReceiveCommand;
import com.chupintech.youthcon2024.event.EventPublisher;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Slf4j
public class DocumentService {

    private final EventPublisher publisher;
    private final DocumentRepository repository;

    @Transactional
    public void receive(final ReceiveCommand command) {
        log.error("!================ DocumentService.receive 시작 ================!");

        final Document document = Document.newOf(command);
        repository.save(document);

        publisher.publish(document.createReceiveEvent());

        log.error("!================ DocumentService.receive 종료 ================!");
    }

    @Transactional
    public void read(final long documentId) {
        log.error("!================ DocumentService.read 시작 ================!");

        final Document document = repository.findById(documentId)
                .orElseThrow(() -> new IllegalArgumentException(String.format("There is no document(%d).", documentId)));

        document.read();

        publisher.publish(document.createReadEvent());

        log.error("!================ DocumentService.read 종료 ================!");
    }
}
