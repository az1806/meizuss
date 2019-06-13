<%@ page language="java" import="java.util.*,com.jiaju.entity.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List<News> newslist=(List<News>) request.getAttribute("newslist");
%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<base href="<%=basePath%>">
    <title>meizus</title>
    ﻿<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="format-detection" content="telephone=no">
<meta name="renderer" content="webkit">
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="alternate icon" type="image/png" href="images/favicon.png">
<link rel='icon' href='favicon.ico' type='image/x-ico' />
<meta name="description" content="" />
<meta name="keywords" content="" />
<link rel="stylesheet" href="css/default.min.css?t=227" />
<!--[if (gte IE 9)|!(IE)]><!-->
<script type="text/javascript" src="lib/jquery/jquery.min.js"></script>
<!--<![endif]-->
<!--[if lte IE 8 ]>
<script src="http://libs.baidu.com/jquery/1.11.3/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="lib/amazeui/amazeui.ie8polyfill.min.js"></script>
<![endif]-->
<script type="text/javascript" src="lib/handlebars/handlebars.min.js"></script>
<script type="text/javascript" src="lib/iscroll/iscroll-probe.js"></script>
<script type="text/javascript" src="lib/amazeui/amazeui.min.js"></script>
<script type="text/javascript" src="lib/raty/jquery.raty.js"></script>
<script type="text/javascript" src="js/main.min.js?t=1"></script>

<script type="text/javascript" src="js/jquery.min.js"></script>

<style>

</style>


</head>
<body>
<jsp:include page="star.jsp"></jsp:include>
<jsp:include page="/header"></jsp:include>


<section class="index-section">
    <div>
        <span></span>
        <span></span>
    </div>
    <div class="index-content">
    
        <section class="index-content-section-first">
        <% Company com = (Company) request.getAttribute("company"); %>
        <div><img src=<%=com.getImgzong() %> alt=""></div> </section>
        <section class="index-content-section-second">
            <div>
                <div class="index-auto">
            <article>公司介绍</article>
            <h6>COMPANY INTRODUCTION</h6>
            <main><strong> 
					<%=com.getSyjs()%> 
			</strong></main>
            <a class="index-button" href="about">查看详情</a>
                </div>
            </div>
        </section>
    </div>
</section>


<section class="index-product">
<section class="index-product">
<main>
        <ul>
<% List<ProductClass> ptclass=(ArrayList<ProductClass>) request.getAttribute("pts")  ;
 
 for(int i=0;i<3;i++){

  %>
    
            <li class="index-active"><a href="index?typeid=<%=ptclass.get(i).getTypeid()  %>">  </a></li>
          
            
            <%} %>
            
        </ul>
    </main>
    
    
    <main></main>
    <main></main>
</section>
<div class="copyrights">Collect from <a href="http://www.cssmoban.com/" >网页模板</a></div>
<section class="index-margin-bottom">
    <div class="index-morecase">
        <span></span>
        <a href="productlist">MORE &#62; &#62;</a>
    </div>
    
    
   
   <div class="index-content">
     
     
   
  
     <div class="product-list">
    
  <% List<Product> plist=(ArrayList<Product>) request.getAttribute("plist") ;
  
  
  for(int i=0;i<6;i++){
  
  %>
              <div class="am-u-sm-6 am-u-md-6 am-u-lg-4">
                     <a href="productdetails?cpid=<%=plist.get(i).getCpid() %>">
              
                    <img src="<%=plist.get(i).getImg() %>" />
                </a>
            </div>
            
              <%} %>
            
        </div>
        
    </div>  
</section>
    <main></main>
    <main></main>
</section>



<section class="index-margin-bottom">
    <div class="index-morecase">
        <span></span>
        <a href="news_more">MORE &#62; &#62;</a>
    </div>
    <div class="index-content">


        <div class="new-index">
            <ul>
           
                <li><img  src="images/productlogo.png" alt=""> </li>
                
                <li>  <a href="article_list_content"><h3><%=newslist.get(3).getTitle() %></h3>
                    <article>
                    <%=newslist.get(3).getContent() %>
                       </article></a></li>
                        
                        
            </ul>
            
            <ul>
           <% for(int i=4;i<8;i++){ %>
             
                <li><a href="/jiaju/article_list_content?newsid=<%=newslist.get(i).getNewsid() %>"><h3><%=newslist.get(i).getTitle() %>   </h3>
                    <article>
                    <%=newslist.get(i).getContent() %>
                    </article>
                </a></li>
                
                <%} %>
                
            </ul>

        </div>
    </div>
</section>

<jsp:include page="/foot"></jsp:include>
</body>
</html>