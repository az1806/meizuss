<%@ page language="java" import="java.util.*,com.jiaju.entity.*"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	News news = (News) request.getAttribute("news");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'goods_update.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1">
<!-- Google Chrome Frame也可以让IE用上Chrome的引擎: -->
<meta name="renderer" content="webkit">
<!--国产浏览器高速模式-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="author" content="穷在闹市" />
<!-- 作者 -->
<meta name="revised" content="穷在闹市.v3, 2019/05/01" />
<!-- 定义页面的最新版本 -->
<meta name="description" content="网站简介" />
<!-- 网站简介 -->
<meta name="keywords" content="搜索关键字，以半角英文逗号隔开" />
<title>穷在闹市出品</title>

<!-- 公共样式 开始 -->
<link rel="stylesheet" type="text/css" href="css/base.css">
<link rel="stylesheet" type="text/css" href="css/iconfont.css">
<script type="text/javascript" src="framework/jquery-1.11.3.min.js"></script>
<link rel="stylesheet" type="text/css" href="layui/css/layui.css">
<script type="text/javascript" src="layui/layui.js"></script>
<!-- 滚动条插件 -->
<link rel="stylesheet" type="text/css"
	href="../../css/jquery.mCustomScrollbar.css">
<script src="../../framework/jquery-ui-1.10.4.min.js"></script>
<script src="../../framework/jquery.mousewheel.min.js"></script>
<script src="../../framework/jquery.mCustomScrollbar.min.js"></script>
<script src="../../framework/cframe.js"></script>
<!-- 仅供所有子页面使用 -->
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<!-- 公共样式 结束 -->

<style>
.layui-input {
	width: 230px;
	height: 30px;
}
</style>
<script type="text/javascript">
	function update() {
		var newsid =
<%=news.getNewsid()%>
	;
		var typeid = document.getElementById("typeid").value;
		var title = document.getElementById("title").value;
		var content = document.getElementById("content").value;

		var time = document.getElementById("time").value;

  window.location.href="adminnewss?method=update&newsid="+newsid+"&typeid="+typeid+"&content="+content+"&time="+time+"&title="+title+"";


	}
</script>
</head>

<body>
	<div class="cBody">

		<form>
			<table>

				<tr>

					<td>资讯类别</td>
					<td><input id="typeid" class="layui-input"
						value="<%=news.getTypeid()%>"></td>


				</tr>
				<tr>

					<td>资讯标题</td>
					<td><input id="title" class="layui-input"
						value="<%=news.getTitle()%>"></td>


				</tr>
				<tr>

					<td>资讯内容</td>
					<td><input id="content" class="layui-input"
						value="<%=news.getContent()%>"></td>


				</tr>
				<tr>

					<td>资讯时间</td>
					<td><input id="time" class="layui-input"
						value="<%=news.getTime()%>"></td>
				</tr>
				<tr>


					<td><input class="layui-btn" type="button" value="确定"
						onclick="update()"> <input type="reset" class="layui-btn">
					</td>


				</tr>



			</table>




		</form>



		<script>
			/*	layui.use(['upload','form'], function() {
					var form = layui.form;
					var upload = layui.upload;
					var layer = layui.layer;
					//监听提交
					form.on('submit(submitBut)', function(data) {
						return false;
					});
					form.verify({
						//数组的两个值分别代表：[正则匹配、匹配不符时的提示文字]
					  	ZHCheck: [
						    /^[\u0391-\uFFE5]+$/
						    ,'只允许输入中文'
					  	] 
					});*/
			//拖拽上传
			upload.render({
				elem : '#goodsPic',
				url : '/upload/',
				done : function(res) {
					console.log(res)
				}
			});
			//	});
		</script>

	</div>
</body>
</html>
