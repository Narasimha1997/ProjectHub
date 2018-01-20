<%-- 
    Document   : Manage
    Created on : 15 Oct, 2017, 1:43:01 PM
    Author     : narasimha
--%>

<%@page import="dataObjects.FeedbackOb"%>
<%@page import="core.DatabaseFeedback"%>
<%@page import="dataObjects.ProjectOb"%>
<%@page import="dataObjects.UserObject"%>
<%@page import="core.DatabaseProjects"
        import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title></title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Compiled and minified CSS -->
   <link rel="stylesheet" href="css/materialize.min.css">
   <!-- Compiled and minified JavaScript -->
   <script src="js/materialize.min.js"></script>
   <link rel="stylesheet" href="./assets/index.css">
    </head>
    <body style="text-align: center;">
        <nav>
    	<div class="nav-wrapper div_head">
        <img class="responsive-img" src="./cache/favicon.png" width="40px" height="40px"/>
    		<a href="#!" class="brand-logo">ProjectHub2</a>
    	</div>
    </nav>
        <h4 class="flow-text">Manage your Projects and Profile</h4>
        <div class="card " style="margin: 20px auto; width: 80%; padding: 10px 10px 10px 10px; text-align: left" id="projects">
            <h4 class="flow-text">Your projects</h4>
        <% 
           try{
               DatabaseProjects dbs = new DatabaseProjects(UserObject.user_id);
               ArrayList<ProjectOb> obs = dbs.getAllProjects();
               new DatabaseFeedback(UserObject.user_id).removeNotifications(UserObject.user_id);
        %>
        <table class="striped">
            <thead>
                <tr><th>Project Name: </th><th>Team Name</th><th>Domain</th><th></th></tr>
            </thead>
            <tbody>
                <% for(ProjectOb ob: obs){ 
                 %>
                 <tr>
                     <th><%=ob.Name%></th><th><%=ob.TeamName%></th><th><%=ob.Category%></th>
                     <th>
                         <form action="DeleteEvent" method="get">
                             <input type="text" value="Project" hidden="true" name="mode"/>
                             <input type="text" value="<%=ob.Name %>" hidden="true" name="Name"/>
                             <input type="text" value="<%=ob.UID %>" hidden="true" name="UID"/>
                             <input type="text" value="<%=ob.Category %>" hidden="true" name="Category"/>
                             <button type="submit" class="btn-flat">Delete</button>
                         </form>
                     </th>
                 </tr>
                <% } %>
            </tbody>
        </table>
        <%}catch(Exception e){

          }
        %>
        </div>
        <div class="card" style="margin: 20px auto; width: 80%; padding: 10px 10px 10px 10px; text-align: left" id="feeds">
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
                <%
                    try{
                        DatabaseFeedback dbf = new DatabaseFeedback(UserObject.user_id);
                        ArrayList<FeedbackOb> obs = dbf.getAllFeedbacksWithUID();
                        for(FeedbackOb obf: obs){
                    %>
                    <div style="border-bottom: thin solid">
                        <div class="row">
                            <div class="col s7">
                                <p>About: <%=obf.Project%></p>
                            </div>
                             <div class="col s5">
                                <p>From: <%=obf.Email%></p>
                            </div>
                        </div>
                                <h4 class="flow-text"><%=obf.Heading%></h4>
                                <p><%=obf.Description%></p>
                    </div>
                <%}
                   }catch(Exception e){
                        System.out.println(e);
                    } 
                %>
            </div>
        </div>
        <div class="card"style="margin: 20px auto; width: 80%; padding: 10px 10px 10px 10px; text-align: left">
            <h3 class="flow-text">Not interested to be a part of ProjectHub Community?</h3>
            <form action="DeleteEvent" method="get">
                <p>Confirm your password before deleting: </p>
                <input type="text" name="mode" value="User" hidden="true">
                <input type="password" name="password">
                <button type="submit" class="btn-flat">Delete</button>
            </form>
        </div>
    </body>
</html>
