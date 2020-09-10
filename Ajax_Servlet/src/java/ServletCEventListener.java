import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
/*
 * Web application lifecycle listener.
 * @author Sourabh
 */
public class ServletCEventListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Servlet Context Initialization.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Servlet Context destroy.");
    }
}