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
public class ProfilesResult {
    public static int index;
    public static String username, phone, email;
    public static int UID, proj_num;
    public static byte[] image_data;
    public static String desc;
    
    public  int Index;
    public  String Username, Phone, Email;
    public  int uid, Projects;
    public  byte[] Image;
    public  String Desc;
    
    public static void putValues(int i, int U, int proj_n, String user, String ph, String em, byte [] image ,String dsc){
        index=1; username=user; phone=ph; email=em; UID=U; proj_num=proj_n; image_data=image;
        desc = dsc;
    }
     public void putValues_nonStatic(int i, int U, int proj_n, String user, String ph, String em, byte [] image ,String dsc){
        Index=1; Username=user; Phone=ph; Email=em; uid=U; Projects=proj_n; Image=image;
        Desc = dsc;
    }
}
