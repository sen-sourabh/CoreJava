import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * @author Sourabh
 */
public class ValidateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PrintWriter out = res.getWriter();
        RequestDispatcher rd = req.getRequestDispatcher("/RegistrationMultiForm");
        if(Boolean.parseBoolean(req.getParameter("form1"))) {
            String fname = req.getParameter("firstname");
            String lname = req.getParameter("lastname");
            String email = req.getParameter("email");
            if(fname.equals("")) {
                out.println("First Name is required.");
            } else if(lname.equals("")) {
                out.println("Last Name is required.");
            } else if(email.equals("")) {
                out.println("Email is required.");
            } else {
                rd.forward(req, res);
            }
        } else if(Boolean.parseBoolean(req.getParameter("form2"))) {
            String grade = req.getParameter("grade");
            String gender = req.getParameter("gender");
            String course = req.getParameter("course");
            if(grade.equals("")) {
                out.println("Grade is required.");
            } else if(gender.equals("")) {
                out.println("Gender is required.");
            } else if(course.equals("")) {
                out.println("Course is required.");
            } else {
                rd.forward(req, res);
            }
        } else if(Boolean.parseBoolean(req.getParameter("form3"))) {
            String mobileno = req.getParameter("mobileno");
            String spec = req.getParameter("spec");
            if(mobileno.equals("")) {
                out.println("Mobileno is required.");
            } else if(spec.equals("")) {
                out.println("Specification is required.");
            } else {
                rd.forward(req, res);
            }
        }
    }
}
