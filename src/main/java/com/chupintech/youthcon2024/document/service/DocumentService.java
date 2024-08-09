package com.chupintech.youthcon2024.document.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chupintech.youthcon2024.document.domain.Document;
import com.chupintech.youthcon2024.document.domain.DocumentRepository;
import com.chupintech.youthcon2024.document.domain.ReceiveCommand;

@Service
public class DocumentService {

	private static final Logger LOG = LoggerFactory.getLogger(DocumentService.class);

	private final DocumentRepository repository;

	public DocumentService(final DocumentRepository repository) {
		this.repository = repository;
	}

	@Transactional
	public void receive(final ReceiveCommand command) {
		LOG.info("========== DocumentService.receive Start Command: {} ==========", command);

		final Document document = Document.newOf(command);
		repository.save(document);

		LOG.info("========== DocumentService.receive End ==========");
	}

	@Transactional
	public void read(final long documentId) {
		LOG.info("========== DocumentService.read Start documentId: {} ==========", documentId);

		final Document document = repository.findById(documentId)
			.orElseThrow(() -> new IllegalArgumentException(String.format("There is no document(%d).", documentId)));

		document.read();

		LOG.info("========== DocumentService.read End ==========");
	}
}
