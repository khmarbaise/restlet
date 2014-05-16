package com.soebes.training.restlet;

import org.restlet.resource.Get;

public class StageEnvironmentCurrent extends StageEnvironmentBase {

    @Get("txt")
    public String toTxt() {
	return getStageId() + " " + getEnvId();
    }

}
