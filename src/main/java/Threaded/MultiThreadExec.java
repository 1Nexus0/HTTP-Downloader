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

import DataAccess.Connector;
import DataAccess.GlobalValueSetter;
import DataAccess.Parsers;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MultiThreadExec  {
    

 
public void runner () {
    try {
        String filePath = GlobalValueSetter.getFilePath();
        String outputFile = GlobalValueSetter.getOutput();
        
        ArrayList <Future> taskRet= new ArrayList<>();
        
        ExecutorService execSrv = Executors.newFixedThreadPool(Integer.
                parseInt(GlobalValueSetter.getStreams()));
        
        String[] getter= new Parsers().arrUrls(filePath);
        for (String ter : getter) {   
             GlobalValueSetter.setURL(ter);
             taskRet.add(execSrv.submit(new RunnableImplement(ter, outputFile)));
             
        }
        for (int i=0;i<taskRet.size();i++){
            Future z= taskRet.get(i);
            try {
                z.get();
                
            } catch (InterruptedException | ExecutionException ex) {
                Logger.getLogger(MultiThreadExec.class.
                        getName()).log(Level.SEVERE, null, ex);
            }
        }
        execSrv.shutdown();
    } catch (FileNotFoundException ex) {
        Logger.getLogger(MultiThreadExec.class.
                getName()).log(Level.SEVERE, null, ex);
    }
     

  }

    private static class RunnableImplement implements Runnable {

        private final String ter;
        private final String outputFile;
        

        public RunnableImplement(String ter, String outputFile) {
            this.ter = ter;
            this.outputFile = outputFile;
           
        }

        @Override
        public void run() {
            try {
                
                System.out.println(Thread.currentThread().getName()+ "URL "+ter);
                String fileName = ter.substring(ter.lastIndexOf('/') + 1);
                
                URLConnection conn = new Connector().connector(ter);
                String Contl =  conn.getHeaderField("Content-Length");
                long fileSize=0;
                
                if (!(Contl==null)){
                    fileSize = Long.parseLong(conn.getHeaderField("Content-Length"));
                }
                String fileNameRaw = conn.getHeaderField("Content-disposition");
                
                if(fileNameRaw != null && fileNameRaw.contains("=")) {
                    
                    fileName = fileNameRaw.split("=")[1]; //getting value after '='
                }
                
                fileName = new Parsers().fileNamesParser(fileName,outputFile);
                
                File OutStream = new File (outputFile + File.separator + fileName); //Output file write
                
                new StreamOperations().streamOperations (OutStream, conn);
                GlobalValueSetter.setTotalBytes(fileSize);
                
            } catch (IOException ex) {
                Logger.getLogger(MultiThreadExec.class.
                        getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
  
}