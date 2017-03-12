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
    
<title>主界面</title>
</head>
<body>
 
<div class="container" style="width:100%">
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
			</div>
			<div class="span12">
			<h1 class="text-center text-info">
			<big>${sessionScope.classMessage.classname}</big>	
			</h1>

			<h6 class="text-center text">
			作者：${sessionScope.author.name}
			</h6>
			<h6 class="text-center text">
			发布时间：${sessionScope.classMessage.time}
			</h6>
		</div>
		<div align="center">
		<a href="addStudayPlan?classInfoid=${sessionScope.classMessage.classInfoid}" class="btn btn-primary btn-large">收藏该课程</a>
		</div>
		<s:if test="#session.classMessage.type=='文字教学'">
		
			<div style="width:85%;position:absolute;left:150px;top:235px;height:58% " >
				<iframe src="${sessionScope.classMessage.url}" width="100%" height="100%"> </iframe>
				</div>
				
				</s:if>
				<s:else>
				<br>
				<br>
				<br>
				<div  style="position:absolute;border:1px solid black;width:1055px;height:600px;left:24%;" >
				<video width="1050" height="600" controls="controls">
  <source src="${sessionScope.classMessage.url}" type="video/mp4" />
  <source src="${sessionScope.classMessage.url}" type="video/ogg" />
  <source src="${sessionScope.classMessage.url}" type="video/webm" />
  <object data="${sessionScope.classMessage.url}" width="1050" height="600">
    <embed src="${sessionScope.classMessage.url}" width="1050" height="600" />
  </object>
</video>
			</div>
				</s:else>
					<div class="list-group-item" style="width:80%; position:absolute; top:85%;left:10%;">
					写评论：<br>
					<br>
					<form action="addComment" method="post">
					<input type="hidden" name=comment.commentid value="${sessionScope.classMessage.commentid}">
						&#12288&#12288&#12288&#12288<textarea name="comment.text" cols="80" rows="6"></textarea>
						<br> &#12288&#12288&#12288&#12288&#12288&#12288&#12288&#12288&#12288&#12288&#12288&#12288&#12288&#12288&#12288&#12288&#12288&#12288&#12288&#12288
						&#12288&#12288&#12288&#12288&#12288&#12288&#12288&#12288&#12288&#12288&#12288&#12288&#12288&#12288&#12288&#12288&#12288&#12288&#12288&#12288
						<input type="submit" value="提交评论">
						</form>
					</div>
					<div  style="width:80%; position:absolute; top:1075px;left:10%">
			<ul class="nav nav-pills">
				<li class="active">
					 <a > <span class="badge pull-right">42</span> 全部评论</a>
				</li>
				</ul>
					<div class="list-group-item">
					<table style="border-collapse:separate; border-spacing:15px ;">
					<tr>
					<td colspan="3">
				<img  src="Image/yuwen.png" height="75" width="60"/>
				</td>
				<td>
				<h5> 
				dasdasdasdasds
				&#12288&#12288
				2017-5-5
				
				</h5> 
				  <div style="width:1200px;height:45px;overflow:auto;">
                 <h5>
                 adasdaiodasdasdasdoasdaosndaosndoasndasndasindasod
                  adasdaiodasdasdasdoasdaosndaosndoasndasndasindasod
     
                 </h5>
                  </div>
				</td>
				</tr>
			</table>
				</div>
				
				
				
				
				
				
				
				
				<div>
					<br><br><br><br><br>	<br>	<br><br>
					</div>
					</div>
		
					
					
						
							
					
				<div style="width:100%; position:fixed; left:44%; bottom:56px;">
	<a href="findHomework?homeworkid=${sessionScope.classMessage.homeworkid}" class="btn btn-primary btn-large">查看作业</a>
	&#12288&#12288&#12288
<a href="findTest?testid=${sessionScope.classMessage.testid}" class="btn btn-primary btn-large">查看考试</a>
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