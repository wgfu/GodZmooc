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
	<h3 class="text-error text-center">
				·课程管理·
			</h3>
		<div class="col-md-12 column" style="overflow: auto;height:650px">
			
			
			<table class="table" Style="border-left:solid 0px #333333;
border-bottom:solid 1px #00FFFF;
border-right:solid 0px #333333;
border-top:solid 0px #333333;"
>
				<thead>
					<tr class="info">
						<th>
							课程名
						</th>
						<th>
							课程类型
						</th>
						<th>
							课程水平
						</th>
						<th>
							作业
						</th>
						<th>
							考试
						</th>
					
						
					</tr>
				</thead>
				<tbody>
				<s:iterator value="#session.classInfo" var="c">
					<tr >
						<td>
							<a href="classMessage?classInfoid=${c.classInfoid}">${c.classname}</a>
						</td>
						<td>
							${c.type}
						</td>
						<td>
						${c.classLevel}
						</td>
						<td>
							<s:if test="#c.homeworkid==null">
							<p><a class="btn btn-primary btn-large" href="AddHomework.jsp?classInfoid=${c.classInfoid}">添加作业 &raquo;</a></p>
							</s:if>
							<s:else>
							<p>已发布作业
							</s:else>
						</td>
						<td>
						<s:if test="#c.testid==null">
							<p><a class="btn btn-primary btn-large" href="AddTest.jsp?classInfoid=${c.classInfoid}">添加考试 &raquo;</a></p>
							</s:if>
							<s:else>
							<p><a class="btn btn-primary btn-large" href="changeTest?testid="+"${c.testid}">查看已收藏该课程学生 &raquo;</a></p>
							</s:else>
						</td>
					
						
					</tr>
					</s:iterator>
				</tbody>
			</table>
				
				${sessionScope.NoclassInfo}
				
		</div>
	</div>
</div>
<div align="center" style="position:fixed; left:47%; bottom:100px;">

<p><a class="btn btn-primary btn-large" href="AddClass.jsp">添加课程 &raquo;</a></p>

</div>
 <jsp:include page="footer.jsp" flush="true"></jsp:include>  
</body>
</html>