<%@ page language="java" import="java.util.*,com.jiaju.entity.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Product pro=(Product) request.getAttribute("pro");
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
	--><meta charset="UTF-8">
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
		<link rel="stylesheet" type="text/css" href="../../css/jquery.mCustomScrollbar.css">
		<script src="../../framework/jquery-ui-1.10.4.min.js"></script>
		<script src="../../framework/jquery.mousewheel.min.js"></script>
		<script src="../../framework/jquery.mCustomScrollbar.min.js"></script>
		<script src="../../framework/cframe.js"></script><!-- 仅供所有子页面使用 -->
		<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
		<!-- 公共样式 结束 -->
		
		<style>
		.layui-input{
				
				width:230px;
				height: 30px;
			}
		</style>
		<script type="text/javascript">
	
		
                   function update() {
                   	var cpid = document.getElementById("cpid").value;
					var typeid = document.getElementById("typeid").value;
					var name = document.getElementById("name").value;
					
					var updatefunction=document.getElementById("updatefunction").value;
					var price = document.getElementById("price").value;
					var img = document.getElementById("img").value;
					var content = document.getElementById("content").value;
                     window.location.href="adminproduct?method=update&cpid="+cpid+"&typeid="+typeid+"&name="+name+"&updatefunction="+updatefunction+"&price="+price+"&img="+img+"&content="+content+"";
                    
                  
                    
                     	}
                     		
                     	</script>
  </head>
  
  <body>
   <div class="cBody">
			<form >
				<div class="layui-form-item">
					<label class="layui-form-label">商品ID</label>
					<div class="layui-input-block">
						<input type="text" id="cpid" value="<%=pro.getCpid() %>"  required lay-verify="required|number" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">商品类别</label>
					<div class="layui-input-block">
						<input type="text" id="typeid" value="<%=pro.getTypeid() %>"  required lay-verify="required|number" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">商品名称</label>
					<div class="layui-input-block">
						<input type="text" id="name"  value="<%=pro.getName() %>" required lay-verify="required" autocomplete="off" class="layui-input">
					</div>
				</div>
				
				
				<div class="layui-form-item">
					<label class="layui-form-label">功能</label>
					<div class="layui-input-block">
						<input type="text" id="updatefunction"  value="<%=pro.getFunction() %>" required lay-verify="required"  autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">参考价格</label>
					<div class="layui-input-block">
						<input type="text" id="price" value="<%=pro.getPrice() %>" required lay-verify="required|number" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">内容</label>
					<div class="layui-input-block">
					<textarea rows="5" cols="40" id="content"  required lay-verify="required" autocomplete="off"><%=pro.getContent() %></textarea>
					</div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label">商品图片</label>
						<div class="layui-input-block">
						<input type="text" id="img" value="<%=pro.getImg() %>" required lay-verify="required" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<div class="layui-input-block">
					
						<input class="layui-btn" onclick="update()" type="button" value="确定">
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
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
						elem: '#goodsPic',
						url: '/upload/',
						done: function(res) {
						  	console.log(res)
						}
					});
			//	});
			</script>

		</div>
  </body>
</html>
