
<%@page import="dataObjects.*"
        import ="java.util.*"
        import="core.DatabaseProjects"
        import="core.*"%>
<html>
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Compiled and minified CSS -->
   <link rel="stylesheet" href="css/materialize.min.css">
   <!-- Compiled and minified JavaScript -->
   <script src="js/materialize.min.js"></script>
   <link rel="stylesheet" href="./assets/profile.css">
   <style>
   .proj_card{
     background-color:#6a1b9a;
     margin: 20px auto;
     width: 80%;
   }
   </style>
  </head>
  <body onunload="onUnload()" class="body_profile">
    <nav>
    	<div class="nav-wrapper div_head">
        <img class="responsive-img" src="./cache/favicon.png" width="40px" height="40px"/>
    		<a href="#!" class="brand-logo">ProjectHub2</a>
    		<ul class="right hide-on-med-and-down">
    			<li><a href="UploadProj"></i>Upload</a></li>
                        <li><a href="UserArticle.jsp"></i>My Articles</a></li>
    			<li><a href="Manage.jsp"></i>Manage</a></li>
          <li><a href="Main"></i>Log out</a></li>
    		</ul>
    	</div>
    </nav>
    <p class="flow-text">Welcome back ${u_name}</p>
    <div class="card profile_card">
      <div class="row">
        <div class="col s5 profile_pic">
            <%
                ServletIO io = new ServletIO();
                
                String encoding = io.baseX64_streamEncoder(UserObject.user_profile);
            %>
            <img class="responsive-img" src="data: image/png;base64, <%=encoding%>" width="200px" height="200px">
            <% %>
        </div>
        <div class="col s7 profile_data">
          <p>Name : ${u_name} </p>
          <hr>
          <p>Email : ${email} </p>
          <hr>
          <p>Phone : ${phone} </p>
          <hr>
          <p>Projects: ${projects} </p>
          <hr>
          <div>
              <% 
                  try { 
                  DatabaseFeedback dbs = new DatabaseFeedback(UserObject.user_id);
                  NotificationObject no_o = dbs.getNotificationWithUID(UserObject.user_id);
                  if(no_o.feedback){
                 %>
                 <a class="chip" href="Manage.jsp#feeds">
                     You have a new feedback click here to view.
                 </a>
              <%}} catch (Exception e) {
                  } %>
                  <% 
                  try { 
                  DatabaseFeedback dbs = new DatabaseFeedback(UserObject.user_id);
                  NotificationObject no_o = dbs.getNotificationWithUID(UserObject.user_id);
                  if(no_o.like){
                 %>
                 <a class="chip" href="Manage.jsp#projects">
                     You have a new like for  project <%=no_o.project%> click here to view.
                 </a>
              <%}} catch (Exception e) {
                  } %>
          </div>
          <div class="row">
            <div class="col s8">
              <p>Upload a new project and wait for the feedback from community, you can use gitHub as the repo for
              storing your source code</p>
              <a type="button" class="btn" href="UploadProj">Upload now</a>
              <p>Show your writing skills, write a new article today!</p>
              <a type="button" class="btn" href="./WriteArticle.jsp">Write</a>
            </div>
            <div class="col s4">
              <img src="./cache/media.png" width="100px" height="100px">
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="card profile_card card2">
      <div class="inner">
        <p class="flow-text">About ${u_name}</p>
        <hr>
        <p>${descr}</p>
      </div>
    </div>
    <div class="projects_head">
      <p class="flow-text">Your projects: </p>
      <div class="projects">
          <%
             try{
                  DatabaseProjects dbs = new DatabaseProjects(UserObject.user_id);
                  ArrayList<ProjectOb> ob = dbs.getAllProjects();
                  for(ProjectOb proj : ob){
                      String encodedx64_string = new ServletIO().baseX64_streamEncoder(proj.Icon);
                      %>
                      <div class="card proj_card" style="color: #fff;">
                        <div class="row">
                          <div class="col s4" style="padding-top:10px; padding-bottom: 10px;">
                            <img class="responsive-img" src="data: image/png;base64,<%= encodedx64_string %>" width="200px" height="200px"/>
                          </div>
                          <div class="col s8" style="padding:10px 10px 10px 10px; text-align:left;">
                            <h3 class="flow-text"><%=proj.Name%></h3>
                            <p><%=proj.Description%></p>
                            <p><%= proj.Likes%> people like this.</p>
                            <form action="View.jsp" method="get">
                                <input type="text" value="<%=proj.UID%>" hidden="true" name="UID"/>
                                 <input type="text" value="<%=proj.Name%>" hidden="true" name="name"/>
                                 <button type="submit" class="btn">View</button>
                            </form>
                          </div>
                        </div>
                      </div>
                  <%  }
             }catch(Exception e){
                 System.out.println("e");
             }
           %>
      </div>
    </div>
  </body>
</html>
