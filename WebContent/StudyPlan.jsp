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
<title>学习安排</title>
</head>
<body>
 <jsp:include page="header.jsp" flush="true"></jsp:include>  
<div class="container" >

	<div class="row clearfix">
	<h3 class="text-error text-center">
				·个人学习安排·
			</h3>
		<div class="col-md-12 column" style="overflow: auto;height:650px">
			
			<table class="table"  Style="border-left:solid 0px #333333;
border-bottom:solid 1px #00FFFF;
border-right:solid 0px #333333;
border-top:solid 0px #333333;" >
				<thead>
					<tr class="info">
						<th>
							课程名
						</th>
						<th>
							课程水平
						</th>
						<th>
							开始时间
						</th>
						
						<th>
							作业信息
						</th>
						<th>
							考试信息
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
				<s:iterator value="#session.studyInfoList" var="studyInfoList" >
					<tr >
						<td>
							${studyInfoList.classname}
						</td>
						<td>
							${studyInfoList.classLevel}
						</td>
						<td>
							${studyInfoList.time}
						</td>
						<td>
						
						<s:if test="#studyInfoList.homeworkid!=null">
					<a href="findHomework?homeworkid=${studyInfoList.homeworkid}" >查看作业</a>
					</s:if>
					<s:else>
					暂无作业发布
					</s:else>
						</td>
						<td>
						<s:if test="#studyInfoList.testid!=null">
							<a href="findTest?testid=${studyInfoList.testid}">查看考试</a>
							</s:if>
							<s:else>
					暂无考试发布
					</s:else>
						</td>
						<td>
							<a href="classMessage?classInfoid=${studyInfoList.classInfoid}">进入课程学习</a>
						</td>
						<td>
							<a href="deleteStudyPlan?classInfoid=${studyInfoList.classInfoid}">删除该课程</a>
						</td>
					
					</tr>
					</s:iterator>
					
				</tbody>
			
			</table>
				${none}
		</div>
	</div>
</div>
 <jsp:include page="footer.jsp" flush="true"></jsp:include>  
</body>
</html>