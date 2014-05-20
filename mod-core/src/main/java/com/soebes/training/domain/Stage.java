package com.soebes.training.domain;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Map;

public class Stage {

    public final static String UNKNOWN_VERSION = "UNKOWN";

    public final static Stage UNKNOWN_STAGE = new Stage();

    private String version;

    private Map<String, Environment> environments;
    
    public Stage() {
	this.version = UNKNOWN_VERSION;
    }

    public Stage(String version, int build) {
	super();
	this.version = checkNotNull(version, "Null not allowed for version");
    }

    public String getVersion() {
	return version;
    }

    public Stage setVersion(String version) {
	this.version = checkNotNull(version, "Null not allowed for version");;
	return this;
    }

}
