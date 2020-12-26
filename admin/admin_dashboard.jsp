<!doctype html>
<html lang="en">
 <head>
  <link rel="stylesheet" type="text/css" href="../css/common.css" />
  
  
  <title>ADMIN-DASHBOARD</title>
 </head>
 <body>
  <div id="main_container">
	<% 
		request.setAttribute("isadmin",1);
	%>

	<%@ include file="../header.jsp" %>
	
	<%@ include file="admin_menubar.jsp" %>

	

	<%@ include file="../footer.jsp" %>
  </div>

  <script src="../js/common.js"></script>
 </body>
</html>
