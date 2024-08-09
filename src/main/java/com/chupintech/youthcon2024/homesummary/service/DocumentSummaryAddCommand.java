package com.chupintech.youthcon2024.homesummary.service;

public record DocumentSummaryAddCommand(String userId, long documentId, String title) {
}
