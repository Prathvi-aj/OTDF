<!doctype html>
<html lang="en">
 <head>
  <link rel="stylesheet" type="text/css" href="../css/common.css" />
  <link rel="stylesheet" type="text/css" href="../css/admin_topics.css" />  
  
  <title>ADMIN-TOPICS</title>
 </head>
 <body>
  <div id="main_container">
	<% 
		request.setAttribute("isadmin",1);
	%>

	<%@ include file="../header.jsp" %>
	
	<%@ include file="admin_menubar.jsp" %>

	
	<table id="topic_box">
		<tr>
			<!-- ###### Topic List ##### -->
			<td class="tpbox_cell">
				<table id="topiclist_tbl">
					<tr>
						<th colspan="2">Topics</th>
					</tr>
					<tr>
						<td id="topic_list">&nbsp;</td>
					</tr>
				</table>				
			</td>
			<!-- ###### Topic Form ##### -->
			<td class="tpbox_cell" id="topic_form_cell"  valign="top">
				<table id="add_topic_box">
					<tr>
						<th>Add Topic:</th>
					</tr>
					<tr>
						<td id="form_cell">						
							<input type="text" name="topic_name" placeholder="Enter New Topic" id="topic_fld" /><br /><br />
							<input type="button" value="Add Topic" id="topic_sbm" />						
						</td>
					</tr>
				</table>
							
			</td>
		</tr>
	</table>

	<%@ include file="../footer.jsp" %>
  </div>

  <script src="../js/common.js"></script>
  <script src="../js/admin_topics.js"></script>
 </body>
</html>
