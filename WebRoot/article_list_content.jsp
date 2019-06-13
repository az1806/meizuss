<%@ page language="java" import="java.util.*,com.jiaju.entity.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
News news=(News) request.getAttribute("news");
List<News> newslist=(List<News>) request.getAttribute("newslist");


%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<base href="<%=basePath%>">
    <title>某某家具设计公司企业官网-模板之家</title>
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
</head>
<body>
<jsp:include page="/header"></jsp:include>

<div>
    <header class="header-article-list">
        <div class="article-position">
        
        
    <%if(news.getNewsid()>1){ %>
    
       <a  href="article_list_content?newsid=<%=newslist.get(news.getNewsid()-2).getNewsid()%>">
              <span>上一篇</span>
              <span><%=newslist.get(news.getNewsid()-2).getTitle() %> </span>
          </a>
    
    
   <% } %>
   
    
           
        </div>
        
                   <ul >
                  <%    List<NewsType> nts = ( List<NewsType> ) request.getAttribute("newstype");
                
                   for (int i=0;i<nts.size();i++) {
                     %>
                    <li class="article-on"><a href="article_list?typeid=<%=nts.get(i).getTypeid() %>"><%=nts.get(i).getTypename() %></a></li>
                     <%
                   }
                   %>     
                   
                </ul>
           
        <div class="article-more-btn">        
              
                 <%if(news.getNewsid()<newslist.size()){ %>
                  <a href="article_list_content?newsid=<%=newslist.get(news.getNewsid()).getNewsid()%>">
                  <span>下一篇</span>
                <span><%=newslist.get(news.getNewsid()).getTitle() %></span>
                 </a>
                 
                 
                 
               <%   } %>
                
    
        </div>
    </header>

    <section class="article-content">
          
            <h4><%=news.getTitle()%></h4>
        <main>
           <p><%=news.getContent() %>    </p>
        </main>
    </section>
</div>
<jsp:include page="/foot"></jsp:include>
</body>
</html>