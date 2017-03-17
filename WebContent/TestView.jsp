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
    
<title>考试界面</title>
<script>
$(document).ready(function(){
	

	    // 设置属性值
	    $("input:button").click(function() {
	        var selectList = "";
	         var select=new Array();
	         for(var i=0;i<20;i++)
	        	 {
	        	 var tmp=i+1+"";
	        	 select[i]="select"+tmp;
	        	tmp="input:radio[name="+select[i]+"]:checked";
	        
	        	 $(tmp).each(function() {
	        		 selectList += $(this).val() + " ";
	 	        });
	        	 }
	       var judgeList="";
	       var textList="";
	       var judge=new Array();
	       var text=new Array();
	       var answerurl=$("#answerurl").val();
	       var testid=$("#testid").val();
	       for(var j=1;j<16;j++)
	    	   {
	    	   var tmp1=j+"";
	    	   judge[j-1]="judge"+tmp1;
	    	   text[j-1]="text"+tmp1;
	    	   tmp1="input:radio[name="+judge[j-1]+"]:checked";
	    	   $(tmp1).each(function() {
	    		   judgeList += $(this).val() + " ";
	 	        });
	    	   tmp1="input:text[name="+text[j-1]+"]";
	    	   $(tmp1).each(function() {
	    		   textList += $(this).val() + " ";
	 	        });
	    	   }
	     
	       $.ajax({
	             type: "POST",
	             url: "calculateScore",
	             data: {
	            	 select:selectList,
	            	 judge:judgeList,
	            	 text:textList,
	            	 answerurl:answerurl,
	            	 testid:testid
	            	 },
	             dataType: "json",
	             success: function(data){
	            	 alert("您此次考试获得："+data+"分！！！");
	                      },
	            	 error: function (msg) {
	            		 alert("提交失败");
	                 }
	         });
	      
	    });
	
})
</script>
</head>
<body>
 
<div class="container" style="width:100%">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<nav class="navbar navbar-default" role="navigation">
				<div class="navbar-header">
					 <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button> <a class="navbar-brand" href="MainView.jsp">主页</a>
				</div>
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" >
			
				 
					<ul class="nav navbar-nav navbar-right">
					<s:if test="#session.user==null">
      <li>
							 <a href="Login.jsp" id="login">登录</a>
						</li>
						<li>
							 <a href="Login.jsp" id="regist">注册</a>
						</li>
        </s:if>
        <s:else>
       <li>
							 <a>尊敬的用户：${sessionScope.user.username}&nbsp已登录</a>
						</li>
						<li>
							 <a href="outlogin">退出登录</a>
						</li>
				<li class="dropdown">
							 <a data-toggle="dropdown"  href="#" class="dropdown-toggle"  >个人设置<strong class="caret"></strong></a>
							<ul class="dropdown-menu">
								<li>
									 <a href="UserInfo.jsp">个人信息</a>
								</li>
								<li class="divider">
								</li>
								<li>
									 <a href="#">个人权限</a>
								</li>
								<li class="divider">
								</li>
								<li>
									 <a href="studyManage">已收藏课程</a>
								</li>
								<li class="divider">
								</li>
								<li>
									 <a href="classManage">已发布课程管理</a>
								</li>
							</ul>
						</li>		
        </s:else>
      
						
					</ul>
				</div>
			</nav>
			</div>
			<div class="span12">
			<h1 class="text-center text-info">
			<big>${sessionScope.testMessage.testname}</big>	
			</h1>
		
		</div>
		
		<div align="center">
		 <a id="modal-200146" href="#modal-container-200146" role="button" class="btn btn-primary btn-large" data-toggle="modal">查看课程考试简介</a>
			<div class="modal fade" id="modal-container-200146" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
							<h4 class="modal-title" id="myModalLabel">
								课程考试简介
							</h4>
						</div>
						<div class="modal-body">
							&nbsp&nbsp&nbsp${sessionScope.testMessage.introduction}
						</div>
						<div class="modal-footer">
							 <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button> 
						</div>
					</div>
				</div>
			</div>
			</div>
	
		</div>
			<div style="width:85%;position:absolute;left:160px;top:170px;height:40% " >
				<iframe src="${sessionScope.testMessage.url}" width="100%" height="100%"> </iframe>
				</div>
				<div style="width:85%;position:absolute;left:45%;top:58%;height:10% " >
				<p class="list-group-item-text">
		
					请将答案填在下列答案区域中！
					</p>
			</div>
		
				<div style="width:100%; position:fixed; left:47%; bottom:56px;">
	
<input type="button" class="btn btn-primary btn-large" value="提交答案">
</div>
	
</div>


	<div  style="position:absolute;width:85%;left:160px;top:60%;overflow:auto;height:280px;border:2px solid #a0A1Af" >
			<div class="container" style="width:100%">
	<div class="row clearfix">
		<div class="col-md-4 column">
		<input type="hidden" id="answerurl" value="${sessionScope.testMessage.answerurl}">
		<input type="hidden" id="testid" value="${sessionScope.testMessage.testid}">
			<h3>
				一.选择题
			</h3>
			<ol>
				
				<li>
					<input type="radio" name="select1" value="A">A
					<input type="radio" name="select1" value="B">B
					<input type="radio" name="select1" value="C">C
					<input type="radio" name="select1" value="D">D
				</li>
				<li>
					<input type="radio" name="select2" value="A">A
					<input type="radio" name="select2" value="B">B
					<input type="radio" name="select2" value="C">C
					<input type="radio" name="select2" value="D">D
				</li>
				<li>
			
					<input type="radio" name="select3" value="A">A
					<input type="radio" name="select3" value="B">B
					<input type="radio" name="select3" value="C">C
					<input type="radio" name="select3" value="D">D
				</li>
				<li>
				<input type="radio" name="select4" value="A">A
					<input type="radio" name="select4" value="B">B
					<input type="radio" name="select4" value="C">C
					<input type="radio" name="select4" value="D">D
				</li>
				<li>
					<input type="radio" name="select5" value="A">A
					<input type="radio" name="select5" value="B">B
					<input type="radio" name="select5" value="C">C
					<input type="radio" name="select5" value="D">D
				</li>
				<li>
					<input type="radio" name="select6" value="A">A
					<input type="radio" name="select6" value="B">B
					<input type="radio" name="select6" value="C">C
					<input type="radio" name="select6" value="D">D
					
				</li>
				<li>
					<input type="radio" name="select7" value="A">A
					<input type="radio" name="select7" value="B">B
					<input type="radio" name="select7" value="C">C
					<input type="radio" name="select7" value="D">D
				</li>
				<li>
					<input type="radio" name="select8" value="A">A
					<input type="radio" name="select8" value="B">B
					<input type="radio" name="select8" value="C">C
					<input type="radio" name="select8" value="D">D
				</li>
				<li>
					<input type="radio" name="select9" value="A">A
					<input type="radio" name="select9" value="B">B
					<input type="radio" name="select9" value="C">C
					<input type="radio" name="select9" value="D">D
				</li>
				<li>
					<input type="radio" name="select10" value="A">A
					<input type="radio" name="select10" value="B">B
					<input type="radio" name="select10" value="C">C
					<input type="radio" name="select10" value="D">D
				</li>
				<li>
					<input type="radio" name="select11" value="A">A
					<input type="radio" name="select11" value="B">B
					<input type="radio" name="select11" value="C">C
					<input type="radio" name="select11" value="D">D
				</li>
				<li>
			<input type="radio" name="select12" value="A">A
					<input type="radio" name="select12" value="B">B
					<input type="radio" name="select12" value="C">C
					<input type="radio" name="select12" value="D">D
				</li>
				<li>
					<input type="radio" name="select13" value="A">A
					<input type="radio" name="select13" value="B">B
					<input type="radio" name="select13" value="C">C
					<input type="radio" name="select13" value="D">D
				</li>
				<li>
					<input type="radio" name="select14" value="A">A
					<input type="radio" name="select14" value="B">B
					<input type="radio" name="select14" value="C">C
					<input type="radio" name="select14" value="D">D
				</li>
				<li>
					<input type="radio" name="select15" value="A">A
					<input type="radio" name="select15" value="B">B
					<input type="radio" name="select15" value="C">C
					<input type="radio" name="select15" value="D">D
				</li>
				<li>
					<input type="radio" name="select16" value="A">A
					<input type="radio" name="select16" value="B">B
					<input type="radio" name="select16" value="C">C
					<input type="radio" name="select16" value="D">D
				</li>
				<li>
					<input type="radio" name="select17" value="A">A
					<input type="radio" name="select17" value="B">B
					<input type="radio" name="select17" value="C">C
					<input type="radio" name="select17" value="D">D
				</li>
				<li>
					<input type="radio" name="select18" value="A">A
					<input type="radio" name="select18" value="B">B
					<input type="radio" name="select18" value="C">C
					<input type="radio" name="select18" value="D">D
				</li>
				<li>
				<input type="radio" name="select19" value="A">A
					<input type="radio" name="select19" value="B">B
					<input type="radio" name="select19" value="C">C
					<input type="radio" name="select19" value="D">D
				</li>
				<li>
					<input type="radio" name="select20" value="A">A
					<input type="radio" name="select20" value="B">B
					<input type="radio" name="select20" value="C">C
					<input type="radio" name="select20" value="D">D
				</li>
			</ol>
		</div>
		<div class="col-md-3 column">
			<h3>
				二.判断题
			</h3>
			<ol>
			
				<li>
					<input type="radio" name="judge1" value="对">对
					<input type="radio" name="judge1" value="错">错
				</li>
				<li>
					<input type="radio" name="judge2" value="对">对
					<input type="radio" name="judge2" value="错">错
				</li>
				<li>
					<input type="radio" name="judge3" value="对">对
					<input type="radio" name="judge3" value="错">错
				</li>
				<li>
					<input type="radio" name="judge4" value="对">对
					<input type="radio" name="judge4" value="错">错
				</li>
				<li>
					<input type="radio" name="judge5" value="对">对
					<input type="radio" name="judge5" value="错">错
				</li>
				<li>
				<input type="radio" name="judge6" value="对">对
					<input type="radio" name="judge6" value="错">错
				</li>
				<li>
					<input type="radio" name="judge7" value="对">对
					<input type="radio" name="judge7" value="错">错
				</li>
				<li>
				<input type="radio" name="judge8" value="对">对
					<input type="radio" name="judge8" value="错">错
				</li>
				<li>
					<input type="radio" name="judge9" value="对">对
					<input type="radio" name="judge9" value="错">错
				</li>
				<li>
				<input type="radio" name="judge10" value="对">对
					<input type="radio" name="judge10" value="错">错
				</li>
				<li>
					<input type="radio" name="judge11" value="对">对
					<input type="radio" name="judge11" value="错">错
				</li>
				<li>
					<input type="radio" name="judge12" value="对">对
					<input type="radio" name="judge12" value="错">错
				</li>
				<li>
					<input type="radio" name="judge13" value="对">对
					<input type="radio" name="judge13" value="错">错
				</li>
				<li>
				<input type="radio" name="judge14" value="对">对
					<input type="radio" name="judge14" value="错">错
				</li>
				<li>
					<input type="radio" name="judge15" value="对">对
					<input type="radio" name="judge15" value="错">错
				</li>
			</ol>
		</div>
		<div class="col-md-5 column">
			<h3>
				三.填空题
			</h3>
			<ol>
				<li>
				<input type="text" name="text1">
				</li>
				<li>
					<input type="text" name="text2">
				</li>
				<li>
					<input type="text" name="text3">
				</li>
				<li>
				<input type="text" name="text4">
				</li>
				<li>
					<input type="text" name="text5">
				</li>
				<li>
					<input type="text" name="text6">
				</li>
				<li>
					<input type="text" name="text7">
				</li>
				<li>
					<input type="text" name="text8">
				</li>
				<li>
					<input type="text" name="text9">
				</li>
				<li>
					<input type="text" name="text10">
				</li>
				<li>
					<input type="text" name="text11">
				</li>
				<li>
					<input type="text" name="text12">
				</li>
				<li>
				<input type="text" name="text13">
				</li>
				<li>
					<input type="text" name="text14">
				</li>
				<li>
				<input type="text" name="text15">
				</li>
			</ol>
		</div>
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