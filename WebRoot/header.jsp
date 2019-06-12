<%@ page language="java" import="java.util.*,com.jiaju.entity.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
			
			List<Banners> banlist=(ArrayList<Banners>) request.getAttribute("banlist");
			     
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'header.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<!-- 重写汉字 -->
<script src="js/hanzi-writer.min.js"></script>
<script src="js/polyfill.min.js"></script>

<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script></head>
<script type="text/javascript">
function find(){
alert("哈哈");
}
</script>
<style type="text/css">

#finds{
position: absolute;
left:1200px;

}


</style>
  <body><% Company com = (Company) request.getAttribute("company"); %>
   <header> 
    <div class="header-top">
        <div class="width-center">
            <div class="header-logo "><img src="<%=com.getLogo() %>" alt=""></div>
            <div class="header-title div-inline" style="color: white;">
                <strong>
					<%=com.getCompanyname()%> </strong>
                <span> 
					<%=com.getWww()%> 
					
					</span>
					    <div id="character-target-div"></div>
            </div>

            <div class="search-box div-inline">
              <!--    <div class="input-box"><input type="text" name="" placeholder="请输入关键字"></div>
                <div class="search-botton" onclick="find()"></div> -->
                
             
            </div>
               <div id="finds"><input type="text" ><input type="button" value="搜索" id="find">   </div>
        </div>
    </div>
    <div class="header-nav">
        <button class="am-show-sm-only am-collapsed font f-btn" data-am-collapse="{target: '.header-nav'}">Menu <i
                class="am-icon-bars"></i></button>
        <nav>
        <ul class="header-nav-ul am-collapse am-in">
            <li class="on"><a href="index" name="index">首页</a></li>
            <li><a href="about" name="about">关于我们</a></li>
            <li><a href="productlist" name="show">产品展示</a></li>
            <li><a href="article_list" name="new">新闻资讯</a></li>
            <li><a href="contact" name="message">联系我们</a>
                <div class="secondary-menu">

                    <ul><li><a href="message.jsp" class="message"></a></li></ul>
                </div>
            </li>
        </ul>




        </nav>
        
        
    </div>
<div class="am-slider am-slider-default" data-am-flexslider="{playAfterPaused: 8000}">
 
    <ul class="am-slides">
  
   <%for(int i=0;i<banlist.size();i++){ %>
     
        <li><img src=<%=banlist.get(i).getBanner() %> alt="" ></li>
   
        <%} %>
        
    </ul>
    
</div>
</header>
<script>
  


	var char = '谢谢你长的这么好看还来看我们的官网',writer = [];
	
	for (var x = 0; x < char.length; x++) {
		writer.push(writeChar(char[x]))
	}
	function writeChar(char) {
		return HanziWriter.create('character-target-div', char, {
			width: 50,
			height: 50,
			padding: 3,
			showOutline: true
		});
	}
	document.getElementById('character-target-div').addEventListener('click', function () {
		if(writer.length > 0){
			writer.map(function(w){
				w.animateCharacter()
			})
		}
	});
</script>
  </body>

</html>
