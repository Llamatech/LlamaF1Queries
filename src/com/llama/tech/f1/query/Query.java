package com.llama.tech.f1.query;

import java.net.MalformedURLException;
import java.net.URL;

public class Query 
{
	private final static String ROOT = "http://ergast.com/api/f1/";
	
	public static int getTotalSeasons() throws MalformedURLException
	{
		URL urlReq = new URL(ROOT+"seasons");
		return 0;
		
		
	}

}
