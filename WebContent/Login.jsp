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
<title>登录注册界面</title>
</head>
<body>
<div class="container" >
	<div class="row clearfix">
	<br>
			<br>
			<br>
			<br>
			<h1 align="center" >·GodZmooc·</h1>
			<br>
			<br>
			<br>
			<br>
			<br>
		<div class="col-md-6 column">
			<h1 class="text-info text-center">
				·登录·
			</h1>
			
			<form role="form" action="login" method="post">
				<div class="form-group">
					 <label for="user.username">用户名</label><input type="text" class="form-control" id="user.username" name="user.username"/>
				</div>
				<div class="form-group">
					 <label for="user.password">密码</label><input type="password" class="form-control" id="user.password" name="user.password"/>
				</div>
				 <button type="submit" class="btn btn-default">登录</button>
			</form>
		</div>
		<div class="col-md-6 column">
			<h1 class="text-info text-center">
				·注册·
			</h1>
			<form role="form" action="regist" method="post">
				<div class="form-group">
					 <label for="user.username">用户名</label><input type="text" class="form-control" id="user.username" name="user.username" />
				</div>
				<div class="form-group">
					 <label for="user.password">密码</label><input type="password" class="form-control" id="user.password" name="user.password"/>
				</div>
	<label>选择用户类型：
		<input type="radio" name="user.type" id="user.type" value="teacher"> 老师
	</label>
	<label>
		<input type="radio" name="user.type" id="user.type" value="student">学生
	</label>
				<br> <button type="submit" class="btn btn-default">注册</button>
			</form>
		</div>
	</div>
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