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
		<div>
		<br>
		
		</div>
		<div class="col-md-1 column">
		</div>
		<div class="col-md-10 column" >
		<div style="position:absolute;overflow:auto;width:100%;height:540px">
		<table >
		<tr height="45px">
        <td width="10%">
        
        </td>	
         <td width="70%">
           <h4><big>  &nbsp&nbsp ${sessionScope.DiscussionMessage.title }</big></h4>
        </td>	
        		
		</tr>
		
			<tr height="30px">
        <td style="border-bottom:1px dashed #00CCCC;">
         &nbsp&nbsp   &nbsp&nbsp ${sessionScope.DiscussionMessage.username }
        </td>	
         <td style="border-bottom:1px dashed #00CCCC;">
        &nbsp&nbsp  楼主&nbsp|&nbsp&nbsp${sessionScope.DiscussionMessage.time }
        </td>	
         		
		</tr>
		<tr height="300px">
        <td style="border-top:1px dashed #00CCCC;">
         <div align="center">
         <img src="Image/yuwen.png" width="140px" height="160px">
         </div>
        </td>	
         <td style="border-top:1px dashed #00CCCC;">
         <div style="text-align:center;overflow:auto;height:290px">
        <h4>
        ${sessionScope.DiscussionMessage.text }
         </h4>
         </div>
        </td>	
       	</tr>
		<s:if test="#session.ReplyList!=null">
		<s:iterator value="#session.ReplyList" var="ReplyList">
		<tr height="30px">
        <td style="border-bottom:1px dashed #00CCCC;">
      &nbsp&nbsp  &nbsp&nbsp  ${ReplyList.username }
        </td>	
         <td style="border-bottom:1px dashed #00CCCC;">
       &nbsp&nbsp   <s:if test="#session.user.userid==#ReplyList.userid">楼主&nbsp|&nbsp</s:if> ${ReplyList.time }
        </td>	
         		
		</tr>
		<tr height="300px">
        <td style="border-top:1px dashed #00CCCC;">
        <div align="center">
         <img src="Image/yuwen.png" width="140px" height="160px">
         </div>
        </td>	
         <td style="border-top:1px dashed #00CCCC;">
        <div style="text-align:center;overflow:auto;height:290px">
        <h4>
        ${ReplyList.text }
         </h4>
         </div>
        </td>	
         		
		</tr>
		</s:iterator>
		</s:if>
		
		</table>
		</div>
		<div class="list-group-item" style="width:60%; position:fixed; top:68%; height:25%;left:20%">
					<h4>发贴:</h4>
						<form action="addReply" method="post">
						
					<input type="hidden" name="reply.replyid" value="${sessionScope.DiscussionMessage.replyid}">
					<input type="hidden" name="discussionid" value="${sessionScope.DiscussionMessage.discussionid}">
						<textarea name="reply.text" cols="100" rows="7"></textarea>
						
					<input type="submit" value="发表回复">
					
						</form>
					</div>
		
		</div>
		<div class="col-md-1 column">
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