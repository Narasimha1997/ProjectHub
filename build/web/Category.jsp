<%-- 
    Document   : Category
    Created on : 31 Oct, 2017, 2:01:12 PM
    Author     : narasimha
--%>

<%@page import="core.ServletIO"%>
<%@page import="dataObjects.ProjectOb"%>
<%@page import="java.util.ArrayList"%>
<%@page import="core.DatabaseProjects"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      <!--Import materialize.css-->
      <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
      <!--Let browser know website is optimized for mobile-->
      <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
      <style>
          .back{
              background: url('assets/trending.png') no-repeat center/cover;
              padding-top: 60px;
              color: #fff;
          }
      </style>
    </head>
    <body style="text-align: center;background: #303030">
        <div style="width:100%; height: 500px; " class="back">
            <h4 class="flow-text">Explore trending on GitHub</h4>
            <p>GitHub is a open source online repository and hosts around 7 million open source projects. Explore today</p>
            <a class=" waves-effect  btn" href="https://github.com/trending">Explore</a>
        </div>
        <div class="card" style="width: 96%; padding: 20px 20px 20px 20px; margin: 0 auto; background: #303030">
            <%
               String category = request.getParameter("Category");
               try{
                   DatabaseProjects dbs = new DatabaseProjects();
                   ArrayList<ProjectOb> objects = dbs.categoricalFetch(category);
                   for(ProjectOb ob : objects){
                       String encoded_img = new ServletIO().baseX64_streamEncoder(ob.Icon);
            %>
            <div class="card" >
                <div class="row" style="padding: 20px 20px 20px 20px">
                    <div class="col s4">
                        <img src="data: image/png;base64, <%=encoded_img%>" width="200px%" height="200px">
                    </div>
                    <div class="col s8" style="padding: 20px 20px 20px 20px">
                        <h4 class="flow-text"><%=ob.Name%></h4>
                        <p><%=ob.Description%></p>
                        <p>Likes : <%=ob.Likes%></p>
                        <form action="View.jsp" method="get">
                            <input type="text" hidden="true"  name="UID" value="<%=ob.UID%>"/>
                            <input type="text" hidden="true"  name="name" value="<%=ob.Name%>"/>
                            <button type="submit" class="btn-flat">View</button>
                        </form>
                    </div>
                </div>
            </div>
               <%
                   }
                   }catch(Exception e){
                      System.out.println("Error");
                  }
               %>
        </div>
    </body>
</html>
