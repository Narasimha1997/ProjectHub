package core;

import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author narasimha
 */
import java.util.*;
import dataObjects.*;
public class DatabaseArticles extends Database{

    public DatabaseArticles() throws Exception {
            super();
    }
    
    public void uploadArticle(int UID, String heading, InputStream image, String content)throws Exception{
        String query = "insert into Blogs (UID, Heading, Content, Image) values(?,?,?,?)";
        PreparedStatement st = connection.prepareStatement(query);
        st.setInt(1, UID);
        st.setString(2, heading);
        st.setString(3, content);
        st.setBlob( 4,image);
        st.execute();
        st.close();
    }
    
    public ArrayList<Article> getArticlesAll()throws  Exception{
        ArrayList<Article> articles = new ArrayList<>();
        String query = "select * from Blogs";
        Statement s = super.connection.createStatement();
        ResultSet rs = s.executeQuery(query);
        while(rs.next()){
            String Heading = rs.getString("Heading");
            String Content = rs.getString("Content");
            Blob image=rs.getBlob("Image");
            int BID = rs.getInt("BID");
            byte[] img=image.getBytes(1,(int)image.length());
            Article a = new Article();
            a.putArticleHead(rs.getInt("UID"), BID, 0, Heading, img);
            articles.add(a);
        }
        return articles;
    }
    
   public ArrayList<Article> getArticlesOfUser(int UID)throws Exception{
       ArrayList<Article> articles = new ArrayList<>();
        String query = "select * from Blogs  where UID="+UID;
        Statement s = super.connection.createStatement();
        ResultSet rs = s.executeQuery(query);
        while(rs.next()){
            String Heading = rs.getString("Heading");
            Blob image=rs.getBlob("Image");
            byte[] img=image.getBytes(1,(int)image.length());
            Article a = new Article();
            int BID = rs.getInt("BID");
            a.putArticleHead(rs.getInt("UID"), BID, 0, Heading, img);
            articles.add(a);
        }
        return articles;
   }
   
   public Article getSingleArticle(int UID, int BID)throws Exception{
       Article article = new Article();
       String query = "select * from Blogs where UID="+UID+" and BID="+BID;
       Statement s = super.connection.createStatement();
       ResultSet rs = s.executeQuery(query);
       if(rs.next()){
           String Heading = rs.getString("Heading");
            Blob image=rs.getBlob("Image");
            byte[] img=image.getBytes(1,(int)image.length());
            String content = rs.getString("Content");
            article.putOneArticle(rs.getInt("UID"),BID, 0, Heading,content, img);
       }
       return article;
   }
   
   public void upadteLike(int UID, int Likes, String heading)throws Exception{
        String get  = "update Blogs set Likes="+(Likes++)+" where UID="+UID+" and Heading='"+heading+"'";
        Statement s = connection.createStatement();
        s.executeUpdate(get);
    }
    
   public void deleteArticle(int UID,int BID)throws Exception{
       String delete = "delete from Blogs wherw UID="+UID+" and BID="+BID;
       Statement s = connection.createStatement();
       s.executeUpdate(delete);
   }
}
