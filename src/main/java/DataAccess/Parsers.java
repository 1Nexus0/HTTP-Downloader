/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.*;


public class Parsers {
  //Input URL's file parser  
  public String[] arrUrls (String InputFile) throws FileNotFoundException {
      
   FileInputStream in = new FileInputStream(InputFile);
   StringBuilder finalout = new StringBuilder();
  
       try (BufferedReader rd =
               new BufferedReader (new InputStreamReader (in,"UTF-8"))){
            String line;
            while ((line = rd.readLine()) != null){
                   if ((!line.isEmpty()) 
                            && (!line.substring(0, 1).equals("#"))) {
                   finalout.append(line);
                   finalout.append('\n');
                      }
                   }
            in.close();
            } catch (IOException e) {
       System.out.println("Input File exception: " + InputFile);
       }
       
   return  finalout.toString().split("[\\r\\n]+");
   }
   
   
   //Output Filename rename if exist
   public String fileNamesParser (String fileName, String InputPath) {
    
      String fullPath = InputPath + File.separator +fileName;
      File inputFile = new File (fullPath);
      Pattern p = Pattern.compile("(.*?)(?:\\((\\d+)\\))?(\\.[^.]*)?");
     
      
   if (inputFile.exists()) {
       
      Matcher m = p.matcher(fileName);
      if (m.matches()){

          String main = m.group(1);
          String ord = m.group(2);
          String ext = m.group(3);
          if (ext== null) ext= "";
      
          int order = ord != null ? Integer.parseInt(ord) : 0;
      
      do {
          order++;
          fileName= main + "("+order+")"+ ext;
      } while (new File (InputPath + File.separator + fileName).exists());
        
      }
   } 
  
   return fileName;
   }
   
   //Parse int speed from string. Format: 1000k, 10m
   public int speeds (String speed){  
     if (speed != (String) null) {
   String speedParse = speed.substring(speed.length()-1);
   
   int speeds;
   if ("k".equals(speedParse)) {
   speeds = Integer.parseInt(speed.substring(0,speed.length()-1));
   
   speeds = speeds * 1024;
   } else {
   speeds = Integer.parseInt(speed.substring(0,speed.length()-1));
   speeds = speeds * (1024*1024);
   }
   return speeds;
   }
    return  0; 
   }
   
   
}
  
  


