package com.soebes.training.restlet;

import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

public class StageEnvironmentBase extends ServerResource {

    private String stageId;
    private String envId;

    @Override
    protected void doInit() throws ResourceException {
	this.stageId = getAttribute("stageId");
	this.envId = getAttribute("envId");
    }

    public String getStageId() {
        return stageId;
    }

    public void setStageId(String stageId) {
        this.stageId = stageId;
    }

    public String getEnvId() {
        return envId;
    }

    public void setEnvId(String envId) {
        this.envId = envId;
    }

}
