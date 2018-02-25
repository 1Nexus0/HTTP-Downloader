package Main;


import DataAccess.GlobalValueSetter;
import Timer.Timer;
import java.io.IOException;
import Threaded.MultiThreadExec;
import GUI.HttpDLMain;


public class Main  {
    
   
  
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
   public static void main (String[] args) throws IOException{
    double startTime = System.currentTimeMillis();
    
    for (int i=0; i<args.length; i++){
    if (args[i].startsWith("-")){
        switch (args[i]){
            case "-n":
              GlobalValueSetter.setStreams(args[i+1]);
              break;
            case "-l":
                GlobalValueSetter.setSpeed(args[i+1]);
                break;
            case "-f":
                GlobalValueSetter.setFilePath(args[i+1]);
                break;
            case "-o":
                GlobalValueSetter.setOutput(args[i+1]);
                break;
            case "-prox":
                GlobalValueSetter.setProx(args[i+1]);
                break;
            default:
                System.out.println("args not specified");
                 break;
        
        }
            }
          }
  
if (args.length > 1) {
   new MultiThreadExec().runner();
     
   System.out.println ("==========Statistics:==========");
   System.out.println("Program worked: " + new Timer().programWorked(startTime));
   System.out.println ("Downloaded: " + GlobalValueSetter.getTotalBytes()+ " bytes");
   System.out.println ("===============================");

} else {
   
  
  new HttpDLMain().setVisible(true);
   
     }
   
   }
 
}

  






