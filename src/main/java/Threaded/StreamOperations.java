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


   

   
