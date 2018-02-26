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
