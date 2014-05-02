package com.soebes.training.restlet;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class RootResource extends ServerResource {

    @Get("txt")
    public String getAsText() {
	return "Welcome to the " + getApplication().getName() + " !";
    }

}
