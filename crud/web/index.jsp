<%@page import="java.sql.*" %>
<%@include file="config.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    
    if(request.getParameter("save") != null) {
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String email = request.getParameter("email");
        String password = request.getParameter("pass");
        String bdate = request.getParameter("bd");
        String subject = request.getParameter("sub");
        java.util.Date jdate = new java.util.Date();
        String joindate = jdate.toString();
        ps = conn.prepareStatement("INSERT INTO user (name, email, password, birthdate, gender, subject, joindate) VALUES (?,?,?,?,?,?,?)");
        ps.setString(1, name);
        ps.setString(2, email);
        ps.setString(3, password);
        ps.setString(4, bdate);
        ps.setString(5, gender);
        ps.setString(6, subject);
        ps.setString(7, joindate);
        ps.execute();
    
%>
<!--        <script>
            alert("Record Added Successfully.");
        </script>-->
<%
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> CRUD </title>
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    </head>
    <body style="margin: 10px;">
        <div class="fluid-container">
            <h1> Simple CRUD in Java using JSP </h1>
            <br><br>
            <div class="row">
                <div class="col-md-3">
                    <form action="#" method="POST">
                        <input class="form-control" required type="text" name="name" placeholder="Name"/>
                        <br>
                        <input class="form-control" required type="email" name="email" placeholder="Email"/>
                        <br>
                        <input class="form-control" required type="password" name="pass" placeholder="Password"/>
                        <br>
                        <input class="form-control" required type="date" name="bd"/>
                        <br>
                        <select name="gender" class="form-control" required>
                            <option value=""> Select Gender </option>
                            <option value="male"> Male </option>
                            <option value="female"> Female </option>
                            <option value="transgender"> Transgender </option>
                        </select>
                        <br>
                        <input type="radio" name="sub" value="php"/> PHP <br>
                        <input type="radio" name="sub" value="java"/> JAVA <br>
                        <br>
                        <input class="btn btn-success" name="save" type="submit" value="Save"/>
                        <input class="btn btn-warning" name="reset" type="reset" value="Reset"/>
                    </form>
                </div>
                <div class="col-md-9">
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>S.No.</th>
                                <th>Name</th>
                                <th>Email</th>
                                <th>Birth Date</th>
                                <th>Gender</th>
                                <th>Subject</th>
                                <th>Join Date</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% 
                                st = conn.prepareStatement("SELECT * FROM user");
                                rs = st.executeQuery();
                                while(rs.next()) {
                                    String userid = rs.getString("user_id");
                            %>
                            <tr>
                                <td><%=rs.getString("user_id")%></td>
                                <td><%=rs.getString("name")%></td>
                                <td><%=rs.getString("email")%></td>
                                <td><%=rs.getString("birthdate")%></td>
                                <td><%=rs.getString("gender")%></td>
                                <td><%=rs.getString("subject")%></td>
                                <td><%=rs.getString("joindate")%></td>
                                <td><a href="update.jsp?userid=<%=userid%>&edit=<%=1%>" class="btn btn-info"> Edit </a> | <a href="delete.jsp?userid=<%=userid%>" class="btn btn-danger"> Delete </a></td>
                            </tr>
                            <%
                                }
                            %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
