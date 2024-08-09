package com.chupintech.youthcon2024.document.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.chupintech.youthcon2024.document.domain.ReceiveCommand;

@SpringBootTest
class DocumentServiceTest {

	@Autowired
	private DocumentService service;

	@Test
	void receive() throws InterruptedException {
		// given

		// when
		service.receive(new ReceiveCommand("testUserId1", "testTitle1", "testBody1"));

		// then
		Thread.sleep(500L);
	}

	@Test
	void read() throws InterruptedException {
		// given

		// when
		service.read(1L);

		// then
		Thread.sleep(500L);
	}
}