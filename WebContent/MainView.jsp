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
    
<title>主界面</title>
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
			<h1 class="text-center" style="font-size:45px">
				·GodZmooc·
				<br>
				<br>
			</h1>
		</div>
	</div>
	<div class="row clearfix">
		<div class="col-md-2 column">
			<div class="list-group">
				 <a  class="list-group-item active">课程资源</a>
				<div class="list-group-item">
					<a href="findResource?type=语文" >语文</a>
					<span class="badge">14</span>
				</div>
				<div class="list-group-item">
					
						<a href="findResource?type=数学">数学</a>
						<span class="badge">14</span>
		
				</div>
				<div class="list-group-item">
						<a href="findResource?type=英语" >英语</a>
						<span class="badge">14</span>
				</div> 
				<div class="list-group-item">
						<a href="findResource?type=政治" >政治</a>
						<span class="badge">14</span>
				</div> 
				<a class="list-group-item active" href="#" > 更多>></a>
			</div>
		</div>
		<div class="col-md-8 column">
			<div class="carousel slide" id="carousel-477290">
			
				<div class="carousel-inner">
					<div class="item">
						<a href="findResource?type=语文"><img alt="" src="Image/yuwen.png" /></a>
						<div class="carousel-caption">
							<h4>
								囊括小学，初中，高中，大学语文
							</h4>
							<p>
							语文是语言和文学、文化的简称，包括口头语言和书面语言；口头语言较随意，直接易懂，而书面语言讲究准确和语法；文学包括中外古今文学等。此解释概念较狭窄，因为语文中的文章不但有文艺文（文学、曲艺等），还有很多实用文（应用文）。通俗的说，语言就是说话艺术。
							</p>
						</div>
					</div>
					<div class="item active">
						<a href="findResource?type=英语"><img alt="" src="Image/yingyu.png" /></a>
						<div class="carousel-caption">
							<h4>
							囊括小学，初中，高中，大学英语
							</h4>
							<p>
							英语（English），属于“印欧语系-日耳曼语族-西日耳曼语支”。根据以英语作为母语的人数计算，英语是最多国家使用的官方语言，英语也是世界上最广泛的第一语言，也是欧盟和许多国际组织和英联邦国家的官方语言，拥有世界第三位的母语使用者人数，仅次于汉语和西班牙语母语使用者人数。
							</p>
						</div>
					</div>
					<div class="item">
					<a href="findResource?type=数学">	<img alt="" src="Image/shuxue.png" /></a>
						<div class="carousel-caption">
							<h4>
								囊括小学，初中，高中，大学数学
							</h4>
							<p>
								数学（mathematics或maths），是研究数量、结构、变化、空间以及信息等概念的一门学科，从某种角度看属于形式科学的一种。
而在人类历史发展和社会生活中，数学也发挥着不可替代的作用，也是学习和研究现代科学技术必不可少的基本工具。
							</p>
						</div>
					</div>
				</div> <a class="left carousel-control" href="#carousel-477290" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a> <a class="right carousel-control" href="#carousel-477290" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
			</div>
		</div>
		<div class="col-md-2 column">
			<div class="list-group">
				 <a  class="list-group-item active">课程资源</a>
				<div class="list-group-item">
					<a href="findResource?type=物理" >物理</a>
					<span class="badge">14</span>
				</div>
				<div class="list-group-item">
					
						<a href="findResource?type=化学">化学</a>
						<span class="badge">14</span>
		
				</div>
				<div class="list-group-item">
						<a href="findResource?type=生物" >生物</a>
						<span class="badge">14</span>
				</div>
				<div class="list-group-item">
						<a href="findResource?type=地理" >地理</a>
						<span class="badge">14</span>
				</div>
				 <a class="list-group-item active" href="#" >  更多>></a>
			</div>
		</div>
	</div>
	<br>
				<br>
	<div class="row clearfix" >
		<div class="col-md-1 column">
		</div>
		<div class="col-md-10 column">
			<div class="row">
				<div class="col-md-3">
					<div class="thumbnail">
						<a href="findResource?classLevel=小学"><img alt="300x100" src="Image/xiaoxue.png" /></a>
						<div class="caption">
							<h3>
								小学课程
							</h3>
							<p>
								小学语文, <br>
								小学数学, <br>
								小学英语等。<br>
							</p>
							<p>
								 <a class="btn btn-primary" href="findResource?classLevel=小学">查看</a>
							</p>
						</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="thumbnail">
						<a href="findResource?classLevel=中学"><img alt="280x80" src="Image/zhongxue.png" /></a>
						<div class="caption">
							<h3>
							中学课程
							</h3>
							<p>
								中学语文, <br>
								中学数学, <br>
								中学英语等<br>
						
							
							</p>
							<p>
								 <a class="btn btn-primary" href="findResource?classLevel=中学">查看</a>
							</p>
						</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="thumbnail">
						<a href="findResource?classLevel=高中"><img alt="300x80" src="Image/gaozhong.png" /></a>
						<div class="caption">
							<h3>
								高中课程
							</h3>
							<p>
								高中语文, <br>
								高中数学, <br>
								高中英语等。<br>
								
							</p>
							<p>
								 <a class="btn btn-primary" href="findResource?classLevel=高中">查看</a>
							</p>
						</div>
					</div>
				</div>
				<div class="col-md-3">
					<div class="thumbnail">
					<a href="findResource?classLevel=大学">	<img alt="300x80" src="Image/daxue.png" /></a>
						<div class="caption">
							<h3>
								大学课程
							</h3>
							<p>
								大学语文, <br>
								大学数学, <br>
								大学英语等。<br>
								
							</p>
							<p>
								 <a class="btn btn-primary" href="findResource?classLevel=大学">查看</a>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-1 column">
		</div>
		
	</div>
</div>

</body>
</html>