package com.formation.spring.dto;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Bienvenue extends ResourceSupport {

    private final String content;

    @JsonCreator
    public Bienvenue(@JsonProperty("content") String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}