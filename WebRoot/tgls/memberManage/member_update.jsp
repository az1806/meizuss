<%@ page language="java" import="java.util.*,com.jiaju.entity.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Member mem=(Member)request.getAttribute("mem");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'member_update.jsp' starting page</title>
    
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
		<link rel="stylesheet" type="text/css" href="css/jquery.mCustomScrollbar.css">
		<script src="framework/jquery-ui-1.10.4.min.js"></script>
		<script src="framework/jquery.mousewheel.min.js"></script>
		<script src="framework/jquery.mCustomScrollbar.min.js"></script>
		<script src="ramework/cframe.js"></script><!-- 仅供所有子页面使用 -->
		<!-- 公共样式 结束 -->
		 <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
		<style>
			.layui-form-label{
				width: 100px;
			}
			.layui-input-block{
				margin-left: 130px;
			}
			.layui-input{
				width: 230px;
				height: 30px;
				
				
			}
		</style>
		<script type="text/javascript">
		
		
		function update(){
			var id=document.getElementById("updateid").value;
		var name=document.getElementById("name").value;
		var position=document.getElementById("position").value;
		var photo=document.getElementById("photo").value;
		window.location.href="adminmember?method=update&name="+encodeURI(encodeURI(name))+"&position="+encodeURI(encodeURI(position))+"&photo="+encodeURI(encodeURI(photo))+"&id="+id+"";

		
		}
		/*
		上传图片
		*/
		var layer, upload;
				$(function() {
					layui.use([ 'layer', 'upload' ], function() {

						upload = layui.upload;
						layer = layui.layer;
						upload.render({

							elem : '#test1',
							url : 'adminproduct?method=saveImg', //服务器端接收文件数据的地址
							done : function(res) {

								layer.alert(res.message);
								$("#photo").val(res.message);

							}

						});

					});

				})
		
		
		
		
		</script>
  </head>
  
  <body>
 	<div class="cBody">
		<form id="addForm" class="layui-form">
				
				<div id="head">  </div> 
				<div class="layui-form-item">
					<label class="layui-form-label">员工ID</label>
					<div class="layui-input-block">
						<input type="text" name="id"  id="updateid" required lay-verify="required" autocomplete="off" class="layui-input" value="<%=mem.getId()%>">
					</div>
				</div>
				  
				<div class="layui-form-item">
					<label class="layui-form-label">姓名</label>
					<div class="layui-input-block">
						<input type="text" name="name"  id="name" value="<%=mem.getName() %>" required lay-verify="required" autocomplete="off" class="layui-input">
					</div>
				</div>
				
				
				<div class="layui-form-item">
					<label class="layui-form-label">职位</label>
					<div class="layui-input-block">
						<input type="text" name="position" id="position" value="<%=mem.getPosition() %>" required lay-verify="required" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">照片路径</label>
					<div class="layui-input-block">
						<input type="text" name="photo" id="photo" value="<%=mem.getPhoto() %>" required lay-verify="required" autocomplete="off" class="layui-input">
					</div>
				</div>
		
				<div class="layui-form-item">
					<div class="layui-input-block">
						
						<input type="button" class="layui-btn" value="确定"  onclick="update()"> 
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
	 图片：<img
					id="imgFace" style="width:120px" /><br /> <input type="file"
					name="file" class="layui-upload-file" /> <br />
				<button type="button" class="layui-btn" id="test1">上传图片</button>
			</form>
			
			
			

		</div>
			
			<script>
				layui.use(['upload','form'], function() {
					var form = layui.form;
					var upload = layui.upload;
					var layer = layui.layer;
					//监听提交
					//解决了layui.open弹窗从内部关闭这个弹窗的问题
					form.on('submit(submitBut)', function(data) {
						var updateFrame = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
						parent.layer.close(updateFrame);  //再改变当前层的标题
					});
					form.verify({
						//数组的两个值分别代表：[正则匹配、匹配不符时的提示文字]
					  	ZHCheck: [
						    /^[\u0391-\uFFE5]+$/
						    ,'只允许输入中文'
					  	] 
					});
					//拖拽上传
					upload.render({
						elem: '#goodsPic',
						url: '/upload/',
						done: function(res) {
						  	console.log(res)
						}
					});
				});
			</script>

		</div>
	</body>

</html>