<html>
  <head>
    <meta name="viewport" content="width=devide-width,initial-scale=1.0">
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
    .search_body{
      background: #37474F;

      color: #ffffff;
      text-align: center;
      margin: 10px;
    }
    .card{
      width: 80%;
      height: 300px;
      margin: 10px auto;
      padding-top: 10px;
      padding-left: 20px;
      padding-right: 20px;
      padding-bottom: 10px;
      color: #000000;
      text-align: left;
    }
    </style>
  </head>
  <body class="search_body">
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
    <h1 class="flow-text">ProjectHub.com Search Engine</h1>
    <p>You can search User profiles, Projects by category etc</p>
    <div class="card">
      <h3 class="flow-text">Search Profiles</h3>
      <p>Seach by user profiles, You can search profiles based on Username, Phone-Number or Email.</p>
      <div class="row">
        <form action="${url_search_profile}" method="post">
          <div class="col s4 m4 l4">
            <div class="form-group">
              <label for="">Search By</label>
              <select class="browser-default" name="typesel">
                <option value="name">User Name</option>
                <option value="email">Email</option>
                <option value="phone">Phone</option>
              </select>
            </div>
          </div>
          <div class="col s8 m8 l8">
            <div class="form-group">
              <label for="">Search Text</label>
              <input type="text" class="form-control" id="" placeholder="" name="search_txt">
            </div>
          </div>
          <button type="submit" name="button" class="btn">Search</button>
        </form>
    </div>
    </div>
          <div class="card" style="margin-top: 30px; padding: 20px 20px 20px 20px;">
              <h4 class="flow-text">Search projects</h4>
              <p>Search projects based on their category and name</p>
              <form action="interm" method="post">
                  <div class="row">
                      <div class="col s6">
                          <p>Project Category: </p>
                          <select class="browser-default" name="Category">
                              <option value="MachineLearning">Machine Learning</option>
                                <option value="Python">Python</option>
                                  <option value="Java">Java</option>
                                    <option value="Android">Android</option>
                                      <option value="WebApp">Web Application</option>
                                        <option value="Others">Others</option>
                          </select>
                      </div>
                      <div class="col s6">
                          <p>Project Name</p>
                          <input type="text" name="Name"/>
                      </div>
                  </div>
                  <button type="submit" class="btn">Search</button>
              </form>
          </div>
  </body>
</html>
