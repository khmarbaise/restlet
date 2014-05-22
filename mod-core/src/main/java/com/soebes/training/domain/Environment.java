package com.soebes.training.domain;

public class Environment {

    private String id;

    private Version current;
    private Version previous;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
