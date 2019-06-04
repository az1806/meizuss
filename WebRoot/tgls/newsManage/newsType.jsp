<%@ page language="java" import="java.util.*,com.jiaju.entity.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
		
		<link rel="stylesheet" type="text/css" href="iconfont.css">
		
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
<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
    
   
    
	


  
 <body>
		<div class="cBody">
			<div class="console">
				<form class="layui-form" action="">
					
				</form>

				<script>
				
		    
				
				function add() {
	
		var typename = document.getElementById("typename").value;
if(typename==""){
alert("输入框不能为空");

}else{
   window.location.href="adminnewstype?method=add&typename="+typename;
}
     
		
	
			
	}
	

	/*  function del(e) {
   var typeid=e.getAttribute("data-id");
     var typename=e.getAttribute("data-name");
   var a=confirm("你确定要删除"+typename+"这个类别嘛");
   if(a){
   window.location.href="adminnewstype?method=del&typeid="+typeid;
   }else{
   
   alert("删除失败");
   }
   
   

	}		 */
				
				
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
			
			<table class="layui-table">
			
			
				<thead>
					<tr>
						<th>序号</th>
						<th>新闻类型</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
				<form>
				 <%    List<NewsType> nts = ( List<NewsType> ) request.getAttribute("hnewstype");
                
                   for (int i=0;i<nts.size();i++) {
                     %>
                     <tr>
						<td><%=nts.get(i).getTypeid() %></td>
						<td><%=nts.get(i).getTypename() %></td>
						<td>
						
						
							<a  class="layui-btn layui-btn-xs"  href="adminnewstype?method=del&typeid=<%=nts.get(i).getTypeid()  %>" onclick="return confirm('你确定要删除嘛')">删除 </a>
						</td>
					</tr>
   
                     <%
                   }
                   %>		
				</form>
				
				
				
					
				</tbody>
				
				
			</table>
			<form>
			<table>

				<tr>

					<td>请输入新闻类别名称</td>
					<td><input id="typename" name="typename">
					</td>
				</tr>
				<tr>
					<td><input type="button" onclick="add()" value="确定添加" /></td>
				</tr>

			</table>

		</form>
			
			<!-- layUI 分页模块 -->
			
		</div>
	</body>

</html>
