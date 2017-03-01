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
<title>用户信息</title>
<style>
label{ font-family:"楷体";
        font-size:20px;
        color:#71171d;
        }
</style>
</head>
<body>
<nav class="navbar navbar-default" role="navigation" >
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
				·个人信息·
			</h3>
		</div>
	</div>
	<div class="row clearfix">
		<div class="col-md-12 column">
			<form role="form" action="userInfo">
				<div class="form-group" >
					 <label for="userInfo.name">姓名</label><input type="text" class="form-control" id="userInfo.name" name="userInfo.name"
					 value="${sessionScope.userInfo.name}"/>
				</div>
				<div class="form-group" >
					 <label for="userInfo.birth">出生日期</label><input type="date" class="form-control" id="userInfo.birth" 
					 name=userInfo.birth value="${sessionScope.userInfo.birth}"/>
				</div>
				<div class="form-group">
					  <label for="userInfo.email" >Email</label><input type="email" class="form-control" id="userInfo.email" 
					  name=userInfo.email value="${sessionScope.userInfo.email}"/>
				</div>
				<div class="form-group">
					  <label for="userInfo.tel" >联系电话</label><input type="tel" class="form-control" id="userInfo.tel"
					   name=userInfo.tel value="${sessionScope.userInfo.tel}"/>
				</div>
				<div class="form-group">
					  <label for="userInfo.school">所在学校</label><input type="text" class="form-control" id="userInfo.school" 
					  name="userInfo.school"
					  value="${sessionScope.userInfo.school}"/>
				</div>
				<div class="form-group">
					  <label for="userInfo.education">教育程度</label>
					  <select class="form-control" name="userInfo.education">
					  <option>${sessionScope.userInfo.education}</option>
      <option>小学</option>
        <option>初中</option>
      <option>中专</option>
      <option>高中</option>
      <option>大专</option>
      <option>本科</option>
      <option>硕士研究生</option>
       <option>博士研究生</option>
        <option>其他</option>
    </select>
				</div>
				<div class="form-group">
					  <label for="userInfo.degree">学位</label>
					    <select class="form-control" name="userInfo.degree">
					    <option>${sessionScope.userInfo.degree} </option>
      <option>学士</option>
      <option>硕士</option>
      <option>博士</option>
         <option>其他</option>
    </select>
				</div>
				 <button type="submit" class="btn btn-default">保存/修改</button>
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