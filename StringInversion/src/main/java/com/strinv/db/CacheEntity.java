package com.strinv.db;

import com.strinv.domain.StringInversion;

import javax.persistence.*;

@Entity
public class CacheEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "key", nullable = false)
    private String key;

    @Column(name = "value", nullable = false)
    private String value;

    public CacheEntity(String key, StringInversion params) {
        this.key = key;
        this.value = params.getString();
    }

    public CacheEntity() {

    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
