/*
 * Copyright (C) 2017
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package DataAccess;

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
