package com.leolang.core.persistence.repositories;

import com.leolang.core.persistence.entity.HistoryItem;
import org.springframework.data.repository.Repository;

public interface HistoryRepository extends Repository<HistoryItem, Long> {
}
