package com.soebes.training.restlet;

import java.util.Date;

import org.restlet.data.MediaType;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.representation.Variant;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class SystemResources extends ServerResource {

    public SystemResources() {
    }

    @Override
    @Get
    protected Representation get(Variant variant) {
	Date startTime = (Date) getContext().getAttributes().get("startTime");
	Date currentTime = new Date();
	
	long millis = currentTime.getTime() - startTime.getTime();
	
	String message = "System Message:" + startTime + " (" + millis + " ms)";

	return new StringRepresentation(message, MediaType.TEXT_PLAIN);
    }
}
