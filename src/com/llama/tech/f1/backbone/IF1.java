package com.llama.tech.f1.backbone;

public interface IF1 
{	
	public Temporada getSeasonInfo(String year);
	
	public String[] getSeasonList();
	
	public Carrera getCircuitInfo(String name, String year);
	
	public Piloto getPilotInfo(String name, String year);
	
	public Escuderia getConstructorInfo(String name);
	
	public Carrera[] getHistoricalSeasonInfo(String initialDate, String finalDate);
	
	public boolean deletePilotRecord(String name);
	
	public boolean deleteCircuitRecord(String name);
	
}
