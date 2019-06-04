<%@ page language="java" import="java.util.*,com.jiaju.entity.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Company com=(Company) request.getAttribute("com");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'companylist.jsp' starting page</title>
    
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
		<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
		<style>.layui-table img {
	max-width: none;
}</style>

  </head>
  
  <body>
   		<div class="cBody">
			

				<script>layui.use('form', function() {
	var form = layui.form;

	//监听提交
	form.on('submit(formDemo)', function(data) {
		layer.msg(JSON.stringify(data.field));
		return false;
	});
	
});

function updateCompany(){
var id=document.getElementById("companyid").value;
var companyname=document.getElementById("companyname").value;
var syjs=document.getElementById("syjs").value;
var gyjs=document.getElementById("gyjs").value;
var culture=document.getElementById("culture").value;
var address=document.getElementById("address").value;
var email=document.getElementById("email").value;
var contact=document.getElementById("contact").value;
var imgzong=document.getElementById("imgzong").value;
var www=document.getElementById("www").value;

window.location.href="admincompany?method=update&id="+id+"&companyname="+encodeURI(encodeURI(companyname))
+"&syjs="+encodeURI(encodeURI(syjs))
+"&gyjs="+encodeURI(encodeURI(gyjs))
+"&culture="+encodeURI(encodeURI(culture))
+"&address="+encodeURI(encodeURI(address))
+"&email="+encodeURI(encodeURI(email))+"&contact="+encodeURI(encodeURI(contact))+"&imgzong="+encodeURI(encodeURI(imgzong))+"&www="+encodeURI(encodeURI(www))+"";




}







</script>
			</div>
			
			<table class="layui-table">
				<thead>
					<tr>
						<td>序号</td>
						<td><input value="<%=com.getCompanyid()%>" id="companyid"></td>
					</tr>
					<tr>	
						<td>公司名称</td>
							<td><input value="<%=com.getCompanyname()%>" id="companyname"></td>
						</tr>
						<tr>
						<td>公司首页介绍</td>
						<td>
						
						<textarea rows="5" cols="50" id="syjs"><%=com.getSyjs() %></textarea>
						
						</td>
						
						
						</tr>
						<tr>
						<td>关于公司介绍</td>
							<td>  
							<textarea rows="5" cols="50" id="gyjs"><%=com.getGyjs() %></textarea>
							
							
							   </td>
						</tr>
						<tr>
						<td>公司文化</td>
							<td>
							
								<textarea rows="5" cols="50" id="culture"><%=com.getCulture() %></textarea>
							
							</td>
						</tr>
						<tr>
						<td>地址</td>
						<td>
						<input value="<%=com.getAddress() %>" id="address">					
						</td>
						</tr>
						<tr>
						<td>电子邮箱</td>
						<td><input value="<%=com.getEmail() %>" id="email">     </td>
							</tr>
						<tr>
						<td>联系方式</td>
						<td><input value="  <%=com.getContact() %>" id="contact">    </td>
						</tr>
						<tr>
						<td>公司图片</td>
						<td><input value="<%=com.getImgzong() %>" id="imgzong">     </td>
						</tr>
						<tr>
						<td>网址</td>
						<td><input value="  <%=com.getWww() %>" id="www">    </td>
						</tr>
						<tr>
						<td>操作</td>
						<td>
						<!--	 <button class="layui-btn layui-btn-xs" onclick="updateCompany()">修改</button> -->
							<input type="button" onclick="updateCompany()" value="修改" class="layui-btn layui-btn-xs"> 
						</td>
					</tr>
				</thead>
				<tbody>
					
					
					
				</tbody>
			</table>
			
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

function updateBut() {
	layui.use('layer', function() {
		var layer = layui.layer;

		//iframe层-父子操作
		updateFrame = layer.open({
			title: "商品信息修改",
			type: 2,
			area: ['70%', '60%'],
			scrollbar: false, //默认：true,默认允许浏览器滚动，如果设定scrollbar: false，则屏蔽
			maxmin: true,
			content: 'company_update.html'
		});
	});

}</script>
		</div>
		<style type="text/css">
			.layui-input{
				
				width:230px;
				height: 30px;
			}
			
			
		</style>
  </body>
</html>
