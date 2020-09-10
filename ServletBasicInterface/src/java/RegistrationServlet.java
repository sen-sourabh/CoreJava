import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/*
 * @author Sourabh
*/
public class RegistrationServlet implements Servlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("RegistrationServlet class Initiate.");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("At User's Request.");
        PrintWriter out = res.getWriter();
        out.println("Welcome!");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("Destroying at ShutDown Server.");
    }   
}
