<%@ page language="java" import="java.util.*,com.jiaju.entity.*"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List<News> newslist=(ArrayList<News>)request.getAttribute("newslist");
List<NewsType> newstype=(ArrayList<NewsType>) request.getAttribute("newstype");
List<News> searchnews=(ArrayList<News>) request.getAttribute("searchnews");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'new_list.jsp' starting page</title>

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
}
</style>
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
</head>

<body>
	<div class="cBody">

		<div class="console">

			<form>



				<span>请选择新闻类别</span> <select>
					<option selected="selected" value=0>请选择</option>
					<%
						for(int i=0;i<newstype.size();i++){
					%>

					<option value="<%=newstype.get(i).getTypeid()%>"><%=newstype.get(i).getTypename()%>
					</option>


					<%
						}
					%>

				</select>

				<div class="layui-form-item">
					<span class="layui-input-inline"> <input type="text"
						name="stitle" id="stitle" required lay-verify="required"
						placeholder="请输入新闻标题名称" autocomplete="off" class="layui-input">
					</span> <span class="layui-input-inline"> <input type="text"
						name="scontent" id="scontent" required lay-verify="required"
						placeholder="请输入新闻内容" autocomplete="off" class="layui-input">
					</span>

					<button class="layui-btn" type="button" onclick="search()"
						style="margin-left: 30px">检索</button>




				</div>

			</form>

			<script>
				function search() {		
					var stypeid = $("select option:selected").val();
					var stitle = $("#stitle").val();
					var scontent = $("#scontent").val();
					if (stypeid == "") {
						stypeid = null;
					}
					
					
					window.location.href = "adminnewss?method=search&typeid="
							+ stypeid + "&title=" + stitle + "&content="
							+ scontent;

				}

				function add() {
					var typeid = document.getElementById("typeid").value;
					var title = document.getElementById("title").value;
					var content = document.getElementById("content").value;
					var time = document.getElementById("time").value;
					if (typeid == "" || title == "" || content == ""
							|| time == "") {
						alert("有输入框为空啦，请检查");
					} else {
						window.location.href = "adminnewss?method=add&typeid="
								+ typeid + "&title="
								+ encodeURI(encodeURI(title)) + "&content="
								+ encodeURI(encodeURI(content)) + "&time="
								+ time + "";
					}

				}
				function del(e) {
					var newsid = e.getAttribute("data-id");

					var a = confirm("你确定要删除该新闻嘛");

					if (a) {
						window.location.href = "adminnewss?method=del&newsid="
								+ newsid;

					}

				}

				/**		layui.use('form', function() {
							var form = layui.form;
				window.location.href="adminnewss?method=add&typeid="+typeid+"";
							//监听提交
							form.on('submit(formDemo)', function(data) {
								layer.msg(JSON.stringify(data.field));
								return false;
							});
						});
				 */
				//添加一个资讯
			</script>




		</div>

		<table class="layui-table" id="customList">
			<thead>
				<tr>
					<th>资讯序号</th>
					<th>咨讯类别</th>
					<th>标题</th>

					<th>时间</th>
					<th>操作</th>

				</tr>
			</thead>
			<tbody>
				<%
					if( searchnews!=null){
			
					for(int i=0;i<searchnews.size();i++){
				%>
				<tr>


					<td><%=i+1%></td>
					<td><%=searchnews.get(i).getTypeid()%></td>


					<td><%=searchnews.get(i).getTitle()%></td>
					<td><%=searchnews.get(i).getContent()%></td>
					<td><%=searchnews.get(i).getTime()%></td>

					<td>
						<button onclick="del(this)" class="layui-btn layui-btn-xs"
							data-id="<%=searchnews.get(i).getNewsid()%>">删除</button>
						<button onclick="updateBut(this)" class="layui-btn layui-btn-xs"
							data-id="<%=searchnews.get(i).getNewsid()%>">修改</button>
					</td>
				</tr>
				<%
					}
				%>









				<%
					}else{
				%>









				<%
					for(int i=0;i<newslist.size();i++){
				%>
				<tr>


					<td><%=i+1%></td>
					<td><%=newslist.get(i).getTypeid()%></td>


					<td><%=newslist.get(i).getTitle()%></td>
					<td><%=newslist.get(i).getContent()%></td>
					<td><%=newslist.get(i).getTime()%></td>

					<td>
						<button onclick="del(this)" class="layui-btn layui-btn-xs"
							data-id="<%=newslist.get(i).getNewsid()%>">删除</button>
						<button onclick="updateBut(this)" class="layui-btn layui-btn-xs"
							data-id="<%=newslist.get(i).getNewsid()%>">修改</button>
					</td>
				</tr>
				<%
					}}
				%>

			</tbody>
		</table>

		<h2>实现添加</h2>






		<div class="cBody">



			<form>
				<table>

					<tr>

						<td>资讯类别</td>
						<td><input id="typeid" class="layui-input"></td>


					</tr>
					<tr>

						<td>资讯标题</td>
						<td><input id="title" class="layui-input"></td>


					</tr>
					<tr>

						<td>资讯内容</td>
						<td><input id="content" class="layui-input"></td>


					</tr>
					<tr>

						<td>资讯时间</td>
						<td><input id="time" class="layui-input"></td>
					</tr>
					<tr>


						<td><input type="button" onclick="add()" value="提交"
							class="layui-btn"> <input type="reset" class="layui-btn">
						</td>


					</tr>



				</table>




			</form>

		</div>

		<!-- layUI 分页模块 -->
		<div id="pages"></div>

		<script>
			layui.use('laypage', function() {
				var laypage = layui.laypage;

				//总页数大于页码总数
				laypage
						.render({
							elem : 'pages',
							count : 100,
							layout : [ 'count', 'prev', 'page', 'next',
									'limit', 'skip' ],
							jump : function(obj) {
								//					      console.log(obj)
							}
						});
			});

			//修改按钮
			var updateFrame = null;

			function updateBut(e) {
				var newsid = e.getAttribute("data-id");
				alert(newsid);
				layui.use('layer', function() {
					var layer = layui.layer;

					//iframe层-父子操作
					updateFrame = layer.open({
						title : "资讯信息修改",
						type : 2,
						area : [ '70%', '60%' ],
						scrollbar : false, //默认：true,默认允许浏览器滚动，如果设定scrollbar: false，则屏蔽
						maxmin : true,
						content : 'adminnewss?method=zhezhao&newsid=' + newsid
					});
				});

			}
		</script>
	</div>
	<style type="text/css">
.layui-input {
	width: 230px;
	height: 30px;
}
</style>





</body>
</html>
