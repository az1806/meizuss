<%@page import="com.sun.xml.internal.txw2.Document"%>
<%@ page language="java" import="java.util.*,com.jiaju.entity.*"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List<Product> prosearch=(ArrayList<Product>) request.getAttribute("prosearch");
List<Product> products=(List<Product>) request.getAttribute("houtaiproductlist");
List<ProductClass> pclist=(List<ProductClass> ) request.getAttribute("pclist");
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
<script type="text/javascript" src="framework/jquery-1.11.3.min.js"></script>
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

<style>
.layui-table img {
	max-width: none;
	.
	layui-form-label
	{
	width
	:
	100px;
}

.layui-input-block {
	margin-left: 130px;
}

.layui-form {
	margin-right: 30%;
}
}
</style>

<title>My JSP 'goods_list.jsp' starting page</title>

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
	
</script>
</head>

<body>
	<div class="cBody">
		<div class="console">
			<form class="layui-form">
				<div class="layui-form-item">
					<span>请选择类别</span> <select>
						<option selected="selected" value=0></option>
						<%
							for(int i=0;i<pclist.size();i++){
						%>
						<option value="<%=pclist.get(i).getTypeid()%>"><%=pclist.get(i).getTypename()%>
						</option>


						<%
							}
						%>
					</select> <span class="layui-input-inline"> <input type="text"
						name="name" required lay-verify="required" placeholder="输入商品名称"
						autocomplete="off" id="names" class="layui-input"> </span> <span
						class="layui-input-inline"> <input type="text" required
						lay-verify="required" id="sfunction" placeholder="输入商品功能"
						autocomplete="off" class="layui-input"> </span> <span
						class="layui-input-inline"> <input type="text" required
						lay-verify="required" id="content" placeholder="输入商品内容"
						autocomplete="off" class="layui-input"> </span> <input
						type="button" class="layui-btn" onclick="searchs()" value="检索">
				</div>
			</form>

			<script>
				function searchs() {
					var typeid = $("select option:selected").val();
				
					var names = $("#names").val();
					
					var sfunction = $("#sfunction").val();
					
					var content = $("#content").val();
					
					window.location.href = "adminproduct?method=search&name="
							+ names + "&sfunction=" + sfunction + "&content="
							+ content + "&typeid=" + typeid;

				}

				function add() {
					var addtypeid = document.getElementById("addtypeid").value;
					var addname = document.getElementById("addname").value;

					var addfunction = document.getElementById("addfunction").value;
					var addprice = document.getElementById("addprice").value;
					var addimg = document.getElementById("addimg").value;
					var addcontent = document.getElementById("addcontent").value;
					if (addtypeid == "" || addname == "" || addfunction == ""
							|| addprice == "" || addimg == ""
							|| addcontent == "") {
						alert("有输入框为空啦")

					} else {
						window.location.href = "adminproduct?method=add&addtypeid="
								+ addtypeid
								+ "&addname="
								+ addname
								+ "&addfunction="
								+ encodeURI(encodeURI(addfunction))
								+ "&addprice="
								+ addprice
								+ "&addimg="
								+ addimg
								+ "&addcontent="
								+ encodeURI(encodeURI(addcontent)) + "";

					}

				}

				/**	
				
				
				
				
					$.post("adminproduct?method=add", {
							"addtypeid":addtypeid,"addname":addname,"addfunction":addfunction,"addprice":addprice,"addimg":addimg,"addcontent":addcontent
						}, function(res) {
							alert("商品加入成功");	window.location.href="adminmember?method=add&name="+name+"&position="+position+"&photo="+photo+"";
						}, "json");
				  window.location.reload();

				setTimeout(add , 500);  */
				/**
				检测typeid只能为数字
				
				function checkTypeid(){
				
				var typeid=$("#addtypeid").val();
				alert(typeid);
				
				
				
				} */

				function del(e) {
					var cpid = e.getAttribute("data-id");
					var a = confirm("您确认删除该商品吗?");

					if (a) {

						window.location.href = "adminproduct?method=del&cpid="
								+ cpid;

					}

				}

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
								$("#addimg").val(res.message);

							}

						});

					});

				})

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

		<table class="layui-table" id="customList" style="font-size: 10px">
			<thead>
				<tr>
					<th>商品序号</th>
					<th>商品类别</th>
					<th>商品名称</th>
					<th>商品功能</th>
					<th>参考价格</th>

					<th>图片</th>
					<th>商品详情</th>
					<th>操作</th>

				</tr>
			</thead>
			<tbody>

				<%
					if(prosearch!=null){
					  for(int i=0;i<prosearch.size();i++){
				%>


				<tr>
					<td><%=i+1%></td>
					<td><%=prosearch.get(i).getTypeid()%></td>

					<td><%=prosearch.get(i).getName()%></td>
					<td><%=prosearch.get(i).getFunction()%></td>
					<td><%=prosearch.get(i).getPrice()%></td>

					<td><img src="<%=prosearch.get(i).getImg()%>" width="20"
						height="20" onmouseenter="imgBig(this)"
						onmouseleave="imgSmall(this)" /></td>
					<td><%=prosearch.get(i).getContent()%></td>
					<td>
						<button class="layui-btn layui-btn-xs" onclick="updateBut(this)"
							data-id="<%=prosearch.get(i).getCpid()%>">修改</button>


						<button class="layui-btn layui-btn-xs" onclick="del(this)"
							data-id="<%=prosearch.get(i).getCpid()%>">删除</button></td>







					<%
						}  }else{
					%>




					<%
						for(int i=0;i<products.size();i++){
					%>
				
				<tr>
					<td><%=i+1%></td>
					<td><%=products.get(i).getTypeid()%></td>

					<td><%=products.get(i).getName()%></td>
					<td><%=products.get(i).getFunction()%></td>
					<td><%=products.get(i).getPrice()%></td>

					<td><img src="<%=products.get(i).getImg()%>" width="20"
						height="20" onmouseenter="imgBig(this)"
						onmouseleave="imgSmall(this)" /></td>
					<td><%=products.get(i).getContent()%></td>
					<td>
						<button class="layui-btn layui-btn-xs" onclick="updateBut(this)"
							data-id="<%=products.get(i).getCpid()%>">修改</button>


						<button class="layui-btn layui-btn-xs" onclick="del(this)"
							data-id="<%=products.get(i).getCpid()%>">删除</button></td>
				</tr>
				<%
					}}
				%>



			</tbody>

		</table>



		<style>
.layui-input {
	width: 230px;
	height: 30px;
}
</style>
		<div class="cBody">
			<form class="layui-form">

				<div class="layui-form-item">
					<label class="layui-form-label">商品类别</label>
					<div class="layui-input-block">
						<input type="text" name="typeid" id="addtypeid" required
							lay-verify="required" autocomplete="off" class="layui-input"
							onblur="checkTypeid()" />
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">商品名称</label>
					<div class="layui-input-block">
						<input type="text" name="name" id="addname" required
							lay-verify="required" autocomplete="off" class="layui-input">
					</div>
				</div>


				<div class="layui-form-item">
					<label class="layui-form-label">功能</label>
					<div class="layui-input-block">
						<input type="text" name="function" id="addfunction" required
							lay-verify="required" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">参考价格</label>
					<div class="layui-input-block">
						<input type="text" name="price" id="addprice" required
							lay-verify="required|number" autocomplete="off"
							class="layui-input">
					</div>
				</div>


				<div class="layui-form-item">
					<label class="layui-form-label">商品图片</label>
					<div class="layui-input-block">
						<input type="text" name="img" id="addimg" required
							lay-verify="required" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">详细介绍</label>
					<div class="layui-input-block">
						<input type="text" name="content" id="addcontent" required
							lay-verify="required" autocomplete="off" class="layui-input">
					</div>
				</div>


				<div class="layui-form-item">
					<div class="layui-input-block">

						<input type="button" class="layui-btn" value="提交" onclick="add()" />
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
				 图片：<img
					id="imgFace" style="width:120px" /><br /> <input type="file"
					name="file" class="layui-upload-file" /> <br />
				<button type="button" class="layui-btn" id="test1">上传图片</button>
				
			</form>
			
			<!-- layUI 分页模块 -->
			<div id="pages"></div>
			<script>
			
				layui.use('laypage', function() {
					var laypage = layui.laypage;

					//总页数大于页码总数
					laypage.render({
						elem : 'pages',
						count : 20,
						limit : 4,
						layout : [ 'count', 'prev', 'page', 'next', 'limit',
								'skip' ],
						jump : function(obj) {
							//					      console.log(obj)
						}
					});
				});

				//修改按钮
				var updateFrame = null;
				function updateBut(e) {
					var cpid = e.getAttribute("data-id");
					alert(cpid);
					layui.use('layer', function() {
						var layer = layui.layer;

						//iframe层-父子操作
						updateFrame = layer.open({
							title : "商品信息修改",
							type : 2,
							area : [ '70%', '60%' ],
							scrollbar : false, //默认：true,默认允许浏览器滚动，如果设定scrollbar: false，则屏蔽
							maxmin : true,
							content : 'adminproduct?method=zhezhao&cpid='
									+ cpid
						});
					});

				}
			</script>
		</div>
</body>
</html>
