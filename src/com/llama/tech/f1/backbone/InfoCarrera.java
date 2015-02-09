package com.llama.tech.f1.backbone;

import com.llama.tech.utils.misc.LlamaTuple;

public class InfoCarrera 
{
     private String id;
     private String[] timesPerLap;
     private LlamaTuple[] pitStops;

     
     public InfoCarrera(String id, String[] laps, String[] pitStops)
     {
    	 this.id = id;
    	 timesPerLap = laps;
    	 this.pitStops = new LlamaTuple[pitStops.length];
    	 int i = 0;
    	 for(String pit: pitStops)
    	 {
    		 String[] info = pit.split(",");
    		 int lap = Integer.parseInt(info[0]);
    		 this.pitStops[i] = new LlamaTuple<Integer, String>(lap, info[1]);
    	 }
     }
}
