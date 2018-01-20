<%@page import="dataObjects.ProjectOb"%>
<%@page import="dataObjects.PrefetchCache"%>
<%@page import="dataObjects.ProfilesResult"%>
<%@page import="java.util.ArrayList"%>
<%@page import="core.Database"%>
<%@page import="core.ServletIO"%>

<!DOCTYPE html>
  <html>
    <head>
      <!--Import Google Icon Font-->
      <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
      <!--Import materialize.css-->
      <link type="text/css" rel="stylesheet" href="css/materialize.min.css"  media="screen,projection"/>
      <!--Let browser know website is optimized for mobile-->
      <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
      <style>
      .__body{
      }
      .__head{
        padding-top: 70px;
        width: 100%;
        height: 400px;
        margin-bottom: 0px;
        background: #1a237e url('./assets/react.jpeg')no-repeat center/cover;
        text-align: center;
      }
      .__team{

      }
      .developers{
        margin-top: 30px;
        width: 100%;
        height: 450px;
        background: url('./assets/upload.png')no-repeat center;
      }
      .projects{
          margin-top: 30px;
        width: 100%;
        height: 450px;
        background: url('./assets/codio.gif')no-repeat center;
      }
      .__ml{
          width: 100%;
          height: 200px;
      }
      .image_write{
                background: url('assets/writer.gif')no-repeat center/cover;
                height: 350px
            }
      </style>
       <script type="text/javascript" src="./js/jquery-3.2.1.min.js"/>
        <script type="text/javascript" src="./js/materialize.min.js"/>
    </head>
    <body style="background: #E0E0E0;">
      <div class="__body">
        <script type="text/javascript">
        $(document).ready(function(){
        $('.carousel').carousel();
        $('.carousel.carousel-slider').carousel({fullWidth: true});
        console.log('init finished')
        });
        </script>
        <div class="__head">
          <h4 class="flow-text" style="color: #fff;">Keep Coding!</h4>
          <h5 class="flow-text" style="color: #fff;">The world is depending on you!!</h5>
          <a type="button" class="waves-effect waves-teal btn" href="SignUp">Sign Up</a>
          <a type="button" class="waves-effect waves-teal btn" href="Login">Log In</a>
        </div>
        <div class="card" style="background-color:#fff; margin: 0 auto; width: 96%; padding: 35px 20px 20px 20px;">
          <div class="row">
            <div class="col s6 world" style="">
              <div style="width: 100%;height: 400px;"><img src="./assets/develop.svg" style="max-width: 100%;
                max-height: 100%;"/></div>
            </div>
            <div class="col s6" style="padding-top: 30px;">
              <h4 class="flow-text">Discover teams and Start working:</h4>
              <p>Real development begin when you find a better team having common goals,
              ProjectHub.com allows you to find one of the most trending teams you need and also helps you to contact
              people, so you can get started and work with them.</p>
              <a class="waves-effect waves-teal btn" style="margin-bottom: 20px;" href="SearchPage">Search teams</a>
              <h4 class="flow-text">Join today</h4>
              <p>If you are not the part of ProjectHub.com, Join the team today, You have wide variety
              of oppurtunities, post your projects, get feedback etc..</p>
              <a class="waves-effect waves-teal btn" href="SignUp" style="margin-bottom: 20px;">Sign Up</a>
            </div>
            <div>
          </div>
        </div>
        <div class="developers">
        </div>
        <div style=" text-align: center;">
          <h3 class="flow-text">Trending developers</h3>
          <p style="margin: 5px auto; width: 60%;">The results are purely based on the number of projects they
          are publishing on ProjectHub.com, Trending list may change from time to time</p>
          <div class="row" style="padding: 20px 20px 20px 20px;" id="dev">
            <%
                try {
                        Database db = new Database();
                        ArrayList<ProfilesResult> pr = db.getAllUsers();
                        ServletIO io = new ServletIO();
                        for(ProfilesResult p : pr){
                           String enc = io.baseX64_streamEncoder(p.Image);
                %>
                <div class="col s3" style="padding: 5px 5px 5px 5px">
                    <div class="card" style="padding: 5px 5px 5px 5px; text-align: center">
                        <img src="data: image/png;base64, <%=enc%>" width="200px" height="200px;">
                        <h5 class="flow-text"><%=p.Username%></h5>
                        <p><%=p.Projects%> projects</p>
                        <form action="interm" method="get">
                            <input type="text" name="EMAIL" value="<%=p.Email%>" hidden="true"/>
                            <button class="waves-effect waves-teal btn" type="submit" style="margin-bottom: 10px" >View proile</button>
                        </form>
                    </div>
                </div>
                <%
                    }
                    } catch (Exception e) {
                    }
                    %>
          </div>
        </div>
          <div style="padding-top: 20px; text-align: center;">
              <div class="projects" id="Projects"></div>
              <h4 class="flow-text">Projects</h4>
              <p style="margin: 5px auto; width: 60%;">Explore latest projects and don't forget to provide feedback</p>
              <div class="row" style="background : #1e88e5">
                  <div class="col s4" style="padding: 10px 10px 10px 10px;">
                  <div class="card" style="padding: 10px 10px 10px 10px; text-align: left">
                      <a class="flow-text" href="Category.jsp?Category=MachineLearning"><img src="assets/ml.png" width="30px" height="30px"/>Machine Learning</a>
                      <p>Explore the future of technology, get to know top Machine learning experts and developers</p>
                  </div>
                  </div>
                   <div class="col s4" style="padding: 10px 10px 10px 10px;">
                  <div class="card" style="padding: 10px 10px 10px 10px; text-align: left">
                      <a class="flow-text" href="Category.jsp?Category=Python"><img src="assets/py.png" width="30px" height="30px"/>Python</a>
                      <p>Python is one of the most trending programming languages for Data science and Machine learning.</p>
                  </div>
                  </div>
                   <div class="col s4" style="padding: 10px 10px 10px 10px;">
                  <div class="card" style="padding: 10px 10px 10px 10px; text-align: left">
                      <a class="flow-text" href="Category.jsp?Category=Java"><img src="assets/java.svg" width="30px" height="30px"/>Java</a>
                      <p>Explore the world's most trending platform for Enterprise application development.</p>
                  </div>
                  </div>
                  <div class="col s4" style="padding: 10px 10px 10px 10px;">
                  <div class="card" style="padding: 10px 10px 10px 10px; text-align: left">
                      <a class="flow-text" href="Category.jsp?Category=WebApp"><img src="assets/web.png" width="30px" height="30px"/>Web Apps</a>
                      <p>Web is one of the most trending application development platforms, Explore scalable appls built on web</p>
                  </div>
                  </div>
                  <div class="col s4" style="padding: 10px 10px 10px 10px;">
                  <div class="card" style="padding: 10px 10px 10px 10px; text-align: left">
                      <a class="flow-text" href="Category.jsp?Category=Android"><img src="assets/Android.jpg" width="30px" height="30px"/>Android</a>
                      <p>Android is one of the world's popular smart phone OS, Over 6 million apps are deployed for Android. Start exploring the apps</p>
                  </div>
                  </div>
                  <div class="col s4" style="padding: 10px 10px 10px 10px;">
                  <div class="card" style="padding: 10px 10px 10px 10px; text-align: left">
                      <a class="flow-text" href="Category.jsp?Category=Others"><img src="assets/others.png" width="30px" height="30px"/>Others</a>
                      <p>Explore the Operating Systems and Libraries and desktop applications built to speed up development, and increase productivity</p>
                  </div>
                  </div>
              </div>
              </div>
          <div class="row" style="margin-top: 30px">
              <div class="col s8" style="padding: 50px 20px 20px 20px">
                  <h4 class="flow-text">Trending on ProjectHub :</h4>
                  <p width="70%">Explore the most trending projects on ProjectHub, This will help you to get trending ideas and you can use
                  as an aspiration to develop new project, (And don't forget to upload them on Project Hub), Trending projects will be selected
                  based on the  number of likes, we display only top 2 projects from each category.</p>
              </div>
              <div class="col s4" style="text-align: right">
                  <img src="assets/trending.gif" width="400px" height="300px">
              </div>
          </div>
          <div class="row" style="padding: 20px 20px 20px 20px;">
              <%
                   for(ProjectOb obs : PrefetchCache.getCachedProject()){
                       String encoded_icon = new ServletIO().baseX64_streamEncoder(obs.Icon);
               %>
               <div class="col s2" style="padding:10px 10px 10px 10px">
                   <div class="card" style="padding: 10px 10px 10px 10px; text-align: center;">
                       <img src="data: image/png;base64, <%=encoded_icon%>" width="100px" height="100px">
                       <p>In <%=obs.Category%></p>
                       <h5 class="flow-text"><%= obs.Name%></h5>
                       <p>Team: <%=obs.TeamName%></p>
                       <p><%=obs.Likes%> likes</p>
                       <form action="View.jsp" method="get">
                                <input type="text" value="<%=obs.UID%>" hidden="true" name="UID"/>
                                 <input type="text" value="<%=obs.Name%>" hidden="true" name="name"/>
                                 <button type="submit" class="btn">View</button>
                            </form>
                   </div>
               </div>
                  <%
                      }
                   %>
          </div>
          <div style="padding: 30px 30px 30px 30px; margin: 30px auto; width: 95%; " class="card">
            <div class="row">
                <div class="col s5 image_write">
                </div>
                <div class="col s7" style="padding: 60px 30px 30px 30px">
                    <h5 class="flow-text">You can not only code! You can also write!!</h5>
                    <p>Are you a programming wizad? Well, It does not mean you don't know how to write!
                     We provide you an oppurtunity to write articles, it can be about tech, general knowledge, Universal basic Income, Science,
                     Machine learning concerns , your announcements etc.</p>
                    <p>If you have time, It's better to go through better articles on ProjectHub.com, It will help you to get knowledge 
                    about various technologies and products available.</p>
                    <a href="AllArticles.jsp" class="btn">View Articles</a>
                </div>
            </div>
          <div style="padding: 20px 20px 20px 20px; margin-top: 30px auto">
              <div class="row">
                  <div class="col s6">
                      <h3 class="flow-text">
                          Why we should learn programming?
                      </h3>
                      <p>When you learn computer programming, you start seeing problems in the light of solutions. Your brain starts functioning like that. When you encounter a problem after learning to program, you start envisioning the possible ways to solve it. You may even foresee some good results out of it. However hard the problem might seem, you become determined to act on it anyhow. You transform yourself into a solution-driven individual.
                      </p>
                  </div>
                  <div class="col s6">
                      <img src="assets/programming.jpeg" width="100%" height="300px">
                  </div>
              </div>
          </div>
      </div>
      <!--Import jQuery before materialize.js-->
    </body>
  </html>
