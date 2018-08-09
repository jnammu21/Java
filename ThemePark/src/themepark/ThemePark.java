/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package themepark;

import java.util.Random;
/**
 *
 * @author Namrata Jagannath
 */
public class ThemePark {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Random rand = new Random();
        int  n = rand.nextInt(10) + 1;        

        Ride<Rider>[] Rides = new Ride[n];
        
        for (int i = 0; i < n; i++) {
            int  t = rand.nextInt(5) + 1;        
            Rides[i]=new Ride(5,t);
        }

        System.out.println("Number of rides: "+n);
        for (int time = 1; time <= 60; time++) {
          
            n = rand.nextInt(100) + 1;        
            System.out.println("Riders in the session");

            if(n<50)
                continue;
            else if(n<90)
            {
                String s = "Rider"+time;

                n = rand.nextInt(Rides.length);
                Rider r = new Rider(s, n, time);
                
                int prob = rand.nextInt(100)+1;
                if(prob<50)
                    Rides[n].enQueueFast(r);
                else
                    Rides[n].enQueueRegular(r);
                
                System.out.println(s+"( "+time+"_"+prob+") => Ride "+n );
            }   
            else
            {
                for (int j = 0; j <2; j++) {
                    String s="Rider"+time*j;
                    n = rand.nextInt(Rides.length);
                    Rider r = new Rider(s, n, time);
                    
                int prob = rand.nextInt(100)+1;
                if(prob<50)
                    Rides[n].enQueueFast(r);
                else
                    Rides[n].enQueueRegular(r);
                System.out.println(s+"( "+time+"_"+prob+") => Ride "+n );
                }
            }

            Rider t;
            
            for (int j = 0; j < Rides.length; j++) {
                t= Rides[j].lookFast();
                if(t!=null)
                    if((t.getArrivalTime()+Rides[j].rideTime)>=time)
                    {
                        Rides[j].averageTimeSpent=Rides[j].averageTimeSpent+((time-t.getArrivalTime())+Rides[j].rideTime)/Rides[j].ridercount;
                        Rides[j].averagewaitingTime = Rides[j].averagewaitingTime+(time-t.getArrivalTime())/Rides[j].ridercount;
                        Rides[j].totalbusytime+=Rides[j].rideTime;
                       if(Rides[j].maxWaitingTime<(time-t.getArrivalTime()))
                            Rides[j].maxWaitingTime=(time-t.getArrivalTime());
                        Rides[j].deQueueFast();                        
                    }
                t= Rides[j].lookRegular();
                if(t!=null)
                    if((t.getArrivalTime()+Rides[j].rideTime)>=time)
                    {
                        Rides[j].totalbusytime+=Rides[j].rideTime;
                        Rides[j].averageTimeSpent=(Rides[j].averageTimeSpent+(time-t.getArrivalTime())+Rides[j].rideTime)/Rides[j].ridercount;
                        Rides[j].averagewaitingTime = (Rides[j].averagewaitingTime+time-t.getArrivalTime())/Rides[j].ridercount;
                        if(Rides[j].maxWaitingTime<(time-t.getArrivalTime()))
                            Rides[j].maxWaitingTime=(time-t.getArrivalTime());
                        Rides[j].deQueueRegular();
                    }
                
                print(time,Rides);
            }   
        }
    }

    public static void print(int time,Ride<Rider>[] Rides)
    {
           System.out.println("Time: "+time);
                int taveragewaitingTime=0;
                int taverageTimeSpent=0;
                int tmaxWaitingTime=0;
                int thr=0;

                System.out.println("Waiting lines");
                
                for (int k = 0; k < Rides.length; k++) {
                    taveragewaitingTime+=Rides[k].averagewaitingTime;
                    taverageTimeSpent+=Rides[k].averageTimeSpent;
                    tmaxWaitingTime+=Rides[k].maxWaitingTime;
                    thr+=Rides[k].ridercount;
                    
                    System.out.print("Ride "+k+"- "+Rides[k].rideTime+"min(s) [ "+Rides[k].ridercount+" rides] \t\t");
                }
                System.out.println("");
                System.out.println("Statistics");
                System.out.println("Average waiting time\taverage time spent\tmaximum waiting time\tnumber of happy riders");

                System.out.println("\t"+taveragewaitingTime+"\t\t\t"+taverageTimeSpent+"\t\t\t"+tmaxWaitingTime+"\t\t\t"+thr);
     
    }
}
                  