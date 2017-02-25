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
<title>修改权限</title>
</head>
<body>
<div class="container" >
	<div class="row clearfix">
		<div class="col-md-12 column">
			<h3 class="text-success text-center">
				·权限修改·
			</h3>
			<table class="table table-bordered">
				<thead>
					<tr class="warning">
						<th>
							ActionName
						</th>
						<th>
							level
						</th>
						<th>
							修改
						</th>
					</tr>
				</thead>
				<tbody>
					<tr class="success">
						<td>
							deleteComment
						</td>
						<td>
					100
						</td>
						<td>
							<form action="updatePower" method="post">
	<div class="row">
    <div class="col-lg-3">
      <input type="text" class="form-control" placeholder="请输入新LEVEL">
    </div>
    <div class="col-lg-4">
       <button  type="submit" class="btn btn-default">修改</button>
    </div>
  </div>
		</form>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>
<div style="width:80%; position:fixed; left:0; bottom:100px">
					<form class="form-horizontal" action="addPower" method="post">
						<div class="row">
						  <label for="firstname" class="col-sm-2 control-label" style="font-size:15px">添加权限:</label>
						  <label for="firstname" class="col-sm-2 control-label">ACTIONNAME</label>
    <div class="col-lg-2" >
       <input type="text" class="form-control" id="firstname" placeholder="请输入ACTIONNAME">
    </div>
     <label for="lastname" class="col-sm-2 control-label">LEVEL</label>
    <div class="col-lg-2">
       <input type="text" class="form-control" id="lastname" placeholder="请输入LEVEL">
    </div>
    <div class="col-lg-2">
         <button type="submit" class="btn btn-default">添加</button>
    </div>
  </div>
</form>
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