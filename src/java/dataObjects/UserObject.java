/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataObjects;

import java.io.InputStream;

/**
 *
 * @author narasimha
 */
public class UserObject {
    public static int user_id;
    public static String user_name;
    public static String user_email;
    public static String user_password;
    public static byte [] user_profile;
    public static String f_name;
    public static int proj;
    public static String descr;
    public static String phone;
    
    public static void setUserData(int id,String name,String email,String password,int projects,String fn,String ph,byte [] fs, String desc){
        user_id=id; user_name=name; user_email=email; user_password=password; user_profile=fs; f_name=fn; phone=ph;
        proj=projects; descr=desc;
    }
}
