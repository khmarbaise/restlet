package com.soebes.training.restlet;

import java.util.concurrent.TimeUnit;

import org.restlet.Component;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class IntegrationTestBase {

    protected final Configuration configuration = Configuration.DEFAULT;
    private Component component;

    @BeforeTest
    public void beforeTest() throws Exception {
        component = new Component();
        component.getServers().add(configuration.getProtcol(), configuration.getPort());
    
        FirstApplication application = new FirstApplication();
        component.getDefaultHost().attach(application);
        component.start();

        while (!component.isStarted()) {
            Thread.sleep(TimeUnit.MILLISECONDS.toMillis(100));
        }
    }

    @AfterTest
    public void afterTest() throws Exception {
        component.stop();
    }

}
