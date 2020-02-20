package com.xtel.services;

import com.xtel.logging.LoggingClass;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

public class App {
    public static void main(String[] args) {
        ResourceConfig config = new ResourceConfig();
        config.packages("com.xtel.services");
        ServletHolder servlet = new ServletHolder(new ServletContainer(config));
        Server server = new Server(1213);
        ServletContextHandler context = new ServletContextHandler(server, "/*");
        context.addServlet(servlet, "/*");

        try {
            server.start();
            System.out.println(server.toString());
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
            LoggingClass.getLogger().error(e);
        }
        server.destroy();
    }


}
