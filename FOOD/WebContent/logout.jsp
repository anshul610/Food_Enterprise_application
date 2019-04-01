<% 
session.invalidate();//destroy all session value
response.sendRedirect("Start.jsp");
%>