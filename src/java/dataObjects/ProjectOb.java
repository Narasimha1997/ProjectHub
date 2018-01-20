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
public class ProjectOb {
    public int UID, Likes;
    public String Name, Description;
    public byte[] Icon;
    public String Category;
    public String Link, Message, TeamName;
    public String UserName, DESC, Email;
    
    public void putObjects(int uid, int likes, String name, String description, byte [] icon, String teamName, String domain){
        UID = uid; Likes = likes; Name = name; Description = description; TeamName = teamName; Category = domain;
        Icon = icon;
    }
    
    public void putObject(int uid, int likes, String name, String description, byte [] icon, String link, String teamName, String msg, String category,
     String user, String desc, String email){
        UID = uid; Likes = likes; Name = name; Description = description; 
        Icon = icon; Link=link; Message=msg; TeamName = teamName;
        Category = category; UserName = user; DESC = desc; Email =email;
    }
    

}
