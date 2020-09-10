<%@include file="config.jsp"%>
<%
    ps = conn.prepareStatement("DELETE FROM user WHERE user_id=?");
    ps.setString(1, request.getParameter("userid"));
    ps.execute();
    response.sendRedirect("index.jsp");
%>