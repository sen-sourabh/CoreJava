import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * @author Sourabh
 */
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        PrintWriter out =  response.getWriter();
        out.println("Name : " + session.getAttribute("name") + "AND Email : " + session.getAttribute("email")
                + "AND Address : " + session.getAttribute("address"));
        session.invalidate();
        out.println("session invalidate.");
        try {
            Thread.sleep(5000);
            response.sendRedirect("http://localhost:8084/Ajax_Servlet/");
        } catch(Exception ex) {
            System.out.println("Excetion : " + ex.getMessage());
        }
    }

}
