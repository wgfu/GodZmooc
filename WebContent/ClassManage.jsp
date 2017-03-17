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
<title>课程管理</title>
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
	<h3 class="text-error text-center">
				·课程管理·
			</h3>
		<div class="col-md-12 column" style="overflow: auto;height:650px">
			
			
			<table class="table" Style="border-left:solid 0px #333333;
border-bottom:solid 1px #00FFFF;
border-right:solid 0px #333333;
border-top:solid 0px #333333;"
>
				<thead>
					<tr class="info">
						<th>
							课程名
						</th>
						<th>
							课程类型
						</th>
						<th>
							课程水平
						</th>
						<th>
							作业
						</th>
						<th>
							考试
						</th>
					
						
					</tr>
				</thead>
				<tbody>
				<s:iterator value="#session.classInfo" var="c">
					<tr >
						<td>
							<a href="classMessage?classInfoid=${c.classInfoid}">${c.classname}</a>
						</td>
						<td>
							${c.type}
						</td>
						<td>
						${c.classLevel}
						</td>
						<td>
							<s:if test="#c.homeworkid==null">
							<p><a class="btn btn-primary btn-large" href="AddHomework.jsp?classInfoid=${c.classInfoid}">添加作业 &raquo;</a></p>
							</s:if>
							<s:else>
							<p>已发布作业
							</s:else>
						</td>
						<td>
						<s:if test="#c.testid==null">
							<p><a class="btn btn-primary btn-large" href="AddTest.jsp?classInfoid=${c.classInfoid}">添加考试 &raquo;</a></p>
							</s:if>
							<s:else>
							<p><a class="btn btn-primary btn-large" href="changeTest?testid="+"${c.testid}">查看已收藏该课程学生 &raquo;</a></p>
							</s:else>
						</td>
					
						
					</tr>
					</s:iterator>
				</tbody>
			</table>
				
				${sessionScope.NoclassInfo}
				
		</div>
	</div>
</div>
<div align="center" style="position:fixed; left:47%; bottom:100px;">

<p><a class="btn btn-primary btn-large" href="AddClass.jsp">添加课程 &raquo;</a></p>

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