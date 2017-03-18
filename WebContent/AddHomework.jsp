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
 <jsp:include page="header.jsp" flush="true"></jsp:include>  
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
    <label for="homework.introduction">请输入一段简单作业介绍</label>
    <textarea class="form-control" rows="3" name="homework.introduction"></textarea>
  </div>
  <button type="submit" class="btn btn-primary btn-large">添加作业</button>
  <input type="hidden" name="classInfoid" value="${param.classInfoid}">
</form>
		</div>
	</div>
</div>
 <jsp:include page="footer.jsp" flush="true"></jsp:include>  
</body>
</html>