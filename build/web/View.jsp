<%@page import="dataObjects.UserObject"%>
<%@page import="java.util.Base64"%>
<%@page import="dataObjects.ProjectOb"%>
<%@page import="java.util.ArrayList"%>
<%@page import="core.*"%>
<html>
  <head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="css/materialize.min.css">
    <link rel="stylesheet" href="assets/index.css">
    <link rel="stylesheet" href="assets/profile.css">
    <!-- Compiled and minified JavaScript -->
    <script src="js/materialize.min.js"></script>
    <title>Project</title>
  </head>
  <body style="background: #37474F; text-align: center">
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
    <%
            String proj_name = request.getParameter("name");
            int UID = Integer.parseInt(request.getParameter("UID"));
           try{
               DatabaseProjects dbp = new DatabaseProjects(UID);
               ProjectOb ob = dbp.getSingleProjectOb(UID, proj_name);
               String x64_encoded_image = new ServletIO().baseX64_streamEncoder(ob.Icon);
               DatabaseSearch dbs = new DatabaseSearch();
               dbs.searchProfiles("email", ob.Email);
        %>
    <div class="card" style="width: 80%; margin: 20px auto; padding: 30px 30px 30px">
      <div class="row" class="background: #37474F; color: #fff">
        <div class="col s5">
          <img class="responsive-img" src="data: image/png;base64,<%=x64_encoded_image %>"  width="300px" height="300px"/>
        </div>
        <div class="col s7" style="padding: 10px 10px 10px 10px">
          <h3 class="flow-text"><%= ob.Name%></h3>
          <p> By: <%=ob.UserName %></p>
          <p>Email: <%=ob.Email %></p>
          <p>About <%=ob.UserName%>: <%=ob.DESC%></p>
          <% if(UserObject.user_id!=ob.UID){ %>
          <form action ="Profile3View" method="get">
              <button type="submit" class="btn">View Profile</button>
          </form>
          <%}%>
        </div>
      </div>
          <div style="padding: 20px 20px 20px 0px; text-align: left; border-top: thick solid">
              <h3 class="flow-text">Description: </h3>
              <p><%=ob.Description %></p>
              <a class="btn" href="<%=ob.Link %>">View Source</a>
              <div class="row">
                  <% if(UserObject.user_id!=ob.UID){%>
                   <div class="col s6">
                      <form action="Likes" method="post">
                          <input type="text" hidden="true" name="UID" value="<%=ob.UID%>"/>
                          <input type="text" hidden="true" name="Category" value="<%=ob.Category%>"/>
                          <input type="text" hidden="true" name="Name" value="<%=ob.Name%>"/>
                          <button type="submit" class="btn-flat" onSubmit="submit_like()">Like</button>
                      </form>
                  </div>
                   <%}else{ %>
                   <p>Users will be prompted to like your project</p>
                   <% }%>
                  </div>
              </div>
          </div>
            <div class="card" style="margin: 20px auto; width: 80%; padding: 10px 10px 10px 10px; text-align: left">
            <div class="row">
                <div class="col s4">
                    <img src="./assets/feedback.svg" width="259" height="326px"/>
                </div>
                <div class="col s8" style="padding-top: 40px;">
                    <h2 class="flow-text">Feedbacks help you to develop better products</h2>
                    <p>ProjectHub allows developers and community to understand your project and provide a better feedback
                    about what you are doing, This helps you and your team to develop better products, Feedbacks can be anything,
                     Developers can just provide feedback about what they feel or it can be a suggestion about the best practices or a request to join your team.
                    </p>
                </div>
            </div>
            <div style="margin: 20px auto; width: 90%">
                <form action="Feedbacks" method="post">
                    <p>Your Email:</p>
                    <input type="text" name="Email"/>
                    <p>Add a heading</p>
                    <input type="text" name="Heading"/>
                    <p>Write a vaild feedback: </p>
                    <textarea name="FeedbackBody"></textarea>
                    <input type="text" hidden="true" name="Project" value="<%=ob.Name%>"/>
                    <input type="text" hidden="true" name="UID" value="<%=ob.UID%>"/>
                    <button text="submit" style="margin-top:20px" class="btn">Submit</button>
                </form>
            </div>
        </div>
        <% }catch(Exception e){
               System.out.println("Error..");
           }
        %>
  </body>
</html>
