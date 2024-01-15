package com.leolang.core.service;

import com.leolang.core.api.dto.history.HistoryItemsFilter;
import com.leolang.core.persistence.entity.HistoryItem;

import java.util.List;

public interface HistoryService {
    HistoryItem getById(Long id);
    HistoryItem save(HistoryItem historyItem);
    HistoryItem update(HistoryItem historyItem);
    List<HistoryItem> getAllHistoryItems();
    List<HistoryItem> getHistoryItemsByFilter(HistoryItemsFilter filter);
}
