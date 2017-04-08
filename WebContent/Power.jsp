<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 引入 Bootstrap -->
<script src="http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js">
</script>
      <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
        <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
       <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>查看权限</title>
</head>
<body>
<div class="container" style="width:100%">
	<div class="row clearfix">
	 <jsp:include page="header.jsp" flush="true"></jsp:include>  
		<div class="col-md-12 column">
			<h3 class="text-center text-info">
			·查看所有用户权限·
			</h3>
			<table class="table">
			
				<thead>
				
					<tr>
						<th>
							用户名
						</th>
						<th>
							用户类别
						</th>
						<th>
							拥有权限
						</th>
						<th>
							修改该用户权限
						</th>
					</tr>
				</thead>
				<tbody>
				<%int i=0; %>
				<s:iterator value="#session.UserPowerList" var="UserPowerList">
				<% 
				if(i%2==0)
				{i++;%>
					<tr>
						<td>
							${UserPowerList.username }
						</td>
						<td>
							${UserPowerList.type }
						</td>
						<td>
							${UserPowerList.power}
						</td>
						<td>
						<form action="changeUserPower" method="post">
							<input type="hidden" value="${UserPowerList.userid}" name="userid">
							<input type="text" name="power" style="width:40px"> 
							<input type="submit" value="修改">
							</form>
						</td>
					</tr>
					<% 
				} else{
				%>
					<tr class="info">
						<td>
							${UserPowerList.username }
						</td>
						<td>
							${UserPowerList.type }
						</td>
						<td>
							${UserPowerList.power}
						</td>
						<td>
						<form action="changeUserPower" method="post">
							<input type="hidden" value="${UserPowerList.userid}" name="userid">
							<input type="text" name="power" style="width:40px"> 
							<input type="submit" value="修改">
							</form>
						</td>
					</tr>
					
					<%
					i++;} 
					%>
				</s:iterator>
				</tbody>
			</table>
			
		</div>
		
	</div>
</div>
<div>
		<br>
		<br>
		<br>
		<br>
		
		</div>
 <jsp:include page="footer.jsp" flush="true"></jsp:include>  
</body>
</html>