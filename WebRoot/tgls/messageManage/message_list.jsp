<%@ page language="java" import="java.util.*,com.jiaju.entity.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List<Message> Searlist=(List<Message>) request.getAttribute("Searlist");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <base href="<%=basePath%>">
  <head>
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
		<script src="framework/cframe.js"></script><!-- 仅供所有子页面使用 -->
		<!-- 公共样式 结束 -->
		
		<style>.layui-table img {
	max-width: none;
}</style>
   
    
    <title>My JSP 'message_list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
 <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
 
 <script type="text/javascript">
function updateState(e){

var id=e.getAttribute("data-id");
var state=e.getAttribute("data-name");
alert(state);
window.location.href="adminmessage?method=update&lyid="+id+"&state="+state+"";


}

function search(){

var searchstate=document.getElementById("state").value;
window.location.href="adminmessage?method=search&searchstate="+searchstate+"";

}

 
 </script>
  </head>
  
  <body>
  <div class="cBody">
			<div class="console">
				<form class="layui-form" action="">
					<div class="layui-form-item">
						<div class="layui-input-inline">
						
							<input type="text" id="state" required lay-verify="required"  autocomplete="off" class="layui-input">
						</div>
						
		              
						<button class="layui-btn" type="button" onclick="search()">检索</button>
						
					</div>
				</form>

				<script>layui.use('form', function() {
	var form = layui.form;

	//监听提交
	form.on('submit(formDemo)', function(data) {
		layer.msg(JSON.stringify(data.field));
		return false;
	});
});</script>
			</div>
			
			<table class="layui-table" border="1px">
				<thead>
					<tr>
						<th>留言序号</th>
						<th>留言者姓名</th>
						<th>手机号</th>
						<th>电子邮件</th>
						
						<th>内容</th>
						<th>状态</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
   
				<%if(request.getParameter("searchstate")!=null){
				
				
				for(int i=0;i<Searlist.size();i++){%>
				
				
				<tr>
						<td><%=i+1 %></td>
						<td><%=Searlist.get(i).getName() %></td>
					
						
						<td><%=Searlist.get(i).getPhone() %></td>
						<td><%=Searlist.get(i).getEmail() %></td>
						<td><%=Searlist.get(i).getContent() %></td>
						<td><%=Searlist.get(i).getState() %></td>
							
						<td>
						<a class="layui-btn layui-btn-xs" href="adminmessage?method=del&lyid=<%=Searlist.get(i).getLyid() %>"  onclick="return confirm('你确定要删除嘛？')">删除  </a>
							<button class="layui-btn layui-btn-xs" onclick="updateState(this)" data-id="<%=Searlist.get(i).getLyid() %>" data-name="<%=Searlist.get(i).getState() %>">修改状态</button>
						</td>
					</tr>
				
				
				
				
				
				
				
				
				
			<%	}}else{   

		
				
				List<Message> messlist=(ArrayList<Message>) request.getAttribute("messages"); 
				
				
				for(int i=0;i<messlist.size();i++){%>
				
				
				<tr>
						<td><%=messlist.get(i).getLyid() %></td>
						<td><%=messlist.get(i).getName() %></td>
					
						
						<td><%=messlist.get(i).getPhone() %></td>
						<td><%=messlist.get(i).getEmail() %></td>
						<td><%=messlist.get(i).getContent() %></td>
						<td><%=messlist.get(i).getState() %></td>
							
						<td>
						<a class="layui-btn layui-btn-xs" href="adminmessage?method=del&lyid=<%=messlist.get(i).getLyid() %>"  onclick="return confirm('你确定要删除嘛？')">删除  </a>
							<button class="layui-btn layui-btn-xs" onclick="updateState(this)" data-id="<%=messlist.get(i).getLyid() %>" data-name="<%=messlist.get(i).getState() %>">修改状态</button>
						</td>
					</tr>
				
				
				
			<%	}}
				 %>
			
			
			
			
		
				
				
				
				
				
				
				
				
				
				
				
					
					
					
				</tbody>
			</table>
			
			<!-- layUI 分页模块 -->
			<div id="pages"></div>
					
			
			<script>
		/*		layui.use('laypage', function() {
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
				}); */
//修改规格
function specificationsBut() {
	layui.use('layer', function() {
		var layer = layui.layer;

		//iframe层-父子操作
		layer.open({
			type: 2,
			area: ['70%', '60%'],
			fixed: false, //不固定
			maxmin: true,
			content: 'specifications_list.html'
		});
	});

}
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
			content: 'goods_update.html'
		});
	});

}</script>
		</div>
		
  </body>
</html>
