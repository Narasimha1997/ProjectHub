<%-- 
    Document   : ViewArticle
    Created on : 8 Nov, 2017, 9:19:53 PM
    Author     : narasimha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="core.*" %>
<%@page import="java.util.*" %>
<%@page import="dataObjects.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Article</title>
        <link rel="stylesheet" href="css/materialize.min.css"/>
        <link rel="stylesheet" href="assets/index.css" />
    </head>
    <body>
        <nav>
      <div class="nav-wrapper" style="background: #3b5999; text-align: left">
        <img class="responsive-img" src="cache/favicon.png" width="40px" height="40px"/>
        <a href="#!" class="brand-logo">ProjectHub2</a>
        <ul class="right hide-on-med-and-down">
          <li><a href="SignUp"><i class="mdi-action-search left"></i>Sign in</a></li>
          <li><a href="Login"><i class="mdi-action-view-module right"></i>Login</a></li>
          <li><a href="./search_engine/SearchPage"><i class="mdi-action-view-module right"></i>Search</a></li>
        </ul>
      </div>
    </nav>
        <div class="card" style="margin: 30px auto; width: 90%; padding: 30px 30px 30px 30px">
            <%
                try{
                    DatabaseArticles dbar  = new DatabaseArticles();
                    int UID = Integer.parseInt(request.getParameter("UID"));
                    int BID = Integer.parseInt(request.getParameter("BID"));
                    Article ar = dbar.getSingleArticle(UID, BID);
                    String base_64_image = new ServletIO().baseX64_streamEncoder(ar.Image);
               %>
               <h5 class="flow-text"><%=ar.Heading%></h5>
               <div style="margin: 20px auto; width: 100%;">
                   <img src="data: image/png;base64, <%= base_64_image%>" width="100%" height="100%"/>
                   <p><%=ar.Content%></p>
               </div>
            <%}catch(Exception e){
                 e.printStackTrace();
           }%>
        </div>
    </body>
</html>
