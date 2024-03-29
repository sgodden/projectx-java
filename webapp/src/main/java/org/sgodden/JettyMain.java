package org.sgodden;

import org.apache.cxf.transport.servlet.CXFServlet;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.util.resource.FileResource;
import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.File;

public class JettyMain {

    public static void main(String[] args) {
        try {
            Server server = new Server(9999);

            ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
            context.setContextPath("/");
            System.out.println(new FileResource(new File("src/main/webapp").toURI().toURL()));
            context.setBaseResource(new FileResource(new File("src/main/webapp").toURI().toURL()));
            context.setInitParameter("contextConfigLocation", "WEB-INF/beans.xml");
            context.addEventListener(new ContextLoaderListener());

            context.addServlet(CXFServlet.class, "/services/*");

            ResourceHandler handler = new ResourceHandler();
            handler.setBaseResource(new FileResource(new File("src/main/webapp").toURI().toURL()));

            HandlerList handlerList = new HandlerList();
            handlerList.setHandlers(new Handler[]{context, handler});

            server.setHandler(handlerList);

            server.start();
            server.join();
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

}
