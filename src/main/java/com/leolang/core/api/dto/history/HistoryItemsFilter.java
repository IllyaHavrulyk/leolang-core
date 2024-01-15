package com.leolang.core.api.dto.history;

import java.time.ZonedDateTime;

public class HistoryItemsFilter {
    private int limit;
    private ZonedDateTime beforeDate;
    private ZonedDateTime afterDate;
    private String sourceLanguage;
    private String targetLanguage;
    private int pages;
}
