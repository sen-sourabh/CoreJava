import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloWorld implements Servlet{
    @Override
    public void init(ServletConfig config) throws ServletException {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        //To change body of generated methods, choose Tools | Templates.
        String name = req.getParameter("name");
        PrintWriter out = res.getWriter();
        out.print("Hello " + name);
    }

    @Override
    public String getServletInfo() {
        return null;
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void destroy() {
        //To change body of generated methods, choose Tools | Templates.
    }
}
