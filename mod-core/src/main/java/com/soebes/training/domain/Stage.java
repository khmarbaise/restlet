package com.soebes.training.domain;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public class Stage {

    public final static String UNKNOWN_VERSION = "UNKOWN";
    public final static int UNKNONW_BUILD_VERSION = 0;

    public final static Stage UNKNOWN_STAGE = new Stage();

    private String version;
    private int build;

    public Stage() {
	this.version = UNKNOWN_VERSION;
	this.build = UNKNONW_BUILD_VERSION;
    }

    public Stage(String version, int build) {
	super();
	this.version = checkNotNull(version, "Null not allowed for version");
	checkArgument(build >= 0, "0 is not allowed for build");
	this.build = build;
    }

    public String getVersion() {
	return version;
    }

    public Stage setVersion(String version) {
	this.version = checkNotNull(version, "Null not allowed for version");;
	return this;
    }

    public int getBuild() {
	return build;
    }

    public Stage setBuild(int build) {
	checkArgument(build > 0, "0 or less 0 is not allowed for build");
	this.build = build;
	return this;
    }

}
