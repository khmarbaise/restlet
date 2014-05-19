package com.soebes.training.restlet;

import org.restlet.resource.Get;

import com.soebes.training.domain.Stage;
import com.soebes.training.domain.Stages;

public class StageEnvironmentCurrent extends StageEnvironmentBase {

    @Get("txt")
    public String toTxt() {
	Stages stages = getStages();
	Stage stage = stages.getStage(getStageId());
	return getStageId() + " " + getEnvId();
    }

}
