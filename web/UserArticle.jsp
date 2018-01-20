<%-- 
    Document   : UserArticle
    Created on : 8 Nov, 2017, 8:50:11 PM
    Author     : narasimha
--%>

<%@page import="dataObjects.UserObject"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dataObjects.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="core.*" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/materialize.min.css" />
        <link rel="stylesheet" href="assets/index.css"/>
        <title>Articles</title>
    </head>
    <body>
        <nav>
    	<div class="nav-wrapper div_head">
        <img class="responsive-img" src="./cache/favicon.png" width="40px" height="40px"/>
    		<a href="#!" class="brand-logo">ProjectHub2</a>
    		<ul class="right hide-on-med-and-down">
    			<li><a href="UploadProj"></i>Upload</a></li>
                        <li><a href="MyArticlecs.jsp"></i>My Articles</a></li>
    			<li><a href="Manage.jsp"></i>Manage</a></li>
          <li><a href="Main"></i>Log out</a></li>
    		</ul>
    	</div>
    </nav>
            
        <%try{ 
              DatabaseArticles dbs = new DatabaseArticles();
              ArrayList<Article> aa = dbs.getArticlesOfUser(UserObject.user_id);
              for(Article a : aa){
                  ServletIO io = new ServletIO();
                  String image = io.baseX64_streamEncoder(a.Image);
        %>
        <div  style="padding: 20px 20px 20px 20px; width: 80%;  margin: 0 auto;" >
            <div class="card" style="margin: 30px auto;">
                <div class="card-image">
                    <img src="data: image/png;base64, <%=image%>"/>
                </div>
                <div class="card-content">
                    <h5 class="flow-text"><%= a.Heading %></h5>
                    <p><%=a.Likes%> Likes</p>
                    <form action="ViewArticle.jsp" method="get">
                        <input type="text" hidden="true" value="<%=a.UID%>" name="UID"/>
                        <input type="text" hidden="true" value="<%=a.BID%>" name="BID"/>
                        <button type="submit" class="btn">View</button>
                    </form>
                        <form action="DeleteArticle" method="get">
                        <input type="text" hidden="true" value="<%=a.UID%>" name="UID"/>
                        <input type="text" hidden="true" value="<%=a.BID%>" name="BID"/>
                    </form>
                </div>
            </div>
        </div>
        <%}
         }catch(Exception e){e.printStackTrace();}
         %>
    </body>
</html>
