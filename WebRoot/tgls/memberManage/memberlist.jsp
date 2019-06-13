<%@ page language="java" import="java.util.*,com.jiaju.entity.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List<Member> memlist=(ArrayList<Member>) request.getAttribute("memlist");
//Member mem=(Member) request.getAttribute("mem");


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
		<link rel="stylesheet" type="text/css" href="layui/css/layui.css">
<script type="text/javascript" src="layui/layui.js"></script>
		<link rel="stylesheet" type="text/css" href="../../layui/css/layui.css">
		<script type="text/javascript" src="../../layui/layui.js"></script>
		<!-- 滚动条插件 -->
		<link rel="stylesheet" type="text/css" href="css/jquery.mCustomScrollbar.css">
		<script src="framework/jquery-ui-1.10.4.min.js"></script>
		<script src="framework/jquery.mousewheel.min.js"></script>
		<script src="framework/jquery.mCustomScrollbar.min.js"></script>
		<script src="framework/cframe.js"></script><!-- 仅供所有子页面使用 -->
		<!-- 公共样式 结束 -->
		
		<style>.layui-table img {
	max-width: none;
}
th{

background-color:cornflowerblue;


}
#big{

border-collapse: collapse;


}
#zzc_cover{
	position: absolute;
	z-index: 2;
	left: 0px;
	top: 0px;
	opacity: 0.5;
	display: none;
	background-color:cornflowerblue;

	
	
}
#zzc_content{
	position:  absolute;
    z-index: 3;
    left: 0px;
    top: 0px;
    display: none;
    	
	
	
}
#zzc_content>.zzc_f{
	background-color: white;
 width: 400px;
 height: 300px;
 margin: 50px auto;	
	
}



</style>

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
 <script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
  

	<body>
		<div class="cBody">
			
				

				<script type="text/javascript">
		//添加一个成员	
		
		
		function add(){
		
		var name=document.getElementById("name").value;
		var position=document.getElementById("position").value;
		var photo=document.getElementById("photo").value;		
	
		if(name==""||position==""||photo==""){
		alert("有输入框为空啦,请检查");
		}else{
		window.location.href="adminmember?method=add&name="+encodeURI(encodeURI(name))+"&position="+encodeURI(encodeURI(position))+"&photo="+encodeURI(encodeURI(photo))+"";
		}
		
		
	/**	$.post("adminmember?method=add",{"name":name,"position":position,"photo":photo},function(res){		
		if(res.succsess){
		
		
			alert(res.message);
			
		}else{
		alert(res.message);
		}
		
		},"json") ;*/ 
		
		
			
	
		}

			
		
			
			
			
			
			//修改按钮
				var updateFrame = null;
				function updateBut(e) {
          
					layui.use('layer', function() {
					
						var layer = layui.layer;
                         var id=e.getAttribute("data-id");
                         alert(id);
						//iframe层-父子操作
						updateFrame = layer.open({
							title : "商品信息修改",
							type : 2,
							area : [ '70%', '60%' ],
							scrollbar : false, //默认：true,默认允许浏览器滚动，如果设定scrollbar: false，则屏蔽
							maxmin : true,
							content : 'adminmember?method=zhezao&id='+id
							
						});
					});

				}
 

</script>
			</div>
			
			<table  border="1px" id="big" >
				<thead>
					<tr>
						<th>序号</th>
						<th>姓名</th>
						<th>职位</th>
						<th>照片</th>
						
						<th>操作</th>
						
					</tr>
				</thead>
				<tbody>
				<%for(int i=0;i<memlist.size();i++){ %>
				
				
				<tr>
						<td><%=i+1 %></td>
						<td><%=memlist.get(i).getName() %></td>
					
						
						<td><%=memlist.get(i).getPosition() %></td>
						<td><img src="<%=memlist.get(i).getPhoto() %>"  width="20"
						         height="20" onmouseenter="imgBig(this)"
					                      	onmouseleave="imgSmall(this)"/></td>
						
							
						<td>
						
										
							 <button class="layui-btn layui-btn-xs" onclick="updateBut(this)" data-id="<%=memlist.get(i).getId() %>">修改</button>
						     
							
							
							
							
							
							<a href="adminmember?method=del&id=<%=memlist.get(i).getId() %>" onclick="return confirm('你确定要删除嘛')" class="layui-btn layui-btn-xs" > 删除</a>
						</td>
					</tr>
				
				
		<%		} %>
					
					
					
				</tbody>
			</table>
			
			<!-- layUI 分页模块 -->
			<div id="pages"></div>
							
			
			
			<script>
			
				 
		          
				
				
				

/*  
遮罩层函数
 */

	
	 var layer,upload;
	 $(function(){
	 layui.use(['layer','upload'],function(){
	 
	 layer=layui.layer;
	 upload=layui.upload;
	 upload.render({
	 elem:'#test1',
     url:'adminmember?method=saveImg', //服务器端接收文件数据的地址
	 done:function(res){
	 layer.alert(res.message);
   $("#photo").val(res.message);
  
   
	 }

	 });

	 });

	 });
   
   
</script>
		</div>
		<style type="text/css">
			.layui-input{
				
				width:230px;
				height: 30px;
			}
			#img{
			
			
			}
			
		</style>
		<h2>实现添加</h2>
		<div class="cBody">
			<form id="addForm"  class="form-x">
				
				<div id="head">  </div> 
				
				  
				<div class="layui-form-item">
					<label class="layui-form-label">姓名</label>
					<div class="layui-input-block">
						<input type="text" name="name"  id="name" required lay-verify="required" autocomplete="off" class="layui-input">
					</div>
				</div>
				
				
				<div class="layui-form-item">
					<label class="layui-form-label">职位</label>
					<div class="layui-input-block">
						<input type="text" name="position" id="position" required lay-verify="required" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">照片路径</label>
					<div class="layui-input-block">
						<input type="text" name="photo" id="photo" required lay-verify="required" autocomplete="off" class="layui-input">
					</div>
				</div>
		
				<div class="layui-form-item">
					<div class="layui-input-block">
						
						<input type="button" class="layui-btn" value="增加成员"  onclick="add()"> 
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
				
				
				
<img id="imgFace" style="width:120px" /><br />        
        <input type="file" name="file" class="layui-upload-file" />    <br />
        <button type="button" class="layui-btn" id="test1">上传图片</button>
				
				
				
			</form>
			
			
			
			<!-- 
			
			
			遮罩层内显示 修改内容
			
			 -->
<div id="zzc_content">
	
	<div class="zzc_f">
		<table>
			
			<tr>
				<td>姓名</td>
				
				<td><input type="text" id="name" name="name" ></td>
				
				
				
			</tr>
				<tr>
				<td>职位</td>
				
				<td><input type="text" id="position" name="position"></td>
				
			</tr>
			<tr>
				<td>照片</td>
				
				<td><input type="text" id="photo" name="photo"></td>
				
			</tr>
			
			
			
			<tr>
				 <td><input type="button" value="确定"   onclick="update()"/></td>
			     <td><input type="button" value="关闭"   onclick="closes()"/></td>
			
			</tr>
		</table>
	</div>
	
</div>
<div id="zzc_cover"></div>
  </body>
</html>
