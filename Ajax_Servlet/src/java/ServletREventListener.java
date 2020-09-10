import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
/*
 * Web application lifecycle listener.
 * @author Sourabh
 */
public class ServletREventListener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("Request Initialization.");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("Request Destroy.");
    }
}