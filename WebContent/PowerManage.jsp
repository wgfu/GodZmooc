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
<title>修改权限</title>
</head>
<body>
 <jsp:include page="header.jsp" flush="true"></jsp:include>  
<div class="container" >
	<div class="row clearfix">
	
		<div class="col-md-12 column">
			<h3 class="text-success text-center">
				·权限修改·
			</h3>
			<table class="table table-bordered">
				<thead>
					<tr class="warning">
						<th>
							ActionName
						</th>
						<th>
							level
						</th>
						<th>
							修改
						</th>
					</tr>
				</thead>
				<tbody>
				<s:iterator value="#session.PowerInfoList" var="PowerInfoList">
					<tr class="success">
						<td>
							${PowerInfoList.actionName}
						</td>
						<td>
					${PowerInfoList.level}
						</td>
						<td>
							<form action="changePowerInfo" method="post">
	<div class="row">
    <div class="col-lg-3">
      <input type="text" class="form-control" placeholder="请输入新LEVEL" name="level">
      <input type="hidden" value="${PowerInfoList.actionName}" name="actionName">
    </div> 
    <div class="col-lg-4">
       <button  type="submit" class="btn btn-default">修改</button>
    </div>
  </div>
		</form>
						</td>
					</tr>
					</s:iterator>
				</tbody>
			</table>
			
		</div>
		
	</div>
	
		
</div>

		<div>
		<br><br><br><br><br><br><br><br>
		</div>
<div style="width:80%; position:fixed; left:0; bottom:100px">
					<form class="form-horizontal" action="addPowerInfo" method="post">
						<div class="row">
						  <label for="firstname" class="col-sm-2 control-label" style="font-size:15px">添加权限:</label>
						  <label for="firstname" class="col-sm-2 control-label">ACTIONNAME</label>
    <div class="col-lg-2" >
       <input type="text" class="form-control" id="firstname" placeholder="请输入ACTIONNAME" name="power.actionName">
    </div>
     <label for="lastname" class="col-sm-2 control-label">LEVEL</label>
    <div class="col-lg-2">
       <input type="text" class="form-control" id="lastname" placeholder="请输入LEVEL" name="power.level">
    </div>
    <div class="col-lg-2">
         <button type="submit" class="btn btn-default">添加</button>
    </div>
  </div>
</form>
</div>

 <jsp:include page="footer.jsp" flush="true"></jsp:include>  
</body>
</html>