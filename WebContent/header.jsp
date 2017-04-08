<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    
<title></title>
</head>
<body>
			<nav class="navbar navbar-default" role="navigation">
				<div class="navbar-header">
					 <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button> <a class="navbar-brand" href="index.jsp">主页</a>
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
									 <a href="getMyPower">个人权限</a>
								</li>
								<li class="divider">
								</li>
								<s:if test="#session.user.power>100">
								<li>
									 <a href="getAllUserPowerInfo" target="_blank">用户权限管理</a>
								</li>
								<li class="divider">
								</li>
							</s:if>
							<s:if test="#session.user.power>150">
								<li>
									 <a href="getAllPowerInfo" target="_blank">权限管理</a>
								</li>
								<li class="divider">
								</li>
									</s:if>
								<li>
									 <a href="studyManage">已收藏课程</a>
								</li>
								<li class="divider">
								</li>
								<li>
									 <a href="classManage">已发布课程管理</a>
								</li>
								<li class="divider">
								</li>
								<li>
									 <a href="Chat.jsp" target="_blank">聊天室</a>
								</li>
							</ul>
						</li>		
        </s:else>
      
						
					</ul>
				</div>
			</nav>
			

</body>
</html>