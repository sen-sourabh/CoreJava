<%@page import="java.sql.*" %>
<%@include file="config.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> CRUD | Update</title>
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    </head>
    <body style="margin: 10px;">
        <div class="fluid-container">
            <h1> Simple CRUD in Java using JSP </h1>
            <br><br>
            <div class="row">
                <div class="col-md-3">
                    <%
                        ps = conn.prepareStatement("SELECT * FROM user WHERE user_id=?");
                        ps.setString(1, request.getParameter("userid"));
                        rs = ps.executeQuery();
                        while(rs.next()) {
                    %>
                    <form action="#" method="POST">
                        <input value="<%=rs.getString("name")%>" class="form-control" required type="text" name="name" placeholder="Name"/>
                        <br>
                        <input value="<%=rs.getString("email")%>" readonly class="form-control" required type="email" name="email" placeholder="Email"/>
                        <br>
                        <input value="<%=rs.getString("birthdate")%>" class="form-control" required type="date" name="bd"/>
                        <br>
                        <select name="gender" class="form-control" required>
                            <option value="<%=rs.getString("gender")%>"><%=rs.getString("gender").substring(0, 1).toUpperCase() + rs.getString("gender").substring(1)%></option>
                            <option value=""> Select Gender </option>
                            <option value="male"> Male </option>
                            <option value="female"> Female </option>
                            <option value="transgender"> Transgender </option>
                        </select>
                        <br>
                        <% if(rs.getString("subject").equals("php")) { %>
                            <input type="radio" name="sub" value="php" checked/> PHP <br>
                        <% } else { %>
                            <input type="radio" name="sub" value="php"/> PHP <br>
                        <% }%>
                        <% if(rs.getString("subject").equals("java")) { %>
                            <input type="radio" name="sub" value="java" checked/> JAVA <br>
                        <% } else { %>
                            <input type="radio" name="sub" value="java"/> JAVA <br>
                        <% }%>
                        <br>
                        <input class="btn btn-success" name="update" type="submit" value="Update"/>
                        <input class="btn btn-warning" name="reset" type="reset" value="Reset"/>
                    </form>
                    <%
                        }
                    %>
                </div>
            </div>
        </div>
    </body>
</html>
<%
    
    if(request.getParameter("update") != null) {
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String email = request.getParameter("email");
        String password = request.getParameter("pass");
        String bdate = request.getParameter("bd");
        String subject = request.getParameter("sub");
        ps = conn.prepareStatement("UPDATE user SET name=?, email=?, birthdate=?, gender=?, subject=? WHERE user_id=?");
        ps.setString(1, name);
        ps.setString(2, email);
        ps.setString(3, bdate);
        ps.setString(4, gender);
        ps.setString(5, subject);
        ps.setString(6, request.getParameter("userid"));
        ps.execute();
        response.sendRedirect("index.jsp");
    }
%>