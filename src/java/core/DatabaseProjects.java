/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;
import java.sql.*;
import java.util.ArrayList;
import dataObjects.*;
/**
 *
 * @author narasimha
 */
public class DatabaseProjects  extends Database{
    ArrayList<ProjectOb> objects;
    private int UID;
    String[] query = {
        "select * from MachineLearning ",
        "select * from Python ",
        "select * from Java  ",
        "select * from WebApp ",
        "select * from Android ",
        "select * from Others "
    };
    public DatabaseProjects(int UID)throws Exception{
        super();
        this.UID = UID;
    }
    public DatabaseProjects()throws Exception{
        super();
    }
      
    public ArrayList<ProjectOb> getAllProjects()throws Exception{
        objects = new ArrayList<>();
        for(String q : query){
            String q_modified =q+"where UID="+UID;
            Statement statement = super.connection.createStatement();
            ResultSet rs = statement.executeQuery(q_modified);
            while(rs.next()){
                String Name = rs.getString("Name");
                String Description = rs.getString("Description");
                int Likes = rs.getInt("Likes");
                String team = rs.getString("TeamName");
                String cat = q.split(" ")[3];
                Blob icon_ = rs.getBlob("Icon");
                byte[] icon = icon_.getBytes(1, (int)icon_.length());
                ProjectOb object = new ProjectOb();
                object.putObjects(UID, Likes, Name, Description, icon, team, cat);
                objects.add(object);
            }
        }
        return  objects;
    }
    
    public ProjectOb getSingleProjectOb(int UID, String name)throws  Exception{
        for(String q : query){
            String q_m = q+"where UID="+UID+" and Name='"+name+"'";
            Statement statement = super.connection.createStatement();
            ResultSet rs = statement.executeQuery(q_m);
            if(rs.next()){
                String Name = rs.getString("Name");
                String Description = rs.getString("Description");
                int Likes = rs.getInt("Likes");
                Blob icon_ = rs.getBlob("Icon");
                byte[] icon = icon_.getBytes(1, (int)icon_.length());
                String link = rs.getString("Link");
                String teamName = rs.getString("TeamName");
                String msg= rs.getString("Message");
                ProjectOb object = new ProjectOb();
                String cat = q.split(" ")[3];
                String[] userData = getRequiredUserInfo(UID);
                object.putObject(UID, Likes, Name, Description, icon, link, teamName, msg, cat, userData[0], userData[1],userData[2]);
                return  object;
            }
        }
        return  null;
    }
    
    public ArrayList<ProjectOb> categoricalFetch(String domain)throws Exception{
        ArrayList<ProjectOb> list = new ArrayList<ProjectOb>();
        String q = "select * from "+domain;
        Statement s = super.connection.createStatement();
        ResultSet rs = s.executeQuery(q);
        while(rs.next()){
            int UID = rs.getInt("UID");
            String Name = rs.getString("Name");
                String Description = rs.getString("Description");
                int Likes = rs.getInt("Likes");
                Blob icon_ = rs.getBlob("Icon");
                String team = rs.getString("TeamName");
                byte[] icon = icon_.getBytes(1, (int)icon_.length());
                ProjectOb ob = new ProjectOb();
                ob.putObjects(UID, Likes, Name, Description, icon, team, domain);
                list.add(ob);
        }
        return list;
    }
    
    public String[] getRequiredUserInfo(int UID)throws Exception{
        String q = "select NAME, DESCRIPTION, EMAIL from Users where UID="+UID;
        String[] string = new String[4];
        Statement s1 = super.connection.createStatement();
        ResultSet rs = s1.executeQuery(q);
        if(rs.next()){
            string[0]=rs.getString("NAME");
            string[1]=rs.getString("DESCRIPTION");
            string[2]=rs.getString("EMAIL");
        }
        return string;
    }
    
    public ArrayList<ProjectOb> searchBy(String ATTRIBUTE, String domain){
        return null;
    }
    public ArrayList<ProjectOb> getAll()throws Exception{
       
        ArrayList<ProjectOb> projects_array = new ArrayList<>();
        Statement s = super.connection.createStatement();
         for(String q : query){
             q+=" order by Likes DESC";
             ResultSet rs = s.executeQuery(q);
            int ix=1;
             while(rs.next()){
            int UID = rs.getInt("UID");
            String Name = rs.getString("Name");
                String Description = rs.getString("Description");
                int Likes = rs.getInt("Likes");
                Blob icon_ = rs.getBlob("Icon");
                String team = rs.getString("TeamName");
                byte[] icon = icon_.getBytes(1, (int)icon_.length());
                ProjectOb ob = new ProjectOb();
                ob.putObjects(UID, Likes, Name, Description, icon, team, q.split(" ")[3]);
                projects_array.add(ob);
                if(ix>=2)
                 break;
               ix++;
         }
         } return projects_array;
    }
    
    public void deleteProject(int UID, String Name, String Category)throws Exception{
        String query1 = "delete from "+Category+" where UID="+UID+" and Name='"+Name+"'";
        String query2 = "update Users set PROJECTS="+(UserObject.proj-1)+" where UID="+UID;
        s = connection.createStatement();
        s.executeUpdate(query1);
        s.executeUpdate(query2);
    }
    public void updateLikes(int UID, String Name, String Category)throws Exception{
        String q = "select Likes from "+Category+" where UID="+UID+" and Name='"+Name+"'";
        s = super.connection.createStatement();
        ResultSet rs = s.executeQuery(q);
        if(rs.next()){
            int Likes = rs.getInt("Likes");
            Likes++;
            q = "update "+Category+" set Likes="+Likes+" where Name='"+Name+"'";
            s.executeUpdate(q);
        }
    }
    
    public int getUID(String Name, String Category)throws Exception{
        String query = "select UID from "+Category+" where Name='"+Name+"'";
        s = connection.createStatement();
        ResultSet rs = s.executeQuery(query);
        if(rs.next())
            return rs.getInt("UID");
        else return -1;
    }
}
