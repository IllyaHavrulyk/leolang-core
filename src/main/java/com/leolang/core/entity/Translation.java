package com.leolang.core.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;



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
