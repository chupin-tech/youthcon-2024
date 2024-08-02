package com.chupintech.youthcon2024.homesummary.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public final class HomeSummaryUpdateService {

    public void addDocumentSummary(final String userId, final long documentId, final String title) {
        log.warn("###### HomeSummaryUpdateService.addDocumentSummary 호출 ######");
    }

    public void readDocumentSummary(final String userId, final long documentId) {
        log.warn("###### HomeSummaryUpdateService.readDocumentSummary 호출 ######");
    }

    public void addNotificationCount(final int count) {
        log.warn("###### HomeSummaryUpdateService.addNotificationCount 호출 ######");
    }
}
