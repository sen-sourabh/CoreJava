import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
/*
 * Web application lifecycle listener.
 * @author Sourabh
 */
public class ServletSEventListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("Session Created.");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("Session Destroy.");
    }
}