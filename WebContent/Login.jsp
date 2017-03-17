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
<title>登录注册界面</title>
<script>
$(document).ready(function(){
	$("input:text[id='user.username1']").blur(function(){
		var username=$(this).val().trim();
		if(username!=undefined&&username!=null&&username!="")
		{ $.ajax({
            type: "POST",
            url: "checkUsername",
            data: {
            username:username
           	 },
            dataType: "json",
            success: function(data){
            	if(data==1)
            		{
           	$("#checkUsername").html("该用户名可以使用");
           	$("#flag").val(1);
            		}
            	else{
            	  	$("#checkUsername").html("该用户名已存在");
            		$("#flag").val(0);
            	}
                     },
           	 error: function (msg) {
           		$("#checkUsername").html("验证失败");
           		$("#flag").val(0);
                }
        });}
		else
		{
			$("#checkUsername").html("");
		}
		
	   
	});
	
	
	$("#login").click(function(){
		var val=$("input:password[id='user.password']").val().trim();
		var username=$("input:text[id='user.username']").val().trim();
		if(username!=undefined&&username!=null&&username!="")
			{
			if(val!=undefined&&val!=null&&val!="")
				{
				$("#loginForm").submit();
				}
			else{
				alert("密码不能为空");
			}
			}
		else{
			alert("用户名不能为空");
		}
	});
	
	$("#regist").click(function(){
		  var val=$('input:radio[name="user.type"]:checked').val();
		var flag=$("#flag").val();
		var flag1=$("input:password[id='user.password1']").val().trim();
	if(flag==1)
	{
		if(flag1!=undefined&&flag1!=null&&flag1!="")
			{
			if(val!=undefined)
		{$("#registForm").submit();}
			else{
				alert("请选择用户类型")
			}
			}
		else
			{
			alert("密码不能为空")
			}
		}
	else{
		alert("用户名验证失败，请重新输入")
	}
	});
	
});

</script>
</head>
<body>
<div class="container" >
	<div class="row clearfix">
	<br>
			<br>
			<br>
			<br>
			<h1 align="center" >·GodZmooc·</h1>
			<br>
			<br>
			<br>
			<br>
			<br>
		<div class="col-md-6 column">
			<h1 class="text-info text-center">
				·登录·
			</h1>
			
			<form role="form" action="login" method="post" id="loginForm">
				<div class="form-group">
					 <label for="user.username">用户名</label><input type="text" class="form-control" id="user.username" name="user.username"/>
				</div>
				<div class="form-group">
					 <label for="user.password">密码</label><input type="password" class="form-control" id="user.password" name="user.password"/>
				</div>
				 <button type="button" class="btn btn-default" id="login">登录</button>
			</form>
		</div>
		<div class="col-md-6 column">
			<h1 class="text-info text-center">
				·注册·
			</h1>
			<form role="form" action="regist" method="post" id="registForm">
				<div class="form-group">
					 <label for="user.username">用户名</label>
					 <table width="900px" >
					 <tr>
					 <td width="555px">
					<input type="text" class="form-control" id="user.username1" name="user.username" />
					 </td>
					 <td>
					 	 <label for="user.username" id="checkUsername"></label>
					 </td>
					 </tr>
					 </table>
				</div>
				<div class="form-group">
					 <label for="user.password">密码</label><input type="password" class="form-control" id="user.password1" name="user.password"/>
				</div>
				<input type="hidden" name="flag" id="flag" value="0">
			
	<label>选择用户类型：
		<input type="radio" name="user.type" id="user.type" value="teacher"> 老师
	</label>
	<label>
		<input type="radio" name="user.type" id="user.type" value="student">学生
	</label>
				<br> <button type="button" class="btn btn-default" id="regist">注册</button>
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