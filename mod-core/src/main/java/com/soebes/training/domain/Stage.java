package com.soebes.training.domain;

public class Stage {

    private String version;
    private int build;

    public String getVersion() {
	return version;
    }

    public Stage setVersion(String version) {
	this.version = version;
	return this;
    }

    public int getBuild() {
	return build;
    }

    public Stage setBuild(int build) {
	this.build = build;
	return this;
    }

}
