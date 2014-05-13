package com.soebes.training.restlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Config implements ServletContextListener {
    public void contextInitialized(ServletContextEvent event) {
	System.out.println("contextInitialized()");
    }

    public void contextDestroyed(ServletContextEvent event) {
	System.out.println("contextDetroyed()");
	// Do your thing during webapp's shutdown.
    }
}
