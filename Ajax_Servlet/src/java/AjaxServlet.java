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
public class AjaxServlet extends HttpServlet {
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
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        HttpSession session = req.getSession();
        session.setAttribute("name", name);
        session.setAttribute("email", email);
        session.setAttribute("address", address);
        System.out.println("Session Created in AjaxServlet.");
        PrintWriter out = res.getWriter();
        out.println("Name: " + name);
        out.println("Email: " + email);
        out.println("Address: " + address);
        try{
                Class.forName(driver);
                Connection con = DriverManager.getConnection(url, username, password);
                String sql = "INSERT INTO student (student_fname, student_lname, student_email, student_grade,"
                        + " student_gender, student_course, student_mobileno, student_spec) VALUES "
                        + "(?,?,?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, name);
                ps.setString(2, "singh");
                ps.setString(3, email);
                ps.setString(4, "7.63");
                ps.setString(5, "male");
                ps.setString(6, "BE");
                ps.setString(7, "9893564045");
                ps.setString(8, address);
                ps.execute();
                out.println("<h1 style='color:green'>Registration Successful :) <a href='./logout'>Logout</a></h1>");
                con.close();
            } catch (SQLException | ClassNotFoundException ex) {
                out.println("<h1 style='color:red'>Registration Failed :(</h1>");
                out.println("<h1 style='color:red'>Registration Failed : " + ex.getMessage() + " :(</h1>");
            }
    }

}
