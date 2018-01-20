/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataObjects;
import java.util.*;
/**
 *
 * @author narasimha
 */
public class PrefetchCache {
    static ArrayList<ProjectOb> cachedObject;
    public static void putToCache(ArrayList<ProjectOb> obj){
        cachedObject =obj;
    }
    public static ArrayList<ProjectOb> getCachedProject(){
        return cachedObject;
    }
}
