/*
 * InfoCarrera.java
 * This file is part of F1ChampionshipQueries
 * Copyright (C) 2015 - LlamaTech Team 
 *
 * F1ChampionshipQueries is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * F1ChampionshipQueries is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with F1ChampionshipQueries. If not, see <http://www.gnu.org/licenses/>.
 * 
 */

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
