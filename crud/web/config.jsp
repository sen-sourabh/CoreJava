<%@page import="java.sql.*" %>
<%
    Connection conn;
    PreparedStatement ps, st;
    ResultSet rs;
    Class.forName("com.mysql.jdbc.Driver");
    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud","root","root");
%>