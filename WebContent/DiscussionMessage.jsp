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
       <style type="text/css"> 
table 
{ 
border-collapse: collapse; 
border: none; 
width: 100%;

} 
td 
{ 
border: dashed GREY 4px; 

} 
</style> 
<title>查看权限</title>
</head>
<body>
<div class="container" style="width:100%">
	<div class="row clearfix">
	 <jsp:include page="header.jsp" flush="true"></jsp:include>  
		<div>
		<br>
		
		</div>
		<div class="col-md-1 column">
		</div>
		<div class="col-md-10 column" >
		<div style="position:absolute;overflow:auto;width:100%;height:540px">
		<table >
		<tr height="45px">
        <td width="10%">
        
        </td>	
         <td width="70%">
           <h4><big>  &nbsp&nbsp ${sessionScope.DiscussionMessage.title }</big></h4>
        </td>	
        		
		</tr>
		
			<tr height="30px">
        <td style="border-bottom:1px dashed #00CCCC;">
         &nbsp&nbsp   &nbsp&nbsp ${sessionScope.DiscussionMessage.username }
        </td>	
         <td style="border-bottom:1px dashed #00CCCC;">
        &nbsp&nbsp  楼主&nbsp|&nbsp&nbsp${sessionScope.DiscussionMessage.time }
        </td>	
         		
		</tr>
		<tr height="300px">
        <td style="border-top:1px dashed #00CCCC;">
         <div align="center">
         <img src="Image/yuwen.png" width="140px" height="160px">
         </div>
        </td>	
         <td style="border-top:1px dashed #00CCCC;">
         <div style="text-align:center;overflow:auto;height:290px">
        <h4>
        ${sessionScope.DiscussionMessage.text }
         </h4>
         </div>
        </td>	
       	</tr>
		<s:if test="#session.ReplyList!=null">
		<s:iterator value="#session.ReplyList" var="ReplyList">
		<tr height="30px">
        <td style="border-bottom:1px dashed #00CCCC;">
      &nbsp&nbsp  &nbsp&nbsp  ${ReplyList.username }
        </td>	
         <td style="border-bottom:1px dashed #00CCCC;">
       &nbsp&nbsp   <s:if test="#session.user.userid==#ReplyList.userid">楼主&nbsp|&nbsp</s:if> ${ReplyList.time }
        </td>	
         		
		</tr>
		<tr height="300px">
        <td style="border-top:1px dashed #00CCCC;">
        <div align="center">
         <img src="Image/yuwen.png" width="140px" height="160px">
         </div>
        </td>	
         <td style="border-top:1px dashed #00CCCC;">
        <div style="text-align:center;overflow:auto;height:290px">
        <h4>
        ${ReplyList.text }
         </h4>
         </div>
        </td>	
         		
		</tr>
		</s:iterator>
		</s:if>
		
		</table>
		</div>
		<div class="list-group-item" style="width:60%; position:fixed; top:68%; height:25%;left:20%">
					<h4>发贴:</h4>
						<form action="addReply" method="post">
						
					<input type="hidden" name="reply.replyid" value="${sessionScope.DiscussionMessage.replyid}">
					<input type="hidden" name="discussionid" value="${sessionScope.DiscussionMessage.discussionid}">
						<textarea name="reply.text" cols="100" rows="7"></textarea>
						
					<input type="submit" value="发表回复">
					
						</form>
					</div>
		
		</div>
		<div class="col-md-1 column">
		</div>
		
	</div>
</div>
 <jsp:include page="footer.jsp" flush="true"></jsp:include>  
</body>
</html>