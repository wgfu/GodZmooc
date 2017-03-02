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
<title>课程资源</title>
</head>
<body>

<div class="container" style="width:100%" >
<div class="row clearfix">
<div class="col-md-12 column">

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
			<div class="list-group">
				 <div class="list-group-item">
				 <form role="form" action="findResource" method="post">	
		<label for="name" >课程类型：</label>
		<select class="selectpicker" name="type">
			<option value="">请选择课程类型</option>
			<option value="语文" >语文</option>
			<option value="数学" >数学</option>
			<option value="英语" >英语</option>
			<option value="化学" >化学</option>
			<option value="物理" >物理</option>
			<option value="生物" >生物</option>
			<option value="地理" >地理</option>
			<option value="历史"  >历史</option>
			<option value="政治" >政治</option>
			<option value="音乐" >音乐</option>
			<option value="计算机" >计算机</option>
			
		</select>
		&nbsp&nbsp&nbsp&nbsp
		  <label for="name" >课程水平：</label>
		  <select class="selectpicker" name="classLevel">
			<option value="">请选择课程水平</option>
			<option value="小学" >小学</option>
			<option value="初中" >初中</option>
			<option value="高中">高中</option>
			<option value="大学">大学</option>
			<option value="硕士">硕士</option>
			<option value="博士">博士</option>
		</select>
&nbsp&nbsp&nbsp&nbsp
		 <label for="name">课程资源类型：</label>
		  <select class="selectpicker" name="resourceType" >
			<option value="">请选择课程资源类型</option>
			<option value="文字教学">文字教学</option>
			<option value="视频教学">视频教学</option>
			
		</select>
		&nbsp&nbsp&nbsp&nbsp
		<button type="submit" class="btn btn-default">搜索</button>
</form>		
</div>
				<div class="list-group-item active">
					<h4>搜索结果</h4>
				</div>
				${sessionScope.NoResource}
				<s:iterator value="#session.classInfoList" >
				<div class="list-group-item">
					<h2>
						${classname}
					</h2>
					<table>
					<tr>
					<td>
					<h5>
					${classLevel}
					&nbsp&nbsp&nbsp&nbsp
					${type}
					&nbsp&nbsp&nbsp&nbsp
					${time}
					</h5>
					</td>
					<td>
					&nbsp&nbsp&nbsp&nbsp
					<a class="btn btn-primary btn-large" href="classMessage?classInfoid="+"${classInfoid}">查看课程详细内容 »</a>
					</td>
					</tr>
					</table>
					<p class="list-group-item-text">
						${introduction}
					</p>
				</div>
				</s:iterator>
				 
			</div>
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