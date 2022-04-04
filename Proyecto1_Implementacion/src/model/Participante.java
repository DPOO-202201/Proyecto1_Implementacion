package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Participante
{
	private String nombre;
	private String correo;
	private boolean isDuenio;
	private ArrayList<Actividad> actividadesRealizadas;
	
	public Participante(String nombre, String correo, boolean isDuenio) 
	{
		this.nombre = nombre;
		this.correo = correo;
		this.isDuenio = isDuenio;
		this.actividadesRealizadas = new ArrayList<Actividad>();
	}

	public String getNombre()
		{
			return this.nombre;
		}

	public ArrayList<Actividad> getActividades()
		{
			return this.actividadesRealizadas;
		}
	
	public int tiempoTotalActividades() {
		return 0;
		}
	
	public HashMap<String,Integer> tiempoPromedioPorActividad() {
		HashMap<String,Integer[]> timeMap = new HashMap<String,Integer[]>();
		for(int i=0; i<actividadesRealizadas.size(); i++) {
			Actividad actual = actividadesRealizadas.get(i);
			if(timeMap.containsKey(actual.getTipo())){
				Integer[] val = timeMap.get(actual.getTipo());
				val[0]++;
				val[1]+=actual.getTiempoRelizacion();
				timeMap.put(actual.getTipo(),val);
			}
			else {
				Integer[] val = {1,actual.getTiempoRelizacion()};
				timeMap.put(actual.getTipo(), val);
			}	
		}
		HashMap<String,Integer> mapDef = new HashMap<String,Integer>();
		for(String llave : timeMap.keySet()) {
			Integer[] val = timeMap.get(llave);
			mapDef.put(llave, val[1]/val[0]);
		}
		return mapDef;
	}
		
}
