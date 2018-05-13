package org.server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {    	
    	Server server = new Server(8080);
    	
    	server.setHandler(getJerseyHandler());
    	server.start();
    	server.join(); 
    }
    
    private static Handler getJerseyHandler() {
    	ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
    	handler.setContextPath("/");
    	
    	ServletHolder servlet = handler.addServlet(ServletContainer.class, "/*");
    	servlet.setInitOrder(0);
    	servlet.setInitParameter("jersey.config.server.provider.classnames", EndPoint.class.getCanonicalName()); 
    	return handler;
    }
}
