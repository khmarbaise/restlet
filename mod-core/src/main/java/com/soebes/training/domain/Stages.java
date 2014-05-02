package com.soebes.training.domain;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Stages {

    private Map<String, Stage> stages;

    public Stages() {
	stages = new ConcurrentHashMap<String, Stage>();
    }

    public Stage add(String stage) {
	Stage env = new Stage();
	getStages().put(checkNotNull(stage, "Not allowed to give null for stage"), env);
	return env;
    }

    public Map<String, Stage> getStages() {
	return stages;
    }

    public void setStages(Map<String, Stage> stages) {
	this.stages = stages;
    }

}
