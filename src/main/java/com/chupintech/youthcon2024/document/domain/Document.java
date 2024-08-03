package com.chupintech.youthcon2024.document.domain;

import java.util.Objects;
import java.util.StringJoiner;

import org.springframework.lang.Nullable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
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

	protected Document() {
		// NTD
	}

	protected Document(@Nullable final Long id,
		final String userId, final String title,
		final String body, final boolean read) {

		this.id = id;
		this.userId = userId;
		this.title = title;
		this.body = body;
		this.read = read;
	}

	public static Document newOf(final ReceiveCommand command) {
		return new Document(null, command.userId(), command.title(), command.body(), false);
	}

	public void read() {
		read = true;
	}

	@Override
	public boolean equals(final Object other) {
		if (this == other) {
			return true;
		}

		if (other == null || getClass() != other.getClass()) {
			return false;
		}

		final Document document = (Document)other;
		return Objects.equals(id, document.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", Document.class.getSimpleName() + '[', "]")
			.add("id=" + id)
			.add("userId='" + userId + '\'')
			.add("title='" + title + '\'')
			.add("body='" + body + '\'')
			.toString();
	}
}
