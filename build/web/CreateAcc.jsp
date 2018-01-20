<html>
<head>
  <meta name="viewport" content="width=device-width,initial-scale=1.0">
  <!-- Compiled and minified CSS -->
 <link rel="stylesheet" href="css/materialize.min.css">
 <!-- Compiled and minified JavaScript -->
 <script src="js/materialize.min.js"></script>
 <style>
 .div_head{
   background-color: #3b5999;
   text-align: left;
   padding-left: 20px;
   padding-bottom: 20px;
  color: #ffffff;
   padding-left: 50px;
 }
 .card{
   width: 80%;
   margin: 0 auto;
   height: 800px;
   padding-top: 10px;
   color:  #3b5999;
   text-align: center;
 }
 .body{
  background:  #37474F;
   text-align: center;
   padding-bottom: 70px;
   color: #ffffff;
 }
 .form_internal{
   padding-top: 40px;
   color: #3b5999;
   text-align: left;
   margin: 0 auto;
   width: 60%;
 }
 </style>
 </head>
 <body class="body">
   <nav>
   	<div class="nav-wrapper div_head">
       <img class="responsive-img" src="./cache/favicon.png" width="40px" height="40px"/>
   		<a href="#!" class="brand-logo">ProjectHub2</a>
   		<ul class="right hide-on-med-and-down">
   			<li><a href="SignUp"><i class="mdi-action-search left"></i>Sign in</a></li>
   			<li><a href="Login"><i class="mdi-action-view-module right"></i>Login</a></li>
         <li><a href=${url3}><i class="mdi-action-view-module right"></i>Search</a></li>
   		</ul>
   	</div>
   </nav>
   <p class="flow-text">Create an account for free</p>
   <div class="card">
     <p class="flow-text">Fill in with Appropriate details:</p>
     <div class="form_internal">
         <form action="SignUp" method="POST" enctype="multipart/form-data">
         <div class="form-group">
           <label class="control-label" for="">Name</label>
           <span class="help-block"></span>
           <input type="text" class="form-control" id="" placeholder="" name="name" required>
         </div>
         <div class="form-group">
           <label class="control-label" for="">Email</label>
           <span class="help-block"></span>
           <input type="text" class="form-control" id="" placeholder="" name="email" required>
         </div>
         <div class="form-group">
           <label class="control-label" for="">Phone Number (helps people to contact you)</label>
           <span class="help-block"></span>
           <input type="text" class="form-control" id="" placeholder="" name="phone" required>
         </div>
         <div class="form-group">
           <label class="control-label" for="">Password</label>
           <span class="help-block"></span>
           <input type="password" class="form-control" id="" placeholder="" name="password" required>
         </div>
         <div class="form-group">
           <label class="control-label" for="">Confirm Password</label>
           <span class="help-block"></span>
           <input type="password" class="form-control" id="" placeholder="" name="c_password" required>
         </div>
         <p>Tell yourself in brief: </p>
         <textarea name="descr" rows="30" cols="100"></textarea>
         <div class="form-group">
           <label class="control-label" for="">Uplaod Profile pic</label>
           <span class="help-block"></span>
           <input type="file" class="form-control" id="" placeholder="" name="profile" required>
         </div>
        <button type="submit" class="btn">Submit</button>
        <p>${message}</p>
       </form>
     </div>
   </div>

</body>
</html>
