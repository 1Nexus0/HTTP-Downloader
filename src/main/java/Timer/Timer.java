/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Timer;


public class Timer {
    //Counts program work time
    public String programWorked (double startTime){
     String wT;   
     double WorkingTime = (System.currentTimeMillis() - startTime);
     
    int WorkingTimeI = (int) WorkingTime /1000;
 
    if ((WorkingTimeI  > 60) && (WorkingTimeI < 3600)){
        int WorkingTimeMin = WorkingTimeI / 60 ;
        int  WorkingTimeSec = WorkingTimeI % 60;
        wT = String.format("%d minutes %02d seconds", 
                WorkingTimeMin, WorkingTimeSec);
       
    } else if ((WorkingTimeI >= 3600) && (WorkingTimeI < 3600*24 )) {
        int WorkingTimeHours = WorkingTimeI  / 3600;
        int WorkingTimeMin = (WorkingTimeI / 60) % 60;
        wT = String.format("%d hours %02d minutes", 
                WorkingTimeHours, WorkingTimeMin);
        
    } else if (WorkingTimeI >= 3600*24) {
        int WorkingTimeDays = WorkingTimeI  / (3600*24);
        int WorkingTimeHours = (WorkingTimeI  / 3600)%24;
        wT = String.format("%d Days %02d hours",
                WorkingTimeDays, WorkingTimeHours);
        
    
    } else {
        wT= WorkingTimeI + " seconds";
    }
  
    return wT;
    } 
}
