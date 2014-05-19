package com.soebes.training.restlet;

import static org.fest.assertions.api.Assertions.assertThat;

import java.io.IOException;

import org.restlet.Client;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.data.Method;
import org.restlet.data.Protocol;
import org.restlet.data.Reference;
import org.restlet.data.Status;
import org.restlet.resource.ResourceException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class StageEnvironmentCurrentIT extends IntegrationTestBase {

    @DataProvider
    public Object[][] getStages() {
	//@formatter:off
	return new String[][] {
		{"dev-1", "x1"},
		{"dev-2", "x2"},
		{"prod-1", "x3"},
	};
	//@formatter:on
    }

    @Test(dataProvider = "getStages")
    public void shouldReturnMessageForStageAndEnvironment(String stage, String envId) throws ResourceException, IOException {
	Client client = new Client(Protocol.HTTP);
	Reference addSegment = configuration.getReference().addSegment("stage").addSegment(stage).addSegment(envId).addSegment("current");
	Request request = new Request(Method.GET, addSegment);
	Response response = client.handle(request);

	assertThat(response.getStatus()).isEqualTo(Status.SUCCESS_OK);
	assertThat(response.getEntityAsText()).isEqualTo(stage + " " + envId);
    }

}
