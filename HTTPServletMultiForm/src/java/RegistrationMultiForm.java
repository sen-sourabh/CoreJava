import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * @author Sourabh
*/
public class RegistrationMultiForm extends HttpServlet {
    String driver = null;
    String url = null;
    String username = null;
    String password = null;
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext sc = config.getServletContext();
        driver = sc.getInitParameter("driver");
        url = sc.getInitParameter("url");
        username = sc.getInitParameter("username");
        password = sc.getInitParameter("password");
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession hs = req.getSession();
        
        if(Boolean.parseBoolean(req.getParameter("form1"))) {
            String fname = req.getParameter("firstname");
            String lname = req.getParameter("lastname");
            String email = req.getParameter("email");
            hs.setAttribute("fname", fname);
            hs.setAttribute("lname", lname);
            hs.setAttribute("email", email);
            res.sendRedirect("index1.html");
        } else if(Boolean.parseBoolean(req.getParameter("form2"))) {
            String grade = req.getParameter("grade");
            String gender = req.getParameter("gender");
            String course = req.getParameter("course");
            hs.setAttribute("grade", grade);
            hs.setAttribute("gender", gender);
            hs.setAttribute("course", course);
            res.sendRedirect("index2.html");
        } else if(Boolean.parseBoolean(req.getParameter("form3"))) {
            String mobileno = req.getParameter("mobileno");
            String spec = req.getParameter("spec");
            PrintWriter out = res.getWriter();
            try{
                Class.forName(driver);
                Connection con = DriverManager.getConnection(url, username, password);
                String sql = "INSERT INTO student (student_fname, student_lname, student_email, student_grade,"
                        + " student_gender, student_course, student_mobileno, student_spec) VALUES "
                        + "(?,?,?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, (String) hs.getAttribute("fname"));
                ps.setString(2, (String) hs.getAttribute("lname"));
                ps.setString(3, (String) hs.getAttribute("email"));
                ps.setString(4, (String) hs.getAttribute("grade"));
                ps.setString(5, (String) hs.getAttribute("gender"));
                ps.setString(6, (String) hs.getAttribute("course"));
                ps.setString(7, mobileno);
                ps.setString(8, spec);
                ps.execute();
                RequestDispatcher rc = req.getRequestDispatcher("/ColorAppender");
                rc.include(req, res);
                out.println("<h1 style='color:green'>Registration Successful :)</h1>");
                con.close();
            } catch (SQLException | ClassNotFoundException ex) {
                out.println("<h1 style='color:red'>Registration Failed :(</h1>");
                out.println("<h1 style='color:red'>Registration Failed : " + ex.getMessage() + " :(</h1>");
            }
        }
    }
}
