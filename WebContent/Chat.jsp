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
       <link rel="alternate icon" href="assets/i/favicon.ico">
<link rel="stylesheet" href="assets/css/amazeui.min.css">
<link rel="stylesheet" href="assets/css/app.css">
<!-- umeditor css -->
<link href="umeditor/themes/default/css/umeditor.css" rel="stylesheet">


  <style >
.title {
 text-align: center;
}
.chat-content-container {
 height: 29rem;
 overflow-y: scroll;
 border: 1px solid silver;
}
</style>


 <!-- 配置文件 -->
     
    <script type="text/javascript" src="umeditor/ueditor.config.js"></script>
    <!-- 编辑器源码文件 -->
    <script type="text/javascript" src="umeditor/ueditor.all.js"></script>
    <!-- 实例化编辑器 -->
    <script type="text/javascript">
    $(document).ready(function(){
    	
        var um = UE.getEditor('myEditor');
        var username=$("#username").val();
        var socket = new WebSocket('ws://${pageContext.request.getServerName()}:${pageContext.request.getServerPort()}${pageContext.request.contextPath}/websocket?'+username);
        // 处理服务器端发送的数据
         
        socket.onmessage = function(event) {
         addMessage(event.data);
   
        };

        // 发送消息
        $("#send").click(function() {
         if (!um.hasContents()) {    // 判断消息输入框是否为空
          // 消息输入框获取焦点
         
          um.focus();
          // 添加抖动效果
       
          $('.edui-container').addClass('am-animation-shake');
       
          setTimeout("$('.edui-container').removeClass('am-animation-shake')", 1000);
         }
          else {
        	  var Friendsname= $("#Friendsname").text();
          // 发送消息
          socket.send(JSON.stringify({
           action : "sendMessage",
           username : username,
           Friendsname : Friendsname, 
           content : um.getContent(),
          }));
          // 清空消息输入框
          um.setContent('');
          // 消息输入框获取焦点
          um.focus();
         }
        });
        // 把消息添加到聊天内容中
         socket.onmessage = function(evt)
          {
        	 message = JSON.parse(evt.data);
        	 switch(message.action)
        	 {
        	 case "sendmessage" : addMessage(message);
        	 case "getFriendsList" : getFriendsList(message);
        	 case "notify" : notify(message);
        	 case "changecount" : changcount(message);
        	 }
          };
          
          $("#FriendsList").delegate("a","click",function(){
       	   $("#window").css('display','block'); 
       	   $("#Friendsname").html($(this).attr("name"));
       	 socket.send(JSON.stringify({
             action : "changewindowstatus",
             status : "open",
             Friendsname:$(this).attr("name")
            }));
       	  });
           $("#closewindow").click(function ()
        		   {
        	   $("#window").css('display','none');
        	   var Friendsname= $("#Friendsname").text();
        	   var username=$("#username").val();
        	   socket.send(JSON.stringify({
                   action : "changewindowstatus",
                   status : "close",
                   username:username,
                   Friendsname:Friendsname
                  }));
        	   });
         
          function getFriendsList(message)
          {
        	  var FriendsListItem ="<div class='list-group-item'><a href=javascript:void(0); name="
        	  +message.Friendsname+">"
        	  +"<img  src='Image/yuwen.png' height='70px' width='60px'/></a>"
		+"<span style='font-size:18px'><a href=javascript:void(0); name="
  	  +message.Friendsname
  	  +">"
  	  +message.Friendsname
		+"</a><br>&nbsp&nbsp"
		+"<span id="
		+message.Friendsname+"status>"
		+message.status
		+"</span></span><span class='badge' id="
		+message.Friendsname+"count>"
		+message.count
		+"</span> </div>"
		$(FriendsListItem).appendTo('#FriendsList');
          }
          
        function addMessage(message) {
        
         var messageItem = '<li class="am-comment '
           + (message.isSelf? 'am-comment-success' : 'am-comment-flip')
           + '">'
           + '<a href="javascript:void(0)" ><img src="assets/images/'
           + (message.isSelf ? 'Img/yuwen.png' : 'others.jpg')
           + '" alt="" class="am-comment-avatar" width="48" height="48"/></a>'
           + '<div class="am-comment-main"><header class="am-comment-hd"><div class="am-comment-meta">'
           + '<a href="javascript:void(0)" class="am-comment-author">'
           + message.username + '</a> <time>' + message.time
           + '</time></div></header>'
           + '<div class="am-comment-bd">' + message.content
           + '</div></div></li>';
         $(messageItem).appendTo('#message-list');
         // 把滚动条滚动到底部
         $(".chat-content-container").scrollTop($(".chat-content-container")[0].scrollHeight);
        }
    });
    </script>
    
    
</head>

<body>
    	 <jsp:include page="header.jsp" flush="true"></jsp:include>  
   
  
 <!-- title start -->
 <div id="window" style="display:none">
 <div class="title">
  <div class="am-g am-g-fixed">
   <div class="am-u-sm-12">
    <h1 class="am-text-primary">当前联系人：<span id="Friendsname"></span></h1>
   </div>
  </div>
 </div>
 <!-- title end -->
 <!-- chat content start -->
 <div class="chat-content">
  <div class="am-g am-g-fixed chat-content-container">
   <div class="am-u-sm-12">
    <ul id="message-list" class="am-comments-list am-comments-list-flip"></ul>
   </div>
  </div>
 </div>
 <!-- chat content start -->
 <!-- message input start -->
 <div class="message-input am-margin-top">
  <div class="am-g am-g-fixed">
   <div class="am-u-sm-12">
    <form class="am-form">
     <div class="am-form-group">
   <!-- 加载编辑器的容器 -->
    <script id="myEditor" name="content" type="text/plain">
    
    </script>
     </div>
    </form>
   </div>
  </div>
  <div class="am-g am-g-fixed am-margin-top">
   
   <div class="am-u-sm-6">
   <input type="hidden" id="username" value="${sessionScope.user.username}">
    <button id="send" type="button" class="am-btn am-btn-primary">
     <i class="am-icon-send"></i> Send
    </button>
    <button id="closewindow" type="button" class="am-btn am-btn-primary">
     <i class="am-icon-close"></i>关闭窗口
    </button>
   </div>
  </div>
 </div>
 
 </div>
 <div style="width:19%;height:75%;position:fixed;left:15px;top:100px;overflow:auto;">
 	<div class="col-md-12 column">
 	 <a href="#" class="list-group-item active">好友列表</a>
			<div class="list-group" id="FriendsList">
			</div>
		</div>
 </div>
 
 	 <jsp:include page="footer.jsp" flush="true"></jsp:include>  
</body>

</html>