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
		 <jsp:include page="header.jsp" flush="true"></jsp:include>  
			<div class="col-md-1 column" >
			</div>
		<div class="col-md-10 column" >
			
			<h3 class="text-error text-center">
				·发布帖子·
			</h3>
			<form role="form" action="addDiscussion" method="post" >
  <div class="form-group">
    <label for="name">帖子主题</label>
    <input type="text" class="form-control" id="name" placeholder="请输入帖子主题" name="discussion.title"> 
  </div>
   <div class="form-group">
 	<label for="name" >请选择帖子板块类型：</label>
 	<br>
		<select class="selectpicker" name="type">
			<option value="">请选择帖子板块类型</option>
			<option value="语文讨论区" >语文讨论区</option>
			<option value="数学讨论区" >数学讨论区</option>
			<option value="英语讨论区" >英语讨论区</option>
			<option value="化学讨论区" >化学讨论区</option>
			<option value="物理讨论区" >物理讨论区</option>
			<option value="生物讨论区" >生物讨论区</option>
			<option value="地理讨论区" >地理讨论区</option>
			<option value="历史讨论区"  >历史讨论区</option>
			<option value="政治讨论区" >政治讨论区</option>
			<option value="音乐讨论区" >音乐讨论区</option>
			<option value="计算机讨论区">计算机讨论区</option>
			
		</select>
  
   </div>
 
  
  <div class="form-group">
    <label for="discussion.text">请输入帖子内容</label>
    <textarea class="form-control" rows="20" name="discussion.text"></textarea>
  </div>
  <button type="submit" class="btn btn-primary btn-large">发布帖子</button>
  
</form>
		</div>
		<div class="col-md-1 column" >
			</div>
	</div>
</div>
	 <jsp:include page="footer.jsp" flush="true"></jsp:include>  
</body>
</html>