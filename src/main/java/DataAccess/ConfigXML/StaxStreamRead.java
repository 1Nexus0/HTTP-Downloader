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

import java.io.InputStream;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;


public class StaxStreamRead implements AutoCloseable{
      private static final XMLInputFactory FACTORY = XMLInputFactory.newInstance();

    private final XMLStreamReader reader;

    public StaxStreamRead(InputStream is) throws XMLStreamException {
       reader = FACTORY.createXMLStreamReader(is);
    }

    public XMLStreamReader getReader() {
       return reader;
    }
    
    public boolean startElement(String element, 
            String parent) throws XMLStreamException {
    while (reader.hasNext()) {
       int event = reader.next();
       if (parent != null 
               && event == XMLEvent.END_ELEMENT 
               && parent.equals(reader.getLocalName())) {
          return false;
       }
       if (event == XMLEvent.START_ELEMENT 
               && element.equals(reader.getLocalName())) {
          return true;
       }
    }
    return false;
}
    
    public String getText() throws XMLStreamException {
   return reader.getElementText();
}

    @Override
    public void close() {
       if (reader != null) {
          try {
             reader.close();
          } catch (XMLStreamException e) { 
          System.out.println("Stream cannot be closed");
          }
       }
    }
    
    
}
