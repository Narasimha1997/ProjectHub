<%-- 
    Document   : WrtieArticle
    Created on : 8 Nov, 2017, 6:27:35 PM
    Author     : narasimha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/materialize.min.css"/>
        <link rel="stylesheet" href="assets/index.css"/>
        <style>
            .image_write{
                background: url('assets/writer.gif')no-repeat center/cover;
                height: 400px
            }
        </style>
    </head>
    <body>
         <nav>
  	<div class="nav-wrapper div_head">
      <img class="responsive-img" src="./cache/favicon.png" width="40px" height="40px"/>
  		<a href="Main" class="brand-logo">ProjectHub2</a>
  		<ul class="right hide-on-med-and-down">
  			<li><a href="Manage.jsp"><i class="mdi-action-search left"></i>Manage</a></li>
  			<li><a href="UploadProj"><i class="mdi-action-view-module right"></i>Upload</a></li>
  		</ul>
  	</div>
  </nav>
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
        </div>
                <h5 class="flow-text" style="margin: 30px auto; text-align: center">Start writing!</h5>
                <div class="card" style="padding: 30px 30px 30px 30px; margin: 20px auto; width: 95%;" >
                    <form action="UploadArticle" method="post" enctype="multipart/form-data">
                        <p class="flow-text">Heading (Short and Sweet)</p>
                        <input type="text" name="Heading" placeholder="......" required/>
                        <p class="flow-text">Upload an image (Compulsory, no size limitations)</p>
                        <input type="file" name="Image" />
                        <p>Jott down the content: </p>
                        <textarea name="Content" required></textarea>
                        <button type="submit" class="btn">Publish!!</button>
                    </form>
                </div>
    </body>
</html>
