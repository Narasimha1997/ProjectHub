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
   width: 60%;
   margin: 0 auto;
   height: 350px;
   padding-top: 10px;
   color:  #3b5999;
   text-align: center;
 }
 .body{
   background: #37474F;
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
 <nav>
   <div class="nav-wrapper div_head">
     <img class="responsive-img" src="./cache/favicon.png" width="40px" height="40px"/>
     <a href="#!" class="brand-logo">ProjectHub2</a>
     <ul class="right hide-on-med-and-down">
       <li><a href="SignUp"><i class="mdi-action-search left"></i>Sign in</a></li>
       <li><a href="Login"><i class="mdi-action-view-module right"></i>Login</a></li>
       <li><a href="SearchPage"><i class="mdi-action-view-module right"></i>Search</a></li>
     </ul>
   </div>
 </nav>
 <body class="body">
   <p class="flow-text">If you have an Account, Sign in</p>
   <div class="card">
     <div class="form_internal">
       <form action=${url_post} method="POST">
         <div class="form-group">
           <label class="control-label" for="">Email</label>
           <span class="help-block"></span>
           <input type="text" class="form-control" id="" placeholder="" name="email" required>
         </div>
         <div class="form-group">
           <label class="control-label" for="">Password</label>
           <span class="help-block"></span>
           <input type="password" class="form-control" id="" placeholder="" name="password" required>
         </div>
        <button type="submit" class="btn">Sign in</button>
        <p>${message}</p>
       </form>
     </div>
   </div>

</body>
</html>
