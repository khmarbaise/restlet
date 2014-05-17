package com.soebes.training.restlet;

import org.restlet.resource.Get;

public class StageEnvironmentPrevious extends StageEnvironmentBase {

    @Get("txt")
    public String toTxt() {
	return getStageId() + " " + getEnvId();
    }

}
