<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" href="css/materialize.min.css">
    <link rel="stylesheet" href="assets/index.css">
    <link rel="stylesheet" href="assets/profile.css">
    <!-- Compiled and minified JavaScript -->
    <script src="../js/materialize.min.js"></script>
    <style>
    .card_upload{
      padding-top: 20px;
      text-align: center;
      margin: 20px auto;
      width: 80%;
      text-align: left;
      padding-left: 40px;
      padding-right: 40px;
      padding-bottom: 40px;
    }
    </style>
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
    <script>
    </script>
    <h3 class="flow-text" style="color: #fff;">Upload a new Project</h3>
    <div class="card card_upload">
      <script>
      function submit_data(){
        document.getElementById("message_").innerHTML = "About to submit";
        var form = document.getElementById('form_');
        if(form.projectName.value ==""||form.projectDesc.value==""||form.domain.value==""||
           form.gitLink.value=="" || form.teamName.value=="" || form.msg.value=="")
              document.getElementById('message_').innerHTML = "Fill up all the details"
        else {
          alert('Project submission successful');
          form.submit();
        }
      }
      </script>
      <form action="UploadProj" method="POST" enctype="multipart/form-data" id="form_">
        <div class="form-group">
          <label for="">Project Name: </label>
          <input type="text" class="form-control" id="" placeholder="" name="projectName" id="name" value="">
        </div>
        <div class="form-group">
          <label for="">Project Description: </label>
          <input type="text" class="form-control" id="" placeholder="" name="projectDesc" id="desc" value="">
        </div>
        <div class="form-group">
          <label for="">Project Domain: </label>
          <select class="browser-default" name="domain" id="sel">
            <option value="MachineLearning">MachineLearning</option>
            <option value="Python">Python</option>
            <option value="Java">Java</option>
            <option value="WebApp">WebApp</option>
            <option value="Android">Android</option>
            <option value="Others">Others</option>
          </select>
        </div>
        <div class="form-group">
          <label for="">GitHub link: </label>
          <input type="text" class="form-control" id="" placeholder="" name="gitLink" id="link" value="">
        </div>
        <div class="form-group">
          <label for="">Your team name: </label>
          <input type="text" class="form-control" id="" placeholder="" name="teamName" value="">
        </div>
        <div class="form-group">
          <label for="">Any other message?: </label>
          <input type="text" class="form-control" id="" placeholder="" name="msg" id="msg" value="">
        </div>
        <div class="form-group" style="margin-bottom: 20px">
          <label for="">Icon: </label>
          <input type="file" class="form-control" id="" placeholder="" name="icon" id="ico" value="">
        </div>
        <button type="button" class="btn" onClick="submit_data()">Submit</button>
      </form>
      <p id="message_"></p>
    </div>
  </body>
</html>
