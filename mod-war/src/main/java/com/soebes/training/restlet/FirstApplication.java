package com.soebes.training.restlet;

import java.util.Date;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

import com.soebes.training.domain.Stages;

public class FirstApplication extends Application {

    public static final String STAGES = "stages";
    
    public FirstApplication() {
	System.out.println("ctor FirstApplication");
	setDescription("This is the first REST applicaiton");
	setAuthor("I'm the one");
	setName("FirstStages");
    }

    @Override
    public synchronized Restlet createInboundRoot() {
	getContext().getAttributes().put("startTime", new Date());
	getContext().getAttributes().put(STAGES, new Stages());
	
	// Create a router Restlet that routes each call to a
	// new instance of HelloWorldResource.
	Router router = new Router(getContext());
	router.attach("/system", SystemResources.class);
	router.attach("/", RootResource.class);
	//router.attache("/stages/", StagesResource.class); => List all stages
	router.attach("/stage/{stageId}", StageResource.class);
	//FIXME: The following are not Ok.!
	router.attach("/stage/{stageId}/build", StageBuildResource.class);
	router.attach("/stage/{stageId}/version", StageVersionResource.class);

	router.attach("/stage/{stageId}/{envId}/current", StageEnvironmentCurrent.class);
	router.attach("/stage/{stageId}/{envId}/previous", StageEnvironmentPrevious.class);
	return router;
    }
}
