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
				·添加课程考试·
			</h3>
			<form role="form" action="addTest" method="post" enctype="multipart/form-data">
  <div class="form-group">
    <label for="name">课程考试名称</label>
    <input type="text" class="form-control" id="name" placeholder="请输入课程作业名称" name="test.testname"> 
  </div>
 
  
   
  <div class="form-group">
    <label for="file">上传考试文件</label>
    <input type="file" id="file" name="file">
    <p class="help-block">请上传WORD文档！！！考试内容统一为20道选择题40分，15道判断题30分，15道填空题30分，共100分！！！</p>
  </div>
  
   <div class="form-group">
    <label for="answerfile">上传考试答案文件</label>
    <input type="file" id="file" name="answerfile">
    <p class="help-block">请上传WORD文档！！！</p>
  </div>
  
  
  <div class="form-group">
    <label for="homework.introduction">请输入一段简单考试介绍</label>
    <textarea class="form-control" rows="3" name="test.introduction"></textarea>
  </div>
  <button type="submit" class="btn btn-primary btn-large">添加考试</button>
  <input type="hidden" name="classInfoid" value="${param.classInfoid}">
</form>
		</div>
	</div>
</div>

 <jsp:include page="footer.jsp" flush="true"></jsp:include>  
</body>
</html>