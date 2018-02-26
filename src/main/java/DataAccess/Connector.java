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

import java.io.IOException;
import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;



public class Connector {
    //HTTP/HTTPS connector
  public synchronized URLConnection connector (String url) throws ProtocolException, IOException{
URLConnection conn;
boolean prox = false;

if (GlobalValueSetter.getProx()!= (String)null) {
    prox=true;
}

if (prox){
    String [] prx = GlobalValueSetter.getProx().split(":");
    conn = new URL(url).openConnection(autentificationProxy(prx[0],prx[1],prx[2],Integer.parseInt(prx[3])));
} else {
conn = new URL(url).openConnection();
}

//HttpURLConnection 
conn.setDoInput(true);
conn.setDoOutput(true);
conn.connect();
return conn;
  }
    
 
  
  private Proxy autentificationProxy (String userName, String password,String proxyServer,int port) {
  Authenticator authenticator;
   Proxy proxy;
   
       authenticator = new AuthenticatorImplement(userName, password);  //If proxy is required
     
    Authenticator.setDefault(authenticator);
    
 proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyServer,port));
 return proxy;
  }

    private static class AuthenticatorImplement extends Authenticator {

        private final String userName;
        private final String password;

        public AuthenticatorImplement(String userName, String password) {
            this.userName = userName;
            this.password = password;
        }
        
        @Override
        public PasswordAuthentication getPasswordAuthentication() {
            return (new PasswordAuthentication(userName,password.toCharArray()));
        }
    }


}
  

