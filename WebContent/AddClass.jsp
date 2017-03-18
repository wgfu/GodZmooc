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
	 <jsp:include page="header.jsp" flush="true"></jsp:include>  
<div class="container" >
	<div class="row clearfix" >
		<div class="col-md-12 column" >
			
			<h3 class="text-error text-center">
				·添加课程·
			</h3>
			<form role="form" action="addClass" method="post" enctype="multipart/form-data">
  <div class="form-group">
    <label for="name">课程名称</label>
    <input type="text" class="form-control" id="name" placeholder="请输入课程名称" name="classInfo.classname"> 
  </div>
   <div class="form-group">
    	<label for="form-control" >课程类型：</label>
		<select class="form-control" name="type">
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
  </div>
   <div class="form-group">
    <label for="classInfo.type">课程资源类型</label>
    <select name="classInfo.type" class="form-control" >
    <option value="">请选择课程资源类型</option>
               <option value="文字教学">文字教学</option>
                  <option value="视频教学">视频教学</option>
</select>
  </div>
   <div class="form-group">
    <label for="classInfo.classLevel" >课程水平：</label>
		  <select class="form-control" name="classInfo.classLevel">
			<option value="">请选择课程水平</option>
			<option value="小学" >小学</option>
			<option value="初中" >初中</option>
			<option value="高中">高中</option>
			<option value="大学">大学</option>
			<option value="硕士">硕士</option>
			<option value="博士">博士</option>
		</select>
  </div>
  <div class="form-group">
    <label for="file">上传教程文件</label>
    <input type="file" id="file" name="file">
    <p class="help-block">上传WORD教学文档或视频教学文件！！！</p>
  </div>
  
  <div class="form-group">
    <label for="classInfo.introduction">请输入一段简单课程介绍</label>
    <textarea class="form-control" rows="3" name="classInfo.introduction"></textarea>
  </div>
  <button type="submit" class="btn btn-primary btn-large">添加课程</button>
</form>
		</div>
	</div>
</div>
	 <jsp:include page="footer.jsp" flush="true"></jsp:include>
</body>
</html>