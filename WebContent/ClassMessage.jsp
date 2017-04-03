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
<script>

	
$(document).ready(function(){
$("input:button[id='addFriends']").click(function() {
	var userid=$(this).attr("name");
		   $.ajax({
	             type: "POST",
	             url: "addFriends",
	             data: {
	            	 userid:userid
	            	 },
	             dataType: "json",
	             success: function(data){
	            	 if(data==1)
	            	 { alert("添加好友成功！！！");}
	            	 else if(data==0)
	            		 {
	            		 alert("已添加该好友！！！");
	            		 }
	            	 else{
	            		 alert("不能添加自己为好友哟！！！");
	            	 }
	                      },
	            	 error: function (msg) {
	            		 alert("添加失败！！！");
	                 }
	         });
	});
	
})
</script>
</head>
<body>
 
<div class="container" style="width:100%">
	<div class="row clearfix">
		<div class="col-md-12 column">
			 <jsp:include page="header.jsp" flush="true"></jsp:include>  
			</div>
			<div class="span12">
			<h1 class="text-center text-info">
			<big>${sessionScope.classMessage.classname}</big>	
			</h1>

			<h6 class="text-center text">
			作者：${sessionScope.author.name} 
			<s:if test="#session.author.userid!=null">
			&nbsp&nbsp<input type="button" id="addFriends" class="btn btn-primary btn-large" value="+" name="${sessionScope.author.userid}">
			
			</s:if>
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
					<div class="list-group-item" style="width:80%; position:absolute; top:89%;left:10%;">
					写评论：<br>
					
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
					 <a > <span class="badge pull-right">${sessionScope.commentCount }</span> 全部评论</a>
				</li>
				</ul>
				<s:if test="#session.commentList!=null">
				<s:iterator value="#session.commentList" var="commentList">
					<div class="list-group-item">
					<table style="border-collapse:separate; border-spacing:15px ;">
					<tr>
					<td colspan="3">
				<img  src="Image/yuwen.png" height="75" width="60"/>
				</td>
				<td>
				<h5> 
				${commentList.username}
				&#12288&#12288
			
				${commentList.time}
				&#12288&#12288
				<input type="button" id="addFriends" class="btn btn-primary btn-large" value="+" name="${commentList.userid}">
				
				</h5> 
				  <div style="width:1200px;height:45px;overflow:auto;">
                 <h5>
                ${commentList.text}
     
                 </h5>
                  </div>
				</td>
				</tr>
			</table>
				</div>
				</s:iterator>
				
				</s:if>
				<s:else>
				     <h3>暂无评论</h3>
				</s:else>
				
				
				
				
				
				
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

 <jsp:include page="footer.jsp" flush="true"></jsp:include>  
</body>
</html>