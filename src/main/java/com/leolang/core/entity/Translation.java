package com.leolang.core.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Translation {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    private String sourceLanguage;
    private String sourceText;
    private String translationLanguage;
    private String translationText;
}
