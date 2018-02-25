/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.ConfigXML;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
 
import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartDocument;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

/**
 *
 * @author MistyukovE
 */
public class ConfigFileWriteXML {
    private final String progDir = System.getProperty("user.home") +
            File.separator + "Documents" + File.separator +
            "JavaDownloader" + File.separator + "settings.xml";
    
    public void ConfigFileWriteXML (){
   /* 
        String rootElement = "Employee";
        Map<String,String> elementsMap = new HashMap<>();
        
        
        writeXML(progDir, rootElement, elementsMap);
     */
    
    }
    

     
    public void writeXML(String fileName, String rootElement, Map<String, String> elementsMap){
        XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
        try {
            XMLEventWriter xmlEventWriter = xmlOutputFactory
                    .createXMLEventWriter(new FileOutputStream(fileName), "UTF-8");
            //For Debugging - below code to print XML to Console
            //XMLEventWriter xmlEventWriter = xmlOutputFactory.createXMLEventWriter(System.out);
            XMLEventFactory eventFactory = XMLEventFactory.newInstance();
            XMLEvent end = eventFactory.createDTD("\n");
            StartDocument startDocument = eventFactory.createStartDocument();
            xmlEventWriter.add(startDocument);
            xmlEventWriter.add(end);
            StartElement configStartElement = eventFactory.createStartElement("",
                "", rootElement);
            xmlEventWriter.add(configStartElement);
            xmlEventWriter.add(end);
            // Write the element nodes
            Set<String> elementNodes = elementsMap.keySet();
            for(String key : elementNodes){
                createNode(xmlEventWriter, key, elementsMap.get(key));
            }
             
            xmlEventWriter.add(eventFactory.createEndElement("", "", rootElement));
            xmlEventWriter.add(end);
            xmlEventWriter.add(eventFactory.createEndDocument());
            xmlEventWriter.close();
 
        } catch (FileNotFoundException | XMLStreamException e) {
        }
    }
     
    private static void createNode(XMLEventWriter eventWriter, String element,
            String value) throws XMLStreamException {
          XMLEventFactory xmlEventFactory = XMLEventFactory.newInstance();
          XMLEvent end = xmlEventFactory.createDTD("\n");
          XMLEvent tab = xmlEventFactory.createDTD("\t");
          //Create Start node
          StartElement sElement = xmlEventFactory.createStartElement("", "", element);
          eventWriter.add(tab);
          eventWriter.add(sElement);
          //Create Content
          Characters characters = xmlEventFactory.createCharacters(value);
          eventWriter.add(characters);
          // Create End node
          EndElement eElement = xmlEventFactory.createEndElement("", "", element);
          eventWriter.add(eElement);
          eventWriter.add(end);
 
        }
 
}

