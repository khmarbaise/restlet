package com.soebes.training.restlet;

import org.restlet.resource.Get;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

public class StageBuildResource extends ServerResource {

    private String stage;

    @Override
    protected void doInit() throws ResourceException {
	this.stage = getAttribute("stageId");
    }

    @Get("txt")
    public String toTxt() {
	return getStage();
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    
}
