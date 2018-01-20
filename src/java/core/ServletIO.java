/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;
import java.sql.*;
import dataObjects.PrefetchCache;
import java.io.*;
import java.util.Base64;
/**
 *
 * @author narasimha
 */
public class ServletIO {
    public boolean synchronous_streamWriter(byte[] filedata, String filename,String filepath){
        try{
            File file=new File(filepath+filename);
            FileOutputStream fs=new FileOutputStream(file);
            fs.write(filedata);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    
    public void asynchronous_streamWriter(byte[] filedata,String filename,String filepath){
        new Thread(new Runnable() {
            @Override
            public void run() {
                 try{
            File file=new File(filepath+filename);
            FileOutputStream fs=new FileOutputStream(file);
            fs.write(filedata);
        }catch(Exception e){
            e.printStackTrace();
             }
         }
        }).start();
    }
    
    public String baseX64_streamEncoder(byte [] stream)throws UnsupportedEncodingException{
        byte[] encoded_x64_byte_stream = Base64.getEncoder().encode(stream);
        return  new String(encoded_x64_byte_stream, "UTF-8");
    }
    
    public void async_cache_all_projects(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    DatabaseProjects dbp = new DatabaseProjects();
                    PrefetchCache.putToCache(dbp.getAll());
                } catch (Exception e) {
                }
            }
        }).start();
    }
    
}
