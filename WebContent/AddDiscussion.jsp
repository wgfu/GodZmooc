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
       <style type="text/css"> 
table 
{ 
border-collapse: collapse; 
border: none; 
width: 100%;

} 
td 
{ 
border: dashed GREY 4px; 

} 
</style> 
<title>查看权限</title>
</head>
<body>
<div class="container" style="width:100%">
	<div class="row clearfix">
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
		
		
		<div class="col-md-12 column" >
			
			<h3 class="text-error text-center">
				·发布帖子·
			</h3>
			<form role="form" action="addDiscussion" method="post" >
  <div class="form-group">
    <label for="name">帖子主题</label>
    <input type="text" class="form-control" id="name" placeholder="请输入帖子主题" name="discussion.title"> 
  </div>
   <div class="form-group">
 	<label for="name" >请选择帖子板块类型：</label>
 	<br>
		<select class="selectpicker" name="type">
			<option value="">请选择帖子板块类型</option>
			<option value="语文讨论区" >语文讨论区</option>
			<option value="数学讨论区" >数学讨论区</option>
			<option value="英语讨论区" >英语讨论区</option>
			<option value="化学讨论区" >化学讨论区</option>
			<option value="物理讨论区" >物理讨论区</option>
			<option value="生物讨论区" >生物讨论区</option>
			<option value="地理讨论区" >地理讨论区</option>
			<option value="历史讨论区"  >历史讨论区</option>
			<option value="政治讨论区" >政治讨论区</option>
			<option value="音乐讨论区" >音乐讨论区</option>
			<option value="计算机讨论区">计算机讨论区</option>
			
		</select>
  
   </div>
 
  
  <div class="form-group">
    <label for="discussion.text">请输入帖子内容</label>
    <textarea class="form-control" rows="20" name="discussion.text"></textarea>
  </div>
  <button type="submit" class="btn btn-primary btn-large">发布帖子</button>
  
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