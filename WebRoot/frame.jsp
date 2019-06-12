<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'frame.jsp' starting page</title>
    
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
		<link rel="shortcut icon" href="images/favicon.ico"/>
		<link rel="bookmark" href="images/favicon.ico"/>
		<link rel="stylesheet" type="text/css" href="css/base.css">
		<link rel="stylesheet" type="text/css" href="css/iconfont.css">
		<script type="text/javascript" src="framework/jquery-1.11.3.min.js" ></script>
		<link rel="stylesheet" type="text/css" href="layui/css/layui.css">
	    <!--[if lt IE 9]>
	      	<script src="framework/html5shiv.min.js"></script>
	      	<script src="framework/respond.min.js"></script>
	    <![endif]-->
		<script type="text/javascript" src="layui/layui.js"></script>
		<!-- 滚动条插件 -->
		<link rel="stylesheet" type="text/css" href="css/jquery.mCustomScrollbar.css">
		<script src="framework/jquery-ui-1.10.4.min.js"></script>
		<script src="framework/jquery.mousewheel.min.js"></script>
		<script src="framework/jquery.mCustomScrollbar.min.js"></script>
		<script src="framework/cframe.js"></script><!-- 仅供所有子页面使用 -->
		<!-- 公共样式 结束 -->
		
		<link rel="stylesheet" type="text/css" href="css/frameStyle.css">
		<script type="text/javascript" src="framework/frame.js" ></script>
  </head>
  
  <body>
   <!-- 左侧菜单 - 开始 -->
		<div class="frameMenu">
		    <div class="logo">
		       <img src="images/meizulogo.jpg" />
		        <div class="logoText">
		            <h1>魅族产品</h1>
		            <p>后台管理</p>
		        </div>
		    </div>
		    <div class="menu">
		        <ul>
		        	<li>
		                <a class="menuFA" href="javascript:void(0)" onclick="menuCAClick('tgls/qdAPI.html',this)"><i class="iconfont icon-zhishi left"></i>前端API</a>
		            </li>
		            
		        	<li>
		                <a class="menuFA" href="javascript:void(0)" onclick="menuCAClick('tgls/iconfont.html',this)"><i class="iconfont icon-huojian left"></i>iconfont字体库</a>
		           	</li>
		        	
		        	<li>
		                <a class="menuFA" href="javascript:void(0)"><i class="iconfont icon-shangpin left"></i>商品管理<i class="iconfont icon-dajiantouyou right"></i></a>
		                <dl>
		                	<dt><a href="javascript:void(0)" onclick="menuCAClick('houtaiproductclass',this)">商品分类</a></dt>
		                	<dt><a href="javascript:void(0)" onclick="menuCAClick('houtaiproductlist',this)">基本商品库</a></dt>
		                	
		                </dl>
		            </li>
		            <li>
		                <a class="menuFA" href="javascript:void(0)"><i class="iconfont icon-shangpin left"></i>资讯管理<i class="iconfont icon-dajiantouyou right"></i></a>
		                <dl>
		                	<dt><a href="javascript:void(0)" onclick="menuCAClick('houtainewstype',this)">资讯分类</a></dt>
		                	<dt><a href="javascript:void(0)" onclick="menuCAClick('adminnewss?method=query',this)">资讯</a></dt>
		                
		            </li>      
		             <li>
		                <a class="menuFA" href="javascript:void(0)"><i class="iconfont icon-shangpin left"></i>公司成员管理<i class="iconfont icon-dajiantouyou right"></i></a>
		                <dl>
	
		                	<dt><a href="javascript:void(0)" onclick="menuCAClick('houtaimembers',this)">成员</a></dt>
		                	
		                </dl>
		            </li>
		            <li>
		                <a class="menuFA" href="javascript:void(0)"><i class="iconfont icon-shangpin left"></i>公司信息<i class="iconfont icon-dajiantouyou right"></i></a>
		                <dl>
	
		                	<dt><a href="javascript:void(0)" onclick="menuCAClick('houtaicompany',this)">信息</a></dt>

		                </dl>
		            </li>
		             <li>
		                <a class="menuFA" href="javascript:void(0)"><i class="iconfont icon-shangpin left"></i>在线留言<i class="iconfont icon-dajiantouyou right"></i></a>
		                <dl>
	
		                	<dt><a href="javascript:void(0)" onclick="menuCAClick('houtaimessage',this)">留言</a></dt>
		                	
		                </dl>
		            </li>
		            
		        	
		        	
		        	
		        </ul>
		    </div>
		</div>
		<!-- 左侧菜单 - 结束 -->
		
		<div class="main">
			<!-- 头部栏 - 开始 -->
			<div class="frameTop">
				<img class="jt" src="images/top_jt.png"/>
				<div class="topMenu">
					<ul>
						<li><a href="javascript:void(0)" onclick="menuCAClick('tgls/modify_password.html',this)"><i class="iconfont icon-yonghu1"></i>管理员</a></li>
						<li><a href="javascript:void(0)" onclick="menuCAClick('tgls/modify_password.html',this)"><i class="iconfont icon-xiugaimima"></i>修改密码</a></li>
						<li><a href="login.html"><i class="iconfont icon-084tuichu"></i>注销</a></li>
					</ul>
				</div>
			</div>
			<!-- 头部栏 - 结束 -->
			
			<!-- 核心区域 - 开始 -->
			<div class="frameMain">
				<div class="title" id="frameMainTitle">
					<span><i class="iconfont icon-xianshiqi"></i>后台首页</span>
				</div>
				<div class="con">
					<iframe id="mainIframe" src="tgls/qdAPI.html" scrolling="no"></iframe>
				</div>
			</div>
			<!-- 核心区域 - 结束 -->
		</div>
  </body>
</html>
