/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;
import dataObjects.FeedbackOb;
import dataObjects.NotificationObject;
import java.sql.*;
import java.util.*;
/**
 *
 * @author narasimha
 */
public class DatabaseFeedback extends Database{
    public int UID;
    final String table = "Feedbacks";
    public DatabaseFeedback(int UID)throws Exception{
        super();
        this.UID = UID;
    }
    
    public void putFeedback(String project, String email, String Heading, String content)throws Exception{
        String function = "{call PUT_FEED(?,?,?,?,?)} ";
        CallableStatement cs = super.connection.prepareCall(function);
        cs.setInt(1, UID);
        cs.setString(2, project);
        cs.setString(3, content);
        cs.setString(4, email);
        cs.setString(5, Heading);
        cs.execute();
        updateNotificationsOnFeedback(UID, email);
    }
    
    public ArrayList<FeedbackOb> getAllFeedbacksWithUID()throws Exception{
        ArrayList<FeedbackOb> arrayObjects = new ArrayList<FeedbackOb>();
        String q = "select * from "+table+" where UID="+UID;
        Statement s = super.connection.createStatement();
        ResultSet rs = s.executeQuery(q);
        while(rs.next()){
            int UID_ = rs.getInt("UID");
            String Project = rs.getString("Project");
            String Description = rs.getString("Description");
            String Email = rs.getString("Email");
            String Heading = rs.getString("Heading");
            FeedbackOb ob = new FeedbackOb();
            ob.put(Email, Heading, Description, Project);
            arrayObjects.add(ob);
        }
        return arrayObjects;
    }
    
    public void updateNotificationsOnFeedback(int UID, String email)throws Exception{
        String query = "update Notifications set project='"+email+"' , Feedback=1  where UID="+UID;
        s = connection.createStatement();
        s.executeUpdate(query);
    }
    
    public void updateNotificationsOnLikes(int UID, String project)throws Exception{
        String query = "update Notifications set project='"+project+"' , Likes=1 where UID="+UID;
        s = connection.createStatement();
        s.executeUpdate(query);
    }
            
    public void removeNotifications(int UID)throws Exception{
        String qString = "update Notifications set project=NULL, Likes=0, email=NULL, Feedback=0 where UID="+UID;
        s = connection.createStatement();
        s.executeUpdate(qString);
    }
    
    public NotificationObject getNotificationWithUID(int UID)throws Exception{
        NotificationObject ob = new NotificationObject();
        String q = "select * from Notifications where UID="+UID;
        s = connection.createStatement();
        ResultSet rs = s.executeQuery(q);
        if(rs.next()){
            int Like = rs.getInt("Likes");
            int Feedback=rs.getInt("Feedback");
            String email = rs.getString("email");
            String Project = rs.getString("Project");
            ob.putNotification(Feedback, Like, UID, email, Project);
        }
        return ob;
    }
}
