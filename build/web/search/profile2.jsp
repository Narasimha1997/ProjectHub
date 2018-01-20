<%@page import="java.util.*"
        import="dataObjects.*"
        import="core.*" %>
<html>

  <head>
      <%response.setHeader("Cache-Control", "no-store");
                   response.setHeader("Pragma", "no-cache");
                   response.setHeader("Expires", "0");%>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Compiled and minified CSS -->
   <link rel="stylesheet" href="css/materialize.min.css">
   <!-- Compiled and minified JavaScript -->
   <script src="js/materialize.min.js"></script>
   <link rel="stylesheet" href="./assets/profile.css">
   <script type="text/javascript">
      var x = function() { return alert("All your data will be lost, please log out");}
      function onUnload(){
        window.onbeforeunload=x();
      }
   </script>
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
    			<li><a href='SignUp'></i>Sign up</a></li>
    			<li><a href='Login'></i>Login</a></li>
          <li><a href='./search_engine/SearchPage'></i>Search</a></li>
    		</ul>
    	</div>
    </nav>
    <p class="flow-text">${u_name} 's Profile</p>
    <div class="card profile_card">
      <div class="row">
        <div class="col s5 profile_pic">
          <img class="responsive-img" src=${image}  width="200px" height="200px">
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
      <p class="flow-text">His projects: </p>
      <div class="projects">
          <%
             try{
                  DatabaseProjects dbs = new DatabaseProjects(ProfilesResult.UID);
                  ArrayList<ProjectOb> ob = dbs.getAllProjects();
                  for(ProjectOb proj : ob){
                      byte[] encodedX64 = Base64.getEncoder().encode(proj.Icon);
                      String encodedx64_string = new String(encodedX64, "UTF-8");
                      %>
                      <div class="card proj_card" style="color: #fff;">
                        <div class="row">
                          <div class="col s4">
                            <img class="responsive-img" src="data: image/png;base64,<%= encodedx64_string %>" width="200px" height="200px"/>
                          </div>
                          <div class="col s8" style="padding:10px 10px 10px 10px; text-align:left;">
                            <h3 class="flow-text"><%=proj.Name%></h3>
                            <p><%=proj.Description%></p>
                            <p><%= proj.Likes%> people like this.</p>
                            <form action="View.jsp" method="get">
                                <input type="text" value="<%=proj.UID%>" hidden="true" name="UID"/>
                                 <input type="text" value="<%=proj.Name%>" hidden="true" name="name"/>
                                 <input type="submit" class="btn"  value="View"/>
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
