package com.llama.tech.f1.backbone;

public interface IF1 
{	
	public String[] getSeasonInfo(String year);
	
	public String[] getSeasonList();
	
	public String[] getCircuitInfo(String name, String year);
	
	public String[] getPilotInfo(String name, String year);
	
	public String[] getConstructorInfo(String name);
	
	public String[][] getHistoricalSeasonInfo(String initialDate, String finalDate);
	
	public boolean deletePilotRecord(String name);
	
	public boolean deleteCircuitRecord(String name);
	
	
}
