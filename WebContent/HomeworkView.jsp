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
			 <jsp:include page="header.jsp" flush="true"></jsp:include>  
			</div>
			<s:if test="#session.homeWorkMessage!=null">
			<div class="span12">
			<h1 class="text-center text-info">
			<big>${sessionScope.homeWorkMessage.homeworkname}</big>	
			</h1>
			<div  style="position:absolute;width:60%;left:20%;overflow:auto;height:100px" >
			
	<p class="list-group-item-text">
		<h3 align="center">作业简介：</h3>
					&nbsp&nbsp&nbsp${sessionScope.homeWorkMessage.introduction}
					</p>
					</div>
		</div>
		
		
		
			<div style="width:85%;position:absolute;left:160px;top:250px;height:62% " >
				<iframe src="${sessionScope.homeWorkMessage.url}" width="100%" height="100%"> </iframe>
				</div>
				
			
				
				<div style="width:100%; position:fixed; left:47%; bottom:56px;">
	
<a href="${sessionScope.homeWorkMessage.answerurl}" class="btn btn-primary btn-large">查看作业答案</a>
</div>
</s:if>
<s:else>
<div align="center"><h1>暂无布置作业</h1></div>

</s:else>
	</div>
</div>
		
 <jsp:include page="footer.jsp" flush="true"></jsp:include>  
</body>
</html>