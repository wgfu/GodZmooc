<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 引入 Bootstrap -->
      <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
 
      <!-- HTML5 Shim 和 Respond.js 用于让 IE8 支持 HTML5元素和媒体查询 -->
      <!-- 注意： 如果通过 file://  引入 Respond.js 文件，则该文件无法起效果 -->
      <!--[if lt IE 9]>
         <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
         <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
      <![endif]-->
<title>用户信息</title>
<style>
label{ font-family:"楷体";
        font-size:20px;
        color:#71171d;
        }
</style>
</head>
<body>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<h3 class="text-success text-center">
				·个人信息·
			</h3>
		</div>
	</div>
	<div class="row clearfix">
		<div class="col-md-12 column">
			<form role="form" action="saveUserInfo">
				<div class="form-group" >
					 <label for="User.name">姓名</label><input type="text" class="form-control" id="User.name" name="User.name"
					 placeholder="${sessionScope.User.name}"/>
				</div>
				<div class="form-group" >
					 <label for="User.birth">出生日期</label><input type="date" class="form-control" id="User.birth" 
					 name=User.birth placeholder="${sessionScope.User.birth}"/>
				</div>
				<div class="form-group">
					  <label for="User.email" >Email</label><input type="email" class="form-control" id="User.email" 
					  name=User.email placeholder="${sessionScope.User.email}"/>
				</div>
				<div class="form-group">
					  <label for="User.tel" >联系电话</label><input type="tel" class="form-control" id="User.tel"
					   name=User.tel placeholder="${sessionScope.User.tel}"/>
				</div>
				<div class="form-group">
					  <label for="email">所在学校</label><input type="email" class="form-control" id="email" 
					  placeholder="${sessionScope.User.email}"/>
				</div>
				<div class="form-group">
					  <label for="User.education">教育程度</label>
					  <select class="form-control" name="User.education">
					  <option>${sessionScope.User.education}</option>
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
					  <label for="User.degree">学位</label>
					    <select class="form-control" name="User.degree">
					    <option>${sessionScope.User.education} </option>
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