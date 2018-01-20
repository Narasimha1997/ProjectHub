/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataObjects;

/**
 *
 * @author narasimha
 */
public class NotificationObject {
    public boolean feedback=false, like=false;
    public static int UID;
    public static String email;
    public static String project;
    
    public void putNotification(int feedback_, int like_, int UID_, String email_, String project_){
        UID = UID_;
        if(feedback_==1)
            feedback=true;
        else feedback=false;
        if(like_==1)
            like=true;
        else like=false;
        email=email_;
        project=project_;
    }
}
