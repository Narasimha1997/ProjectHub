/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;
import dataObjects.ProfilesResult;
import dataObjects.UserObject;
import java.util.*;
import java.io.InputStream;
import java.sql.*;
import org.jboss.weld.bean.proxy.ProxyMethodHandler;
/**
 *
 * @author narasimha
 */
public class Database {
   static final String username="root";
   static final String password="Narasimha1997";
   
   static final String db_name="ProjectHub";
   Connection connection;
   Statement s;
   //Add tables here
   enum Tables{Users , Feedbacks, Project_type};
   enum DomainKeys{MachineLearning, Python, Java, WebApp, Android, Others};
   
    public Database()throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/ProjectHub", username, password);
    }
   
    public void AddUser(String name,String email,String password, String phone, String fname, InputStream fs , String desc)throws Exception{
        s=connection.createStatement();
        String query="SELECT UID FROM "+Tables.Users;
        ResultSet rs=s.executeQuery(query);
        int c=0;
        while(rs.next())
            c=rs.getInt("UID");
        c++;
        query="INSERT INTO Users VALUES(?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps=connection.prepareStatement(query);
        ps.setInt(1, c);
        ps.setString(2, name);
        ps.setString(3, email);
        ps.setString(4, password);
        ps.setString(5, phone);
        ps.setInt(6, 0);
        ps.setString(8, fname);
        ps.setBlob(7,fs);
        ps.setString(9, desc);
        ps.execute();
        s.close();
        rs.close();
        connection.close();
    }
    
    public boolean auth(String email,String password)throws Exception{
        s=connection.createStatement();
        String query="SELECT * from Users";
        ResultSet rs=s.executeQuery(query);
        while(rs.next()){
            if(rs.getString("EMAIL").equals(email)&&rs.getString("PASSWORD").equals(password)){
                String em=rs.getString("EMAIL");
                String username=rs.getString("NAME");
                String pwd=rs.getString("PASSWORD");
                String phone=rs.getString("PHONE");
                int projects=rs.getInt("PROJECTS");
                String f_name=rs.getString("PIC_NAME");
                int UID=rs.getInt("UID");
                String descr = rs.getString("DESCRIPTION");
                Blob profile_binary=rs.getBlob("PROFILE_PIC");
                byte[] b=profile_binary.getBytes(1,(int)profile_binary.length());
                UserObject.setUserData(UID,username,em,pwd,projects,f_name,phone,b,descr);
                return true;
            }
        }
        return false;
    }

    public Database(Connection connection, Statement s) {
        this.connection = connection;
        this.s = s;
    }
    
    public String getDomainName(int id){
        try{
            s = connection.createStatement();
          String query = "select * from "+Tables.Project_type+" where domain_id="+id;
          ResultSet rs = s.executeQuery(query);
          if(rs.next()){
                System.out.println(rs.getString("domain_name")+"\n");
              return  rs.getString("domain_name");
          }
          else return  "";
        }catch(Exception e){
            return  "";
        }
    }
    public boolean uploadProject(int UID, String name, String desc, String domain_raw,String link, String tn,
            String message, InputStream icon){
        try{
            System.out.println(getDomainName(getDomain(domain_raw))+" UserID="+UserObject.user_id);
            s = connection.createStatement();
            String upload_SQL  = "insert into "+getDomainName(getDomain(domain_raw))+" values(?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(upload_SQL);
            ps.setInt(1, UID);
            ps.setString(2, name);
            ps.setString(3, desc);
            ps.setString(4, link);
            ps.setString(5, tn);
            ps.setString(6, message);
            ps.setBlob(7, icon);
            ps.setInt(8, 0);
            ps.execute(); ps.close(); s.close();
            System.out.println("Executed successful");
            //Update Projects:
            updateProjectCount();
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    private int getDomain(String raw_name){
        int ordinal_ = DomainKeys.valueOf(raw_name).ordinal()+1;
        System.out.println(ordinal_);
        return  ordinal_;
    }
    
    private void updateProjectCount()throws  Exception{
        int new_count = UserObject.proj+1;
        s = connection.createStatement();
        String query = "update Users set PROJECTS="+new_count+" where UID="+UserObject.user_id;
        s.execute(query);
        UserObject.proj = new_count;
        s.close();
    }
    public ArrayList<ProfilesResult> getAllUsers()throws Exception{
        String q = "select * from Users order by PROJECTS DESC";
        ArrayList<ProfilesResult> arr = new ArrayList<>();
        s = connection.createStatement();
        ResultSet rs = s.executeQuery(q);
        int ix=1;
        while(rs.next()&&ix<=6){
            String em=rs.getString("EMAIL");
                String username=rs.getString("NAME");
                String pwd=rs.getString("PASSWORD");
                String phone=rs.getString("PHONE");
                int projects=rs.getInt("PROJECTS");
                String f_name=rs.getString("PIC_NAME");
                int UID=rs.getInt("UID");
                String descr = rs.getString("DESCRIPTION");
                Blob profile_binary=rs.getBlob("PROFILE_PIC");
                byte[] b=profile_binary.getBytes(1,(int)profile_binary.length());
                ProfilesResult pr = new ProfilesResult();
                pr.putValues_nonStatic(1, UID, projects, username, phone, em, b, descr);
                arr.add(pr);
                ix++;
        }
        return arr;
    }
    
    public void deleteUser(int UID)throws Exception{
        String query = "delete from Users where UID="+UID;
        s = connection.createStatement();
        s.executeUpdate(query);
    }
}
