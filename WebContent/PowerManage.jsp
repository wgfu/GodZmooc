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
<nav class="navbar navbar-default" role="navigation">
				<div class="navbar-header">
					 <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button> <a class="navbar-brand" href="MainView.jsp">主页</a>
				</div>
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" >
			
				 
					<ul class="nav navbar-nav navbar-right">
					<s:if test="#session.user==null">
      <li>
							 <a href="Login.jsp" id="login">登录</a>
						</li>
						<li>
							 <a href="Login.jsp" id="regist">注册</a>
						</li>
        </s:if>
        <s:else>
       <li>
							 <a>尊敬的用户：${sessionScope.user.username}&nbsp已登录</a>
						</li>
						<li>
							 <a href="outlogin">退出登录</a>
						</li>
				<li class="dropdown">
							 <a data-toggle="dropdown"  href="#" class="dropdown-toggle"  >个人设置<strong class="caret"></strong></a>
							<ul class="dropdown-menu">
								<li>
									 <a href="UserInfo.jsp">个人信息</a>
								</li>
								<li class="divider">
								</li>
								<li>
									 <a href="#">个人权限</a>
								</li>
								<li class="divider">
								</li>
								<li>
									 <a href="studyManage">已收藏课程</a>
								</li>
								<li class="divider">
								</li>
								<li>
									 <a href="classManage">已发布课程管理</a>
								</li>
							</ul>
						</li>		
        </s:else>
      
						
					</ul>
				</div>
			</nav>
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
					<tr class="success">
						<td>
							deleteComment
						</td>
						<td>
					100
						</td>
						<td>
							<form action="updatePower" method="post">
	<div class="row">
    <div class="col-lg-3">
      <input type="text" class="form-control" placeholder="请输入新LEVEL">
    </div>
    <div class="col-lg-4">
       <button  type="submit" class="btn btn-default">修改</button>
    </div>
  </div>
		</form>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>
<div style="width:80%; position:fixed; left:0; bottom:100px">
					<form class="form-horizontal" action="addPower" method="post">
						<div class="row">
						  <label for="firstname" class="col-sm-2 control-label" style="font-size:15px">添加权限:</label>
						  <label for="firstname" class="col-sm-2 control-label">ACTIONNAME</label>
    <div class="col-lg-2" >
       <input type="text" class="form-control" id="firstname" placeholder="请输入ACTIONNAME">
    </div>
     <label for="lastname" class="col-sm-2 control-label">LEVEL</label>
    <div class="col-lg-2">
       <input type="text" class="form-control" id="lastname" placeholder="请输入LEVEL">
    </div>
    <div class="col-lg-2">
         <button type="submit" class="btn btn-default">添加</button>
    </div>
  </div>
</form>
</div>

<div style="width:100%; position:fixed; left:0; bottom:0;">
			<ul class="breadcrumb">
				<li>
					 <a href="#">主页</a>
				</li>
				<li>
					 <a href="#">Library</a>
				</li>
				<li class="active">
					Data
				</li>
			</ul>
			</div>
</body>
</html>