package com.llama.tech.f1.backbone;

import java.io.Serializable;

import com.llama.tech.f1.utils.Lista;

public class F1 implements IF1, Serializable
{
	/**
	 *  Constante de Serialización. 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Lista<Temporada> temporadas;

	

	@Override
	public boolean deletePilotRecord(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCircuitRecord(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String[] getSeasonInfo(String year) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getSeasonList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getCircuitInfo(String name, String year) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getPilotInfo(String name, String year) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getConstructorInfo(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[][] getHistoricalSeasonInfo(String initialDate,
			String finalDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cargarTemporadas(String[] temporadas) {
		// TODO Auto-generated method stub
		
	}
	
	public void cargarCarrerasTemporada(int anho, String[]infoCarreras)
	{
		temporadas.get(anho-1950).cargarCarreras(infoCarreras);
	}
	
	public void cargarPilotosTemporada(int anho, String[]infoPilotos)
	{
		temporadas.get(anho-1950).cargarPilotos(infoPilotos);
	}
	
	public void cargarEscuderiasTemporada(int anho, String[]infoEscuderias)
	{
		temporadas.get(anho-1950).cargarEscuderias(infoEscuderias);
	}
}
