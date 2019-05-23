<%@ page language="java" import="java.util.*,com.jiaju.entity.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <base href="<%=basePath%>">
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
		<link rel="stylesheet" type="text/css" href="../../css/base.css">
		<link rel="stylesheet" type="text/css" href="../../css/iconfont.css">
		<script type="text/javascript" src="../../framework/jquery-1.11.3.min.js"></script>
		<link rel="stylesheet" type="text/css" href="../../layui/css/layui.css">
		<script type="text/javascript" src="../../layui/layui.js"></script>
		<!-- 滚动条插件 -->
		<link rel="stylesheet" type="text/css" href="../../css/jquery.mCustomScrollbar.css">
		<script src="../../framework/jquery-ui-1.10.4.min.js"></script>
		<script src="../../framework/jquery.mousewheel.min.js"></script>
		<script src="../../framework/jquery.mCustomScrollbar.min.js"></script>
		<script src="../../framework/cframe.js"></script><!-- 仅供所有子页面使用 -->
		<!-- 公共样式 结束 -->
		
		<style>.layui-table img {
	max-width: none;
	
	.layui-form-label{
				width: 100px;
			}
			.layui-input-block{
				margin-left: 130px;
			}
			.layui-form{
				margin-right: 30%;
			}
	
	
}</style>
    
    <title>My JSP 'goods_list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <div class="cBody">
			<div class="console">
				<form class="layui-form" action="">
					<div class="layui-form-item">
						<div class="layui-input-inline">
							<input type="text" name="name" required lay-verify="required" placeholder="输入商品名称" autocomplete="off" class="layui-input">
						</div>
						
		              
						<button class="layui-btn" lay-submit lay-filter="formDemo">检索</button>
						
					</div>
				</form>

				<script>
					layui.use('form', function() {
						var form = layui.form;
				
						//监听提交
						form.on('submit(formDemo)', function(data) {
							layer.msg(JSON.stringify(data.field));
							return false;
						});
					});
				</script>
			</div>
			
			<table class="layui-table" id="customList">
				<thead>
					<tr>
						<th>商品序号</th>
						<th>商品类别</th>
						<th>商品名称</th>
						<th>商品功能</th>
						<th>参考价格</th>
						<th>详细介绍</th>
						<th>图片</th>
						<th>操作</th>
						
					</tr>
				</thead>
				<tbody>
				<%List<Product> products=(List<Product>) request.getAttribute("houtaiproductlist");
				
				for(int i=0;i<products.size();i++){ %>
				
				
				<tr>
						<td><%=products.get(i).getCpid()  %>  </td>
						<td><%=products.get(i).getTypeid() %></td>
					
						
						<td><%=products.get(i).getName() %></td>
						<td><%=products.get(i).getFunction() %></td>
						<td><%=products.get(i).getPrice() %></td>
						<td><%=products.get(i).getContent() %></td>
							<td><img src="<%=products.get(i).getImg() %>" width="20" height="20" onmouseenter="imgBig(this)" onmouseleave="imgSmall(this)"/></td>
						<td>
							<button class="layui-btn layui-btn-xs" onclick="updateBut()">修改</button>
								<a class="layui-btn layui-btn-xs" onclick="delCustomList(this)">删除</a>
						</td>
					</tr>
				
				
				
				
				
				
				
				
				<%} %>
				
					
					<tr>
						<td>1</td>
						<td>1</td>
					
						
						<td>meizu16th</td>
						<td>屏上指纹</td>
						<td>2659</td>
						<td>就是666</td>
							<td><img src="../../images/魅族16th.png" width="20" height="20" onmouseenter="imgBig(this)" onmouseleave="imgSmall(this)"/></td>
						<td>
							<button class="layui-btn layui-btn-xs" onclick="updateBut()">修改</button>
								<a class="layui-btn layui-btn-xs" onclick="delCustomList(this)">删除</a>
						</td>
					</tr>
				</tbody>
			</table>
			
			<!-- layUI 分页模块 -->
			<div id="pages"></div>
		<!-- layUI 分页模块 -->
			<div id="pages"></div>
			<script>
				layui.use('laypage', function() {
					var laypage = layui.laypage;
				
					//总页数大于页码总数
					laypage.render({
					    elem: 'pages'
					    ,count: 100
					    ,layout: ['count', 'prev', 'page', 'next', 'limit', 'skip']
					    ,jump: function(obj){
//					      console.log(obj)
					    }
					});
				});
				
				//修改按钮
				var updateFrame = null;
				function updateBut(){
					layui.use('layer', function() {
						var layer = layui.layer;
							
						//iframe层-父子操作
						updateFrame = layer.open({
                    		title: "商品信息修改",
							type: 2,
							area: ['70%', '60%'],
							scrollbar: false,	//默认：true,默认允许浏览器滚动，如果设定scrollbar: false，则屏蔽
							maxmin: true,
							content: 'goods_update.html'
						});
					});
					
				}
			</script>
		</div>
		<style>
		.layui-input{
				
				width:230px;
				height: 30px;
			}
		</style>
		<div class="cBody">
			<form id="addForm" class="layui-form" action="">
				
				<div class="layui-form-item">
					<label class="layui-form-label">商品类别</label>
					<div class="layui-input-block">
						<input type="text" name="type" required lay-verify="required" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">商品名称</label>
					<div class="layui-input-block">
						<input type="text" name="goodsName" required lay-verify="required" autocomplete="off" class="layui-input">
					</div>
				</div>
				
				
				<div class="layui-form-item">
					<label class="layui-form-label">功能</label>
					<div class="layui-input-block">
						<input type="text" name="function" required lay-verify="required" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">参考价格</label>
					<div class="layui-input-block">
						<input type="text" name="price" required lay-verify="required|number" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">详细介绍</label>
					<div class="layui-input-block">
						<input type="text" name="content" required lay-verify="required" autocomplete="off" class="layui-input">
					</div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label">商品图片</label>
						<div class="layui-input-block">
						<input type="text" name="img" required lay-verify="required" autocomplete="off" class="layui-input">
					</div>
				</div>
				
				
				
				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn" lay-submit lay-filter="submitBut" onclick="addCustomList('customList')">立即提交</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
			</form>
  </body>
</html>
