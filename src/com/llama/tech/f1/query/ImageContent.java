/*
 * ImageContent.java
 * This file is part of F1ChampionshipQueries
 * Copyright (C) 2015 - LlamaTech Team 
 *
 * JSoup
 * Copyright (c) 2004-2009 Jonathan Hedley (jonathan@hedley.net)
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

package com.llama.tech.f1.query;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ImageContent 
{
	
     public static String getDriverConstructorImageContent(String url, String loc) throws Exception
     {
    	 Element objElem = null; 
    	 Document doc = Jsoup.connect(url).get();
    	 Elements elemts = doc.select("table");
    	 boolean found = false;
    	 String pointer = null;
    	 
         for(int i = 0; i < elemts.size() && !found; i++)
         {
        	 Element elem = elemts.get(i);
        	 String tab = elem.attr("class");
        	 if(tab.contains("infobox") && tab.contains("vcard"))
        	 {
        		 if(elem.select("td").get(0).attr("style").equals("text-align:center"))
        		 {
        			 objElem = elem.select("td").get(0);
        		     found = true;
        		 }
        	 }
         }
         
         if(objElem != null)
         {
        	 try
        	 {
        		 String uri = objElem.select("img").get(0).attr("src");
        		 uri = "http:"+uri;
            	 System.out.println(uri);
            	 String[] parts = uri.split("[.]");
            	 String ext = parts[parts.length-1];
            	 
            	 URL imgURL = new URL(uri);
            	 try(InputStream in = new BufferedInputStream(imgURL.openStream()))
            	 {
            	 
    	        	 try(OutputStream out = new BufferedOutputStream(new FileOutputStream(loc+"."+ext)))
    	        	 {
    	        		 for ( int i; (i = in.read()) != -1; ) 
    	        		 {
    	        			    out.write(i);
    	        		 }
    	        	 }
            	 }
            	 
            	 pointer = loc+"."+ext;
            	 return pointer;
        	 }
        	 catch(Exception e)
        	 {
        	 }
         }
         
         return null;
     }
}
