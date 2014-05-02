package com.soebes.training.restlet;

import static org.fest.assertions.api.Assertions.assertThat;

import java.net.URI;

import org.restlet.data.Protocol;
import org.restlet.data.Reference;
import org.testng.annotations.Test;

public class ConfigurationTest {

    private Configuration configuration = Configuration.DEFAULT;

    @Test
    public void shouldReturnHTTPProtocol() {
	assertThat(configuration.getProtcol()).isEqualTo(Protocol.HTTP);
    }

    @Test
    public void shouldReturnPort() {
	assertThat(configuration.getPort()).isEqualTo(9211);
    }

    @Test
    public void shouldReturnLocalHost() {
	assertThat(configuration.getHost()).isEqualTo("localhost");
    }

    @Test
    public void shouldReturnFullURL() {
	assertThat(configuration.getURI()).isEqualTo(
		URI.create("http://localhost:9211/"));
    }

    @Test
    public void shouldReturnReference() {
	Reference reference = new Reference(Protocol.HTTP.getSchemeName(),
		"localhost", 9211, "/", null, null);
	assertThat(configuration.getReference()).isEqualTo(reference);
    }
}
