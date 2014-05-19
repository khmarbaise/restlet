package com.soebes.training.restlet;

import static org.fest.assertions.api.Assertions.assertThat;

import java.io.IOException;

import org.restlet.Client;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.data.MediaType;
import org.restlet.data.Method;
import org.restlet.data.Protocol;
import org.restlet.data.Reference;
import org.restlet.data.Status;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.ResourceException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class StageResourceIT extends IntegrationTestBase {

    @Test
    public void shouldReturnWelcomeMessage() throws ResourceException, IOException {
	Client client = new Client(Protocol.HTTP);
	Request request = new Request(Method.GET, configuration.getURI().toString());
	Response response = client.handle(request);

	assertThat(response.getStatus()).isEqualTo(Status.SUCCESS_OK);
	assertThat(response.getEntityAsText()).isEqualTo("Welcome to the FirstStages !");
    }

    @DataProvider
    public Object[][] getStages() {
	// @formatter:off
	return new String[][] { { "dev-1" }, { "dev-2" }, { "prod-1" }, };
	// @formatter:on
    }

    @Test(dataProvider = "getStages")
    public void shouldReturnMessageForEnvironments(String stage) throws ResourceException, IOException {
	Client client = new Client(Protocol.HTTP);
	Reference addSegment = configuration.getReference().addSegment("stage").addSegment(stage);
	Request request = new Request(Method.GET, addSegment);
	Response response = client.handle(request);

	assertThat(response.getStatus()).isEqualTo(Status.SUCCESS_OK);
	assertThat(response.getEntityAsText()).isEqualTo("The first Message (xml)[" + stage + "]" + Constants.NEWLINE);
    }

    @Test
    public void shouldSetValue() throws ResourceException, IOException {
	Client client = new Client(Protocol.HTTP);
	Reference addSegment = configuration.getReference().addSegment("stage").addSegment("dev-1");
	Representation rep = new StringRepresentation("This is the given message.", MediaType.TEXT_PLAIN);
	Request request = new Request(Method.PUT, addSegment, rep);
	Response response = client.handle(request);

	assertThat(response.getStatus()).isEqualTo(Status.SUCCESS_OK);
	assertThat(response.getEntityAsText()).isEqualTo("This is the given message.");
    }

}
