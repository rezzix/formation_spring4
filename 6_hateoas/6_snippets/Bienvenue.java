package com.formation.spring.dto;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Bienvenue {

    private final String content;

    public Bienvenue(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}