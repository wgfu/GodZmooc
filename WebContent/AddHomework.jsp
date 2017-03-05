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
<title>作业管理</title>
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
	<div class="row clearfix" >
		<div class="col-md-12 column" >
			
			<h3 class="text-error text-center">
				·添加课程作业·
			</h3>
			<form role="form" action="addHomework" method="post" enctype="multipart/form-data">
  <div class="form-group">
    <label for="name">课程作业名称</label>
    <input type="text" class="form-control" id="name" placeholder="请输入课程作业名称" name="homework.homeworkname"> 
  </div>
 
  
   
  <div class="form-group">
    <label for="file">上传作业文件</label>
    <input type="file" id="file" name="file">
    <p class="help-block">请上传WORD文档！！！</p>
  </div>
  
   <div class="form-group">
    <label for="answerfile">上传作业答案文件</label>
    <input type="file" id="file" name="answerfile">
    <p class="help-block">请上传WORD文档！！！</p>
  </div>
  
  
  <div class="form-group">
    <label for="classInfo.introduction">请输入一段简单作业介绍</label>
    <textarea class="form-control" rows="3" name="homework.introduction"></textarea>
  </div>
  <button type="submit" class="btn btn-primary btn-large">添加作业</button>
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