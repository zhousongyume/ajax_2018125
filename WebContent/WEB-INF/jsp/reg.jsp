<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath %>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<script type="text/javascript" src="js/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
		$(function(){
			$("#username").blur(function(){
				$.ajax({
					url:"checkName",   //访问路径（servlet注解的）
					type:"post",  	//表单提交决定采用post方式，如果不写默认是get
					data:{"username":$(this).val()},//是一个json格式的对象(json是一个轻量级的对象语法：{name1:value1,name2:value2,...})
					dataType:"json",	//返回的数据类型
					success:function(data){
						if(data){
							//表示可以注册
							$("#username").next().html("恭喜可以注册");
						}else{
							//表示不可以注册
							$("#username").next().html("用户名已经被注册");
						}
					}
				});
			});
		});
</script>

</head>
<body>
	<!-- 先不链接数据库，如果输入的是admin表示用户已经被注册，否则表示用户名没有被注册 -->
	姓名:<input type="text" id="username" name="username"/><span></span>
</body>
</html>