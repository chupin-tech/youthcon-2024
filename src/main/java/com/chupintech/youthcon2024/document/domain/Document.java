package com.chupintech.youthcon2024.document.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = "id")
public class Document {

	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 40)
	private String userId;

	@Column(nullable = false, length = 100)
	private String title;

	@Column(nullable = false, length = 500)
	private String body;

	@Column(nullable = false)
	private boolean read;

	public static Document newOf(final ReceiveCommand command) {
		return new Document(null, command.userId(), command.title(), command.body(), false);
	}

	public ReceiveEvent createReceiveEvent() {
		return new ReceiveEvent(userId, id, title);
	}

	public void read() {
		read = true;
	}

	public ReadEvent createReadEvent() {
		return new ReadEvent(userId, id);
	}
}
