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
<title>查看个人权限</title>
</head>
<body>
<div class="container" style="width:100%">
	<div class="row clearfix" >
	 <jsp:include page="header.jsp" flush="true"></jsp:include>  
		<div class="col-md-12 column" style="position:absoluted;left:10%;width:80%">
			<h3 class="text-center text-info">
			·查看个人权限·
			</h3>
			<table class="table" >
			
				<thead>
				
					<tr>
						<th>
							用户名
						</th>
						<th>
							用户类别
						</th>
						<th>
							权限级别
						</th>
						
					</tr>
				</thead>
				<tbody>
				
					<tr class="info">
						<td>
							${sessionScope.user.username}
						</td>
						<td>
							${sessionScope.user.type}
						</td>
						<td>
							${sessionScope.user.power}
						</td>
						</td>
						
					</tr>
					
				
				</tbody>
			</table>
			<br>
				<h3 class="text-center text-info">
			·所有权限等级·
			</h3>
			<table class="table" >
			
				<thead>
				
					<tr>
						<th>
							操作名称
						</th>
						<th>
							权限级别
						</th>
						<th>
							权限级别是否达到
						</th>
						
					</tr>
				</thead>
				<tbody>
				<s:iterator value="#session.PowerList" var="PowerList">
					<tr >
						<td>
							${PowerList.actionName}
						</td>
						<td>
								${PowerList.level}
						</td>
						<td>
							<s:if test="#session.user.power>#PowerList.level">
							是
							</s:if>
							<s:else>
							否
							</s:else>
						</td>
						
					</tr>
					
					
					</s:iterator>
				
				</tbody>
			</table>
			<div>
			<br>
			<br>
			<br>
			<br>
			</div>
		</div>
	</div>
</div>
 <jsp:include page="footer.jsp" flush="true"></jsp:include>  
</body>
</html>