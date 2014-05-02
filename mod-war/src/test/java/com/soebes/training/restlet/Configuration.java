package com.soebes.training.restlet;

import java.net.URI;

import org.restlet.data.Protocol;
import org.restlet.data.Reference;

public class Configuration {

    private final Protocol protcol;
    private final int port;
    private final String host;

    // FIXME: move port to outside so it can be configured from outside
    // (Maven/Jenkins).
    public static final Configuration DEFAULT = new Configuration(Protocol.HTTP, 9211, "localhost");

    public Configuration(Protocol protocol, int port, String host) {
	this.protcol = protocol;
	this.port = port;
	this.host = host;
    }

    public Reference getReference() {
	return new Reference(getProtcol().getSchemeName(), getHost(), getPort(), "/", null, null);
    }
    public URI getURI() {
	return URI.create(protcol.getSchemeName() + "://" + host + ":" + port + "/");
    }

    public Protocol getProtcol() {
	return protcol;
    }

    public int getPort() {
	return port;
    }

    public String getHost() {
	return host;
    }
}