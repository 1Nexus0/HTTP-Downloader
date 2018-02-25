/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
  

