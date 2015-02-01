package com.llama.tech.f1.query;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class ImageContent 
{
	 private URL url;
	 private String contents;
	
     public ImageContent(String uri) throws IOException
     {
    	 url = new URL(uri);
    	 try(BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream())))
         {
    		 contents = "";
    		 String inputLine;
    		 while ((inputLine = in.readLine()) != null)
    		 {
    			 contents += inputLine+"\n";
    		 }
         }
     }
     
     
}
