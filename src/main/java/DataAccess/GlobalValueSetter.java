/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

/**
 *
 * @author MistyukovE
 */
public final class GlobalValueSetter {
    private static String streams;
    private static String speed;
    private static String filePath;
    private static String output;
    private static String urls;
    private static String prox;
    private static long totalBytes;
    
    
    public static String getStreams (){
    return streams;
    }
     
    public static void setStreams(String setStreams){
      streams = setStreams;
    }
    //==========================================
    
    public static String getProx(){
    
    return prox;
    }
    
    public static void setProx (String setProx){
    
    prox=setProx;
    }
    //==========================================
     public static String getSpeed(){
    return speed;
    }
    
    public static void  setSpeed(String setSpeed){
    speed= setSpeed;
    }
    //==========================================
     public static String getFilePath(){
    return filePath;
    }
    
    public static void setFilePath(String setFilePath){
    filePath = setFilePath;
    }
    //==========================================
    
   public static String getOutput (){
    return output;
    }
    
    public static void setOutput (String setOutput){
    output = setOutput;
    }
    //==========================================
    public static String getURL (){
    return urls;
    }
    
    public static void setURL (String setUrls){
    urls = setUrls;
    }
    //==========================================
    public static long getTotalBytes(){
    return totalBytes;
    }
    
    public static void setTotalBytes(long setTotalBytes){
    
    long totalBytesNew = getTotalBytes() + setTotalBytes;
    
    totalBytes = totalBytesNew;
    
    }
    
}
