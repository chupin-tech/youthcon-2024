package com.chupintech.youthcon2024.document.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chupintech.youthcon2024.document.domain.Document;
import com.chupintech.youthcon2024.document.domain.DocumentRepository;
import com.chupintech.youthcon2024.document.domain.ReceiveCommand;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class DocumentService {

	private final DocumentRepository repository;

	@Transactional
	public void receive(final ReceiveCommand command) {
		log.info("========== DocumentService.receive Start Command: {} ==========", command);

		final Document document = Document.newOf(command);
		repository.save(document);

		log.info("========== DocumentService.receive End ==========");
	}

	@Transactional
	public void read(final long documentId) {
		log.info("========== DocumentService.read Start documentId: {} ==========", documentId);

		final Document document = repository.findById(documentId)
			.orElseThrow(() -> new IllegalArgumentException(String.format("There is no document(%d).", documentId)));

		document.read();

		log.info("========== DocumentService.read End ==========");
	}
}
