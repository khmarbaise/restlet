package com.soebes.training.restlet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Put;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

public class StageResource extends ServerResource {
    public static final Logger LOGGER = LogManager.getLogger();

    private static final String ANSWER = "The first Message";

    private String stage;

    @Override
    protected void doInit() throws ResourceException {
	this.stage = getAttribute("stageId");
    }

    // @Override
    // protected void doInit() {
    // getVariants().add(new Variant(MediaType.TEXT_XML));
    // getVariants().add(new Variant(MediaType.TEXT_PLAIN));
    // }
    //
    // @Override
    // protected Representation get(Variant variant) throws ResourceException {
    // if (MediaType.APPLICATION_XML.isCompatible(variant.getMediaType())) {
    //
    // }
    //
    // return null;
    // }
    //
    @Get("txt")
    public String toTxt() {
	LOGGER.debug("We have been called.");
	return ANSWER + " (txt)" + getStage() + Constants.NEWLINE;
    }

    @Get("xml")
    public String toXml() {
	LOGGER.debug("We have been called. (xml)");
	return ANSWER + " (xml)" + getStage() + Constants.NEWLINE;
    }

    @Put
    public Representation store(Representation value) {
	System.out.println("Store has been called.");
	return value;
    }

    public String getStage() {
	return "[" + stage + "]";
    }

    public void setStage(String stage) {
	this.stage = stage;
    }

}
