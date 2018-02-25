/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threaded;


import DataAccess.Parsers;
import DataAccess.GlobalValueSetter;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;





public class StreamOperations  {
    
InputStream in;
long timestamp = System.currentTimeMillis();
int counter = 0;
int INTERVAL = 1000; // per second
int SPEED_LIMIT=1073741824; // bytes limit per INTERVAL
int setSpeed = new Parsers().speeds(GlobalValueSetter.getSpeed());
   
 //Write input stream to output file.
 public synchronized void streamOperations(File output,
         URLConnection inp) throws IOException {
            
        if (setSpeed > 0){
            SPEED_LIMIT = setSpeed;
        }
        
        int count;
           
        in = new BufferedInputStream (inp.getInputStream()) {
         
        @Override
        public int read () throws IOException{
          if (counter > SPEED_LIMIT) {
        long now = System.currentTimeMillis();
        if (timestamp + INTERVAL >= now) {
            try {  
                 
                Thread.sleep(timestamp + INTERVAL - now);
               
            } catch (InterruptedException ex) {
                Logger.getLogger(StreamOperations.class.
                        getName()).log(Level.SEVERE, null, ex);
            }
        }
        timestamp = now;
        counter = 0;
    }
    int res = in.read();
    if (res >= 0) {
        counter++;
    }
    
    return res;
         
}
        };
        
    try (FileOutputStream outfile = new FileOutputStream(output)) {
        while ((count=in.read()) != -1){
            
            outfile.write(count);
            
        }
       
        
    }
    in.close();
        }
 
    }


   

   
