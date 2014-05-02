package com.soebes.training.restlet;

import static org.fest.assertions.api.Assertions.assertThat;

import java.io.IOException;

import org.restlet.Client;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.data.Method;
import org.restlet.data.Protocol;
import org.restlet.data.Status;
import org.restlet.resource.ResourceException;
import org.testng.annotations.Test;

public class SystemResourcesIT extends IntegrationTestBase {

    @Test
    public void shouldReturnMessageForEnvironments() throws ResourceException, IOException {
	Client client = new Client(Protocol.HTTP);
	Request request = new Request(Method.GET, configuration.getReference().addSegment("system"));
	Response response = client.handle(request);

	assertThat(response.getStatus()).isEqualTo(Status.SUCCESS_OK);
	assertThat(response.getEntityAsText()).startsWith("System Message:");
    }
}
