package themepark;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @param <T>
 * @author Namrata Jagannath
 */
public final class Ride <T>{
    private T[] Regular;
    private T[] FastTrack;

    private int rearFast;
    private int rearRegular;
    private int frontFast;
    private int frontRegular;
    private int size_t;
    public  int rideTime;
    public int totalbusytime;
    public float averageTimeSpent;
    public int maxWaitingTime;
    public int averagewaitingTime;
    public int ridercount=0;

    public Ride(){
        rearRegular=0;
        frontRegular = 0;
        rearFast=0;
        frontFast = 0;
        size_t = 120;
        rideTime=3;
        totalbusytime=0;
        averageTimeSpent=0;
        maxWaitingTime=0;
        averagewaitingTime=0;
        InitializeQ();
    }
    public Ride(int size_t,int t){
        this.size_t=size_t;
        this.rideTime=t;
        InitializeQ();
    }
    
    public void InitializeQ()
    {
        FastTrack = (T[]) new Object[size_t];
        Regular =(T[]) new Object[size_t];
    }
 
    public boolean enQueueRegular(T x)
    {
        if(rearRegular==size_t-1)
        {
            System.out.println("Queue is full");
        }
        else
        {
            ridercount++;
            Regular[rearRegular++]=x;
            return true;
        }
        return false;
    }
    
    public T deQueueRegular()
    {
        if(frontRegular<rearRegular)
        {
            frontRegular++;
            return Regular[frontRegular-1];
        }
        else
            System.out.println("Queue is empty");

        return null;
    }

     public T lookRegular()
     {
        if(frontRegular<rearRegular)
        {
            return Regular[frontRegular];
        }
        return null;
     }
     
    public T lookFast()
     {
        if(frontRegular<rearRegular)
        {
            return FastTrack[frontRegular];
        }
        return null;
    }

    public boolean enQueueFast(T x)
    {
        if(rearFast==size_t-1)
        {
            System.out.println("Queue is full");
        }
        else
        {
            ridercount++;
            Regular[rearFast++]=x;
            return true;
        }
        return false;
    }
    
    public T deQueueFast()
    {
        if(frontFast<rearFast)
        {
            frontFast++;
            return Regular[frontFast-1];
        }
        else
            System.out.println("Queue is empty");

        return null;
    }
    
    public void display()
    {
        System.out.println("Regular Queue contents");
        for (int i = frontRegular; i != rearRegular; i=(++i)%size_t) {
            System.out.println("["+i+"] ="+ Regular[i]);
        }
        System.out.println("Fast Queue contents");
        for (int i = frontFast; i != rearFast; i=(++i)%size_t) {
            System.out.println("["+i+"] ="+ FastTrack[i]);
        }
    }

}
