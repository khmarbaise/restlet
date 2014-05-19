package com.soebes.training.domain;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Environments {

    private Map<String, Environment> environments;

    public Environments() {
	environments = new ConcurrentHashMap<String, Environment>();
    }

    public void add(String envId, Environment env) {
	checkNotNull(envId, "Null is not allowed for envId");
	checkNotNull(env, "Null is not allowed for env");
	environments.put(envId, env);
    }

    public void remove(Environment env) {
	// TODO:
    }

    public Environment getEnvironment(String envId) {
	checkNotNull(envId, "Null is not allowed for envId");
	checkArgument(environments.containsKey(envId), "The entry %s does not exist.", envId);
	return environments.get(envId);
    }

    public void getEnvironments() {
	//
    }

}
