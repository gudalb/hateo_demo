package com.example.hateo_demo;

import org.springframework.hateoas.RepresentationModel;


public class Greeting extends RepresentationModel<Greeting> {

    private String content;

    public Greeting(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
