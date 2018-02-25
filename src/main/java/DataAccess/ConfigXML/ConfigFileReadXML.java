/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.ConfigXML;

import DataAccess.GlobalValueSetter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.stream.XMLStreamException;

/**
 *
 * @author MistyukovE
 */
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
