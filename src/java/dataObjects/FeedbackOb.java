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
public class FeedbackOb {
    public int UID;
    public String Heading, Description, Email, Project;
    
    public void put(String email, String heading, String descString, String project){
        Heading=heading; Description=descString; Email = email; Project=project;
    }
}
