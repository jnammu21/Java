/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package themepark;

/**
 *
 * @author Namrata Jagannath
 */
public class Rider {
    
    private String rider;
    private int Ride;
    private int ArrivalTime;
    
    public void setrider(String s)
    {
        rider=s;
    }
    public String getrider()
    {
        return rider;
    }

    public void setRide(int r)
    {
        Ride=r;
    }
    public int getRide()
    {
        return Ride;
    }

    public void setArrivalTime(int at)
    {
        ArrivalTime=at;
    }
    public int getArrivalTime()
    {
        return ArrivalTime;
    }
    
    public Rider(String s, int ride, int arrival)
    {
        setrider(s);
        setArrivalTime(arrival);
        setRide(ride);
    }
}
