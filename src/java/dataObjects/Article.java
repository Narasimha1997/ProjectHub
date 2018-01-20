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
public class Article {
    
    public int UID, Likes, BID;
    public String Heading, Content;
    public byte [] Image;
    
    public void putArticleHead(int uid, int BID,  int likes, String heading, byte [] image){
        UID=uid; Likes = likes; Heading = heading;  Image = image; this.BID = BID;
    }
    
    public void putOneArticle(int uid, int BID, int likes, String heading, String content, byte[] image){
        UID=uid; Likes=likes; Heading=heading; Content=content; Image=image; this.BID = BID;
    }
    

}
