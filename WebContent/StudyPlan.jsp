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
<title>学习安排</title>
</head>
<body>
<div class="container">

	<div class="row clearfix">
		<div class="col-md-12 column">
			<h3 class="text-error text-center">
				·个人学习安排·
			</h3>
			<table class="table"  Style="border-left:solid 0px #333333;
border-bottom:solid 1px #00FFFF;
border-right:solid 0px #333333;
border-top:solid 0px #333333;" >
				<thead>
					<tr class="info">
						<th>
							开始作业
						</th>
						<th>
							课程教师名
						</th>
						<th>
							课程水平
						</th>
						<th>
							开始时间
						</th>
						
						<th>
							作业
						</th>
						<th>
							考试
						</th>
						<th>
							开始学习
						</th>
						<th>
							修改
						</th>
					</tr>
				</thead>
				<tbody>
					<tr >
						<td>
							4
						</td>
						<td>
							4
						</td>
						<td>
							TB - Monthly
						</td>
						<td>
							04/04/2012
						</td>
						<td>
							Call in to confirm
						</td>
						<td>
							开始考试
						</td>
						<td>
							开始作业
						</td>
						<td>
							开始学习
						</td>
					</tr>
				</tbody>
			</table>
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