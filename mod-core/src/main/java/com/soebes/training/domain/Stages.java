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
        checkNotNull(stage, "Not allowed to give null for stage");
        Stage env = new Stage();
        getStages().put(stage, env);
        return env;
    }

    public Stage getStage(String stageId) {
        checkNotNull(stageId, "Null not allowed for stageId");
        if (getStages().containsKey(stageId)) {
            return getStages().get(stageId);
        } else {
            return Stage.UNKNOWN_STAGE;
        }
    }

    public Map<String, Stage> getStages() {
        return stages;
    }

    public Stages setStages(Map<String, Stage> stages) {
        this.stages = checkNotNull(stages, "Not allowed to give null for stages");
        return this;
    }

}
