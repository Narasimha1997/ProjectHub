/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import dataObjects.*;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author narasimha
 */
public class DatabaseSearch {
    static final String username="root";
   static final String password="Narasimha1997";
   
   static final String db_name="ProjectHub";
   Connection connection;
   Statement s;
   //Add tables here
   enum Tables{Users };

    public DatabaseSearch()throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/ProjectHub", username, password);
    }
    
    public void searchProfiles(String type, String content)throws Exception{
        s=connection.createStatement();
        if(type.equals("name")&&!content.equals("")){
            String q="SELECT UID, NAME, EMAIL, PHONE, PROJECTS, PROFILE_PIC, DESCRIPTION FROM Users WHERE NAME=\""+content+"\"";
            putContent(q, s);
        }
        else if(type.equals("email")&&!content.equals("")){
             String q="SELECT UID, NAME, EMAIL, PHONE, PROJECTS, PROFILE_PIC, DESCRIPTION FROM Users WHERE EMAIL=\""+content+"\"";
             putContent(q, s);
        }
        else if(type.equals("phone")&&!content.equals("")){
             String q="SELECT UID, NAME, EMAIL, PHONE, PROJECTS, PROFILE_PIC, DESCRIPTION FROM Users WHERE PHONE=\""+content+"\"";
             System.out.println(q);
             putContent(q, s);
        }
    }
    private void putContent(String query, Statement s)throws Exception{
        ResultSet rs=s.executeQuery(query);
        while(rs.next()){
             String em=rs.getString("EMAIL");
                String username=rs.getString("NAME");
                String phone=rs.getString("PHONE");
                int projects=rs.getInt("PROJECTS");
                int UID=rs.getInt("UID");
                Blob profile_binary=rs.getBlob("PROFILE_PIC");
                byte[] b=profile_binary.getBytes(1,(int)profile_binary.length());
                String desc = rs.getString("DESCRIPTION");
                ProfilesResult.putValues(0, UID, projects, username, phone, em, b, desc);
            return;
        }
       ProfilesResult.putValues(0, 0, 0, null, null, null, null, null);
    }
}
