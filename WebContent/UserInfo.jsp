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
<title>用户信息</title>
<style>
label{ font-family:"楷体";
        font-size:20px;
        color:#71171d;
        }
</style>
</head>
<body>
 <jsp:include page="header.jsp" flush="true"></jsp:include>  
<div class="container" >
	<div class="row clearfix">
		<div class="col-md-12 column">
			<h3 class="text-success text-center">
				·个人信息·
			</h3>
		</div>
	</div>
	<div class="row clearfix">
		<div class="col-md-12 column">
			<form role="form" action="userInfo">
				<div class="form-group" >
					 <label for="userInfo.name">姓名</label><input type="text" class="form-control" id="userInfo.name" name="userInfo.name"
					 value="${sessionScope.userInfo.name}"/>
				</div>
				<div class="form-group" >
					 <label for="userInfo.birth">出生日期</label><input type="date" class="form-control" id="userInfo.birth" 
					 name=userInfo.birth value="${sessionScope.userInfo.birth}"/>
				</div>
				<div class="form-group">
					  <label for="userInfo.email" >Email</label><input type="email" class="form-control" id="userInfo.email" 
					  name=userInfo.email value="${sessionScope.userInfo.email}"/>
				</div>
				<div class="form-group">
					  <label for="userInfo.tel" >联系电话</label><input type="tel" class="form-control" id="userInfo.tel"
					   name=userInfo.tel value="${sessionScope.userInfo.tel}"/>
				</div>
				<div class="form-group">
					  <label for="userInfo.school">所在学校</label><input type="text" class="form-control" id="userInfo.school" 
					  name="userInfo.school"
					  value="${sessionScope.userInfo.school}"/>
				</div>
				<div class="form-group">
					  <label for="userInfo.education">教育程度</label>
					  <select class="form-control" name="userInfo.education">
					  <option>${sessionScope.userInfo.education}</option>
      <option>小学</option>
        <option>初中</option>
      <option>中专</option>
      <option>高中</option>
      <option>大专</option>
      <option>本科</option>
      <option>硕士研究生</option>
       <option>博士研究生</option>
        <option>其他</option>
    </select>
				</div>
				<div class="form-group">
					  <label for="userInfo.degree">学位</label>
					    <select class="form-control" name="userInfo.degree">
					    <option>${sessionScope.userInfo.degree} </option>
      <option>学士</option>
      <option>硕士</option>
      <option>博士</option>
         <option>其他</option>
    </select>
				</div>
				 <button type="submit" class="btn btn-default">保存/修改</button>
			</form>
			
		</div>
	</div>
</div>	
 <jsp:include page="footer.jsp" flush="true"></jsp:include>  
</body>
</html>