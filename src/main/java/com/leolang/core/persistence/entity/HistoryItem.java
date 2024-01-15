package com.leolang.core.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.ZonedDateTime;

@Entity
public class HistoryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private ZonedDateTime createdAt;
    private String sourceText;
    private String sourceLanguage;
    private String targetText;
    private String targetLanguage;
}
