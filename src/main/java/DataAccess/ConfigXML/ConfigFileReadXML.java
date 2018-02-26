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

package DataAccess.ConfigXML;

import DataAccess.GlobalValueSetter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.stream.XMLStreamException;


public class ConfigFileReadXML {
    
    private final String progDir = System.getProperty("user.home") 
            + File.separator + "Documents" + File.separator + 
            "JavaDownloader" + File.separator + "settings.xml";
   
    
    public void  loadConfigFileReadXML () {
    
    File target = new File (progDir);
    if (target.exists()) {
         mReadXml ();
    }
   
    
    }
    
    private void mReadXml (){
        
    String delim = ":";
        
    GlobalValueSetter.setFilePath(mWrapperGetParam ("InputFile","DirectoryPath"));
         
    GlobalValueSetter.setOutput(mWrapperGetParam ("OutputPath","DirectoryPath"));
     
    String Name = mWrapperGetParam ("Name","ProxySettings");
          
    String Pass = mWrapperGetParam ("Password","ProxySettings");
          
    String Addr = mWrapperGetParam ("Address","ProxySettings");
          
    String Port = mWrapperGetParam ("Port","ProxySettings");
  
    GlobalValueSetter.setProx(Name + delim + Pass + delim + Addr+ delim +Port);
          
        
   
    }
    
    
    
    
    private String mWrapperGetParam (String startElem, String parentElem) {
    String out = null;
  try (StaxStreamRead streamRead = new StaxStreamRead(
          new FileInputStream(progDir))) {
      
     while (streamRead.startElement(startElem,parentElem)){
          out = streamRead.getText();
         
          } 
    
    }   catch (FileNotFoundException | XMLStreamException ex) {
            Logger.getLogger(ConfigFileReadXML.class.
                    getName()).log(Level.SEVERE, null, ex);
        }
     return out; 
    }
    
}
