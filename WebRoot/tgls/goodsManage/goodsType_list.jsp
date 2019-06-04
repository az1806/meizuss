<%@ page language="java" import="java.util.*,com.jiaju.entity.*"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List<ProductClass> pts = (List<ProductClass>) request.getAttribute("hproductclass");
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
<link rel="stylesheet" type="text/css" href="css/base.css">
<link rel="stylesheet" type="text/css" href="css/iconfont.css">
<script type="text/javascript"
	src="framework/jquery-1.11.3.min.js"></script>
<link rel="stylesheet" type="text/css" href="layui/css/layui.css">
<script type="text/javascript" src="layui/layui.js"></script>
<!-- 滚动条插件 -->
<link rel="stylesheet" type="text/css"
	href="css/jquery.mCustomScrollbar.css">
<script src="framework/jquery-ui-1.10.4.min.js"></script>
<script src="framework/jquery.mousewheel.min.js"></script>
<script src="framework/jquery.mCustomScrollbar.min.js"></script>
<script src="framework/cframe.js"></script>
<!-- 仅供所有子页面使用 -->
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
<script type="text/javascript">
	function add() {
		
		var typename = document.getElementById("typename").value;
       if(typename==""){
       
       alert("类别名称不能为空");
       }else{
       
    window.location.href="adminproducttype?method=add&typename="+encodeURI(encodeURI(typename));
       }




		//1.url地址  2.参数  3.回调函数  4.返回类型
	/*	$.post("adminproducttype?method=add", {
			
			"typename" : typename
		}, function(res) {//服务器返回的内容
			if (res.success) {
				alert(res.message);
				location.reload(true);
				//跳转页面
			} else {
				alert(res.message);
			}
		}, "json");  */
	}

	function del(e) {
	var type=e.getAttribute("data-name");
	var typeid=e.getAttribute("data-id");
    var a=confirm("你确定要删除"+type+"这个类别嘛"); 
     if(a){
     
     window.location.href="adminproducttype?method=del&typeid="+typeid;
     
     }
     



	} 
	
</script>

</head>




<body>
	<div class="cBody">
		<div class="console">
			<form class="layui-form" action=""></form>

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






		<table class="layui-table" border="1px">
			<thead>
				<tr>
					<th>序号</th>
					<th>商品类别名称</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>


				<%
					for (int i = 0; i < pts.size(); i++) {
				%>
				<tr>
					<td id="typeids"><%=pts.get(i).getTypeid()%></td>
					<td><%=pts.get(i).getTypename()%>
						</td>
					<td>

						
					<button data-id="<%=pts.get(i).getTypeid()  %>"
					data-name="<%=pts.get(i).getTypename() %>"
     onclick="del(this)"  class="layui-btn layui-btn-xs"
							> 删除
							</button>
					</td>
				</tr>

				<%
					}
				%>

			</tbody>
		</table>
		<form>
			<table>

				
				<tr>

					<td>请输入商品类别名称</td>
					<td><input id="typename" name="typename">
					</td>
				</tr>
				<tr>
					<td><input type="button" onclick="add()"  class="layui-btn layui-btn-xs" value="确定添加" /></td>
				</tr>

			</table>

		</form>









	</div>
</body>
</html>
