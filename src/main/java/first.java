import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.ServletContext;

/**
 * Created by faa11 on 24.12.2015.
 */
public class first {
    public static void main(String args[]) throws Exception{
        Frontend frontend = new Frontend();

        ServletContextHandler contex =
                new ServletContextHandler(ServletContextHandler.SESSIONS);
        contex.addServlet(new ServletHolder(frontend), "/*");
        Server server = new Server(8080);
        server.setHandler(contex);
        server.start();
        server.join();
    }
}
