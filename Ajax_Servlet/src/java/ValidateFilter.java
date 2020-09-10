import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/*
 * @author Sourabh
 */
public class ValidateFilter implements Filter {
    private static final boolean debug = false;
    private FilterConfig filterConfig = null;
    
    public ValidateFilter() {
        System.out.println("Filter Object Initialize.");
    }
    
    public void init(FilterConfig filterConfig) {        
        System.out.println("Filter Initialization.");
    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        PrintWriter out = res.getWriter();
        if(name.equals("")) {
            out.println("Name is required.");
        } else if(email.equals("")) {
            out.println("Email is required.");
        } else if(address.equals("")) {
            out.println("Address is required.");
        } else {
            out.println("<div style='border: 1px dashed red; color:green;font-weight:bold;'>");
            out.println("<pre>");
            chain.doFilter(req, res);
            out.println("</pre>");
            out.println("</div>");
        }
    }
    
    public void destroy() {        
        System.out.println("Destroy Filter.");
    }
    
}
